package com.hanson.transform.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hanson.transform.enums.HouseStateEnum;
import com.hanson.transform.service.SYFCSalesBuildMongoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SYFCSalesBuildMongoServiceImpl implements SYFCSalesBuildMongoService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void saveCommunity() {
        List<JSONObject> communityList = mongoTemplate.findAll(JSONObject.class, "syfc_new_build_detail");
        for (JSONObject community : communityList) {
            Query query = new Query();
            query.addCriteria(Criteria.where("community_id").is(community.getInteger("third_record_id")));
            Update update = Update.update("program_describe", community.get("program_describe"))
                    .set("district", community.get("district"))
                    .set("approve_date", community.get("start_sales_date"))
                    .set("subordinate_district", community.get("subordinate_district"))
                    .set("company", community.get("company"))
                    .set("build_count", community.getInteger("build_count"))
                    .set("community_id", community.getInteger("third_record_id"))
                    .set("update_time", community.get("update_time"));
            mongoTemplate.upsert(query , update, JSONObject.class,"syfc_community");
        }
    }

    @Override
    public void saveBuilds() {
        //未清洗的
//		Query communityQuery = new Query();
//		communityQuery.addCriteria(Criteria.where("gen_mongo_build").ne(1));
//		List<JSONObject> communityList = mongoTemplate.find(communityQuery,JSONObject.class, "syfc_community");
        List<JSONObject> communityList = mongoTemplate.findAll(JSONObject.class, "syfc_new_build_detail");
        long count = 0;
        for (JSONObject community : communityList) {
//			communityQuery.addCriteria(Criteria.where("third_record_id").is(community.getString("community_id")));
//			JSONObject old_community = mongoTemplate.findOne(communityQuery,JSONObject.class, "syfc_new_build_detail");
            JSONArray jsonArray = community.getJSONArray("build_detail_list");
            count+= jsonArray.size();
            for (Object building : jsonArray) {
                JSONObject buildingJSON = (JSONObject)building;
                Query query = new Query();
                String org_third_record_id = null;
                try {
                    buildingJSON.getInteger("third_record_id");
                } catch (Exception e) {
                    //只保留数字
                    String building_id = buildingJSON.getString("third_record_id");
                    org_third_record_id = building_id;
                    String regEx="[^0-9]";
                    Pattern p = Pattern.compile(regEx);
                    Matcher m = p.matcher(building_id);
                    buildingJSON.put("third_record_id",m.replaceAll(""));
                }
                query.addCriteria(Criteria.where("building_id").is(buildingJSON.getInteger("third_record_id")));
                Update update = Update.update("build_location", buildingJSON.get("build_location"))
                        .set("sales_available_count", buildingJSON.get("sales_available_count"))
                        .set("sales_unvailable_count", buildingJSON.get("sales_unvailable_count"))
                        .set("saled_count", buildingJSON.get("saled_count"))
                        .set("can_sales_count", buildingJSON.get("can_sales_count"))
                        .set("community_id", community.getInteger("third_record_id"))
                        .set("building_id", buildingJSON.getInteger("third_record_id"));
                if(org_third_record_id != null) {
                    update.set("org_third_record_id", org_third_record_id);
                }
                mongoTemplate.upsert(query , update, JSONObject.class,"syfc_building");
            }
            //更新community的buildCount
            this.updateCommunityBuildCount(community.getInteger("third_record_id"), jsonArray.size());
            logger.info("长度{}",count);
        }
    }

    private void updateCommunityBuildCount(int communityId,int buildCount) {
        Query query = new Query();
        query.addCriteria(Criteria.where("community_id").is(communityId));
        Update update = Update.update("build_count", buildCount)
                .set("gen_mongo_build", 1);
        mongoTemplate.upsert(query , update, JSONObject.class,"syfc_community");
    }

    /**
     * 根据mongo的syfc_building生成mongo的houses信息
     */
    @Override
    public void saveHouse() {
        Query buildingQuery = new Query();
        buildingQuery.addCriteria(Criteria.where("gen_mongo_house").ne(1));
        List<JSONObject> buidingList = mongoTemplate.find(buildingQuery,JSONObject.class, "syfc_building");
        for (JSONObject build : buidingList) {
            Integer building_id = build.getInteger("building_id");
            Integer community_id = build.getInteger("community_id");
            try {
                //通过building_id查找syfc_new_build_house 采集的house信息
                Query houseQuery = new Query();
                houseQuery.addCriteria(Criteria.where("third_record_id").is(String.valueOf(building_id)));
                JSONObject buildingHouses = mongoTemplate.findOne(houseQuery,JSONObject.class, "syfc_new_build_house");
                if(buildingHouses != null && buildingHouses.containsKey("house_detail_list")) {
                    JSONArray houseList = buildingHouses.getJSONArray("house_detail_list");
                    //查找售价信息
                    Query price_query = new Query();
                    price_query.addCriteria(Criteria.where("collect_state").is(1).and("third_record_id").is(building_id));
                    Map<Integer,JSONObject> priceMap = new HashMap<>();
                    JSONObject buildingPrice = mongoTemplate.findOne(price_query,JSONObject.class, "syfc_sales_price_detail");
                    if(buildingPrice != null) {
                        JSONArray jsonArray = buildingPrice.getJSONArray("sales_price_detail_list");
                        //每一楼
                        for (Object houseTierPirce : jsonArray) {
                            JSONArray housePriceListJson = (JSONArray)houseTierPirce;
                            for (Object housePirce : housePriceListJson) {
                                //每个房间
                                JSONObject housePriceJSON = (JSONObject)housePirce;
                                //可售才有售价和id
                                if(HouseStateEnum.textOf(housePriceJSON.getString("house_state")).code() == HouseStateEnum.CAN_SALE.code()) {
                                    if(housePriceJSON.containsKey("third_record_id")) {
                                        priceMap.put(housePriceJSON.getInteger("third_record_id"), housePriceJSON);
                                    }else {
                                        logger.warn("房屋可售但未取到售价{}",housePriceJSON.toJSONString());
                                    }
                                }
                            }
                        }
                    }
                    for (Object houseTier : houseList) {
                        JSONArray housePriceListJson = (JSONArray)houseTier;
                        for (Object house : housePriceListJson) {
                            JSONObject houseJSON = (JSONObject)house;
                            Query query = new Query();
                            query.addCriteria(Criteria.where("house_id").is(houseJSON.getInteger("third_record_id")));
                            Update update = Update.update("house_localtion", houseJSON.get("house_localtion"))
                                    .set("sales_state_enum", houseJSON.get("sales_state_enum"))
                                    .set("house_tier", houseJSON.get("house_tier"))
                                    .set("house_no", houseJSON.get("house_no"))
                                    .set("house_id", houseJSON.getInteger("third_record_id"))
                                    .set("building_id", building_id)
                                    .set("community_id", community_id);
                            mongoTemplate.upsert(query , update, JSONObject.class,"syfc_house");
                            //更新build同步状态
                            this.updateBuildingInfo(building_id);
                        }
                    }
                }else {
                    logger.warn("{}未采集house,创建采集house任务",building_id);
                    //未采集house,创建采集house任务
                    Query updateQuery = new Query();
                    updateQuery.addCriteria(Criteria.where("third_record_id").is(String.valueOf(building_id)));
                    Update update = Update.update("collect_state", 0)
                            .addToSet("parent_third_record_id",String.valueOf(community_id) )
                            .addToSet("third_record_id", String.valueOf(building_id));
                    mongoTemplate.updateFirst(updateQuery, update, JSONObject.class,"syfc_new_build_house");
                }
            } catch (Exception e) {
                logger.error("房屋可售但未取到售价,community_id{},buildid{}",building_id,community_id);
            }
        }
    }

    private void updateBuildingInfo(int buildingId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("building_id").is(buildingId));
        Update update = Update.update("gen_mongo_house", 1);
        mongoTemplate.upsert(query , update, JSONObject.class,"syfc_building");
    }
}
