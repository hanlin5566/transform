package com.hanson.transform.dao.gen.mapper;

import com.hanson.transform.dao.gen.entity.SYFCHouse;
import com.hanson.transform.dao.gen.entity.SYFCHouseExample.Criteria;
import com.hanson.transform.dao.gen.entity.SYFCHouseExample.Criterion;
import com.hanson.transform.dao.gen.entity.SYFCHouseExample;
import java.util.List;
import org.apache.ibatis.jdbc.SQL;

public class SYFCHouseSqlProvider {

    public String insertSelective(SYFCHouse record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("tb_syfc_house");
        
        if (record.getThirdHouseId() != null) {
            sql.VALUES("third_house_id", "#{thirdHouseId,jdbcType=INTEGER}");
        }
        
        if (record.getBuildingId() != null) {
            sql.VALUES("building_id", "#{buildingId,jdbcType=INTEGER}");
        }
        
        if (record.getHouseStatus() != null) {
            sql.VALUES("house_status", "#{houseStatus,jdbcType=INTEGER}");
        }
        
        if (record.getUnitPrice() != null) {
            sql.VALUES("unit_price", "#{unitPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalPrice() != null) {
            sql.VALUES("total_price", "#{totalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getHouseNum() != null) {
            sql.VALUES("house_num", "#{houseNum,jdbcType=VARCHAR}");
        }
        
        if (record.getHouseTier() != null) {
            sql.VALUES("house_tier", "#{houseTier,jdbcType=VARCHAR}");
        }
        
        if (record.getHouseType() != null) {
            sql.VALUES("house_type", "#{houseType,jdbcType=VARCHAR}");
        }
        
        if (record.getHouseStructure() != null) {
            sql.VALUES("house_structure", "#{houseStructure,jdbcType=VARCHAR}");
        }
        
        if (record.getInsideArea() != null) {
            sql.VALUES("inside_area", "#{insideArea,jdbcType=DECIMAL}");
        }
        
        if (record.getApportionArea() != null) {
            sql.VALUES("apportion_area", "#{apportionArea,jdbcType=DECIMAL}");
        }
        
        if (record.getBalconyArea() != null) {
            sql.VALUES("balcony_area", "#{balconyArea,jdbcType=DECIMAL}");
        }
        
        if (record.getSalesArea() != null) {
            sql.VALUES("sales_area", "#{salesArea,jdbcType=DECIMAL}");
        }
        
        if (record.getBuildArea() != null) {
            sql.VALUES("build_area", "#{buildArea,jdbcType=DECIMAL}");
        }
        
        if (record.getApportionRatio() != null) {
            sql.VALUES("apportion_ratio", "#{apportionRatio,jdbcType=DECIMAL}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getDataStatus() != null) {
            sql.VALUES("data_status", "#{dataStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateUserId() != null) {
            sql.VALUES("create_user_id", "#{createUserId,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateUserId() != null) {
            sql.VALUES("update_user_id", "#{updateUserId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SYFCHouseExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("third_house_id");
        sql.SELECT("building_id");
        sql.SELECT("house_status");
        sql.SELECT("unit_price");
        sql.SELECT("total_price");
        sql.SELECT("house_num");
        sql.SELECT("house_tier");
        sql.SELECT("house_type");
        sql.SELECT("house_structure");
        sql.SELECT("inside_area");
        sql.SELECT("apportion_area");
        sql.SELECT("balcony_area");
        sql.SELECT("sales_area");
        sql.SELECT("build_area");
        sql.SELECT("apportion_ratio");
        sql.SELECT("remark");
        sql.SELECT("data_status");
        sql.SELECT("create_user_id");
        sql.SELECT("update_user_id");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("tb_syfc_house");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SYFCHouse record) {
        SQL sql = new SQL();
        sql.UPDATE("tb_syfc_house");
        
        if (record.getThirdHouseId() != null) {
            sql.SET("third_house_id = #{thirdHouseId,jdbcType=INTEGER}");
        }
        
        if (record.getBuildingId() != null) {
            sql.SET("building_id = #{buildingId,jdbcType=INTEGER}");
        }
        
        if (record.getHouseStatus() != null) {
            sql.SET("house_status = #{houseStatus,jdbcType=INTEGER}");
        }
        
        if (record.getUnitPrice() != null) {
            sql.SET("unit_price = #{unitPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalPrice() != null) {
            sql.SET("total_price = #{totalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getHouseNum() != null) {
            sql.SET("house_num = #{houseNum,jdbcType=VARCHAR}");
        }
        
        if (record.getHouseTier() != null) {
            sql.SET("house_tier = #{houseTier,jdbcType=VARCHAR}");
        }
        
        if (record.getHouseType() != null) {
            sql.SET("house_type = #{houseType,jdbcType=VARCHAR}");
        }
        
        if (record.getHouseStructure() != null) {
            sql.SET("house_structure = #{houseStructure,jdbcType=VARCHAR}");
        }
        
        if (record.getInsideArea() != null) {
            sql.SET("inside_area = #{insideArea,jdbcType=DECIMAL}");
        }
        
        if (record.getApportionArea() != null) {
            sql.SET("apportion_area = #{apportionArea,jdbcType=DECIMAL}");
        }
        
        if (record.getBalconyArea() != null) {
            sql.SET("balcony_area = #{balconyArea,jdbcType=DECIMAL}");
        }
        
        if (record.getSalesArea() != null) {
            sql.SET("sales_area = #{salesArea,jdbcType=DECIMAL}");
        }
        
        if (record.getBuildArea() != null) {
            sql.SET("build_area = #{buildArea,jdbcType=DECIMAL}");
        }
        
        if (record.getApportionRatio() != null) {
            sql.SET("apportion_ratio = #{apportionRatio,jdbcType=DECIMAL}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getDataStatus() != null) {
            sql.SET("data_status = #{dataStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateUserId() != null) {
            sql.SET("create_user_id = #{createUserId,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateUserId() != null) {
            sql.SET("update_user_id = #{updateUserId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SYFCHouseExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}