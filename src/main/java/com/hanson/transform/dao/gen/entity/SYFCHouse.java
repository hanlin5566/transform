package com.hanson.transform.dao.gen.entity;

import com.hanson.base.enums.DataStatus;
import com.hanson.transform.enums.HouseStateEnum;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hanson.base.annotation.AutoWriteParam;
import com.hanson.base.mybatis.serializer.DatePattern;
import com.hanson.base.serializer.EnumJsonSerializer;
/**
 * tb_syfc_house 房屋信息
 * @author huhanlin 2019-04-03
 */
@AutoWriteParam
public class SYFCHouse {
    /**
     * 主鍵
     */
    private Integer id;

    /**
     * 第三方房屋ID->syfc_new_build_house.house_detail_list.third_record_id
     */
    private Integer thirdHouseId;

    /**
     * 建筑ID，父ID
     */
    private Integer buildingId;

    /**
     * 房屋状态:0未知，1可售，2已售，3，现售，4已发证，5查封，10未纳入网上销售
     */
    @JsonSerialize(using = EnumJsonSerializer.class)
    private HouseStateEnum houseStatus;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

    /**
     * 总价
     */
    private BigDecimal totalPrice;

    /**
     * 门牌号
     */
    private String houseNum;

    /**
     * 楼层
     */
    private String houseTier;

    /**
     * 房屋类型
     */
    private String houseType;

    /**
     * 房屋结构
     */
    private String houseStructure;

    /**
     * 套内面积
     */
    private BigDecimal insideArea;

    /**
     * 分摊面积
     */
    private BigDecimal apportionArea;

    /**
     * 阳台面积
     */
    private BigDecimal balconyArea;

    /**
     * 销售面积
     */
    private BigDecimal salesArea;

    /**
     * 建筑面积
     */
    private BigDecimal buildArea;

    /**
     * 公摊率
     */
    private BigDecimal apportionRatio;

    /**
     * 备注
     */
    private String remark;

    /**
     * 数据状态1-正常，0-未知，-1已删除
     */
    @JsonSerialize(using = EnumJsonSerializer.class)
    private DataStatus dataStatus;

    /**
     * 创建人
     */
    private Integer createUserId;

    /**
     * 修改人
     */
    private Integer updateUserId;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = DatePattern.ISO_DATE)
    private Date createTime;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = DatePattern.ISO_DATE)
    private Date updateTime;

    /**
     * 主鍵
     * @return id 主鍵
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主鍵
     * @param id 主鍵
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 第三方房屋ID->syfc_new_build_house.house_detail_list.third_record_id
     * @return third_house_id 第三方房屋ID->syfc_new_build_house.house_detail_list.third_record_id
     */
    public Integer getThirdHouseId() {
        return thirdHouseId;
    }

    /**
     * 第三方房屋ID->syfc_new_build_house.house_detail_list.third_record_id
     * @param thirdHouseId 第三方房屋ID->syfc_new_build_house.house_detail_list.third_record_id
     */
    public void setThirdHouseId(Integer thirdHouseId) {
        this.thirdHouseId = thirdHouseId;
    }

    /**
     * 建筑ID，父ID
     * @return building_id 建筑ID，父ID
     */
    public Integer getBuildingId() {
        return buildingId;
    }

    /**
     * 建筑ID，父ID
     * @param buildingId 建筑ID，父ID
     */
    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    /**
     * 房屋状态:0未知，1可售，2已售，3，现售，4已发证，5查封，10未纳入网上销售
     * @return house_status 房屋状态:0未知，1可售，2已售，3，现售，4已发证，5查封，10未纳入网上销售
     */
    public HouseStateEnum getHouseStatus() {
        return houseStatus;
    }

    /**
     * 房屋状态:0未知，1可售，2已售，3，现售，4已发证，5查封，10未纳入网上销售
     * @param houseStatus 房屋状态:0未知，1可售，2已售，3，现售，4已发证，5查封，10未纳入网上销售
     */
    public void setHouseStatus(HouseStateEnum houseStatus) {
        this.houseStatus = houseStatus;
    }

    /**
     * 单价
     * @return unit_price 单价
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * 单价
     * @param unitPrice 单价
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * 总价
     * @return total_price 总价
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * 总价
     * @param totalPrice 总价
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 门牌号
     * @return house_num 门牌号
     */
    public String getHouseNum() {
        return houseNum;
    }

    /**
     * 门牌号
     * @param houseNum 门牌号
     */
    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum == null ? null : houseNum.trim();
    }

    /**
     * 楼层
     * @return house_tier 楼层
     */
    public String getHouseTier() {
        return houseTier;
    }

    /**
     * 楼层
     * @param houseTier 楼层
     */
    public void setHouseTier(String houseTier) {
        this.houseTier = houseTier == null ? null : houseTier.trim();
    }

    /**
     * 房屋类型
     * @return house_type 房屋类型
     */
    public String getHouseType() {
        return houseType;
    }

    /**
     * 房屋类型
     * @param houseType 房屋类型
     */
    public void setHouseType(String houseType) {
        this.houseType = houseType == null ? null : houseType.trim();
    }

    /**
     * 房屋结构
     * @return house_structure 房屋结构
     */
    public String getHouseStructure() {
        return houseStructure;
    }

    /**
     * 房屋结构
     * @param houseStructure 房屋结构
     */
    public void setHouseStructure(String houseStructure) {
        this.houseStructure = houseStructure == null ? null : houseStructure.trim();
    }

    /**
     * 套内面积
     * @return inside_area 套内面积
     */
    public BigDecimal getInsideArea() {
        return insideArea;
    }

    /**
     * 套内面积
     * @param insideArea 套内面积
     */
    public void setInsideArea(BigDecimal insideArea) {
        this.insideArea = insideArea;
    }

    /**
     * 分摊面积
     * @return apportion_area 分摊面积
     */
    public BigDecimal getApportionArea() {
        return apportionArea;
    }

    /**
     * 分摊面积
     * @param apportionArea 分摊面积
     */
    public void setApportionArea(BigDecimal apportionArea) {
        this.apportionArea = apportionArea;
    }

    /**
     * 阳台面积
     * @return balcony_area 阳台面积
     */
    public BigDecimal getBalconyArea() {
        return balconyArea;
    }

    /**
     * 阳台面积
     * @param balconyArea 阳台面积
     */
    public void setBalconyArea(BigDecimal balconyArea) {
        this.balconyArea = balconyArea;
    }

    /**
     * 销售面积
     * @return sales_area 销售面积
     */
    public BigDecimal getSalesArea() {
        return salesArea;
    }

    /**
     * 销售面积
     * @param salesArea 销售面积
     */
    public void setSalesArea(BigDecimal salesArea) {
        this.salesArea = salesArea;
    }

    /**
     * 建筑面积
     * @return build_area 建筑面积
     */
    public BigDecimal getBuildArea() {
        return buildArea;
    }

    /**
     * 建筑面积
     * @param buildArea 建筑面积
     */
    public void setBuildArea(BigDecimal buildArea) {
        this.buildArea = buildArea;
    }

    /**
     * 公摊率
     * @return apportion_ratio 公摊率
     */
    public BigDecimal getApportionRatio() {
        return apportionRatio;
    }

    /**
     * 公摊率
     * @param apportionRatio 公摊率
     */
    public void setApportionRatio(BigDecimal apportionRatio) {
        this.apportionRatio = apportionRatio;
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 数据状态1-正常，0-未知，-1已删除
     * @return data_status 数据状态1-正常，0-未知，-1已删除
     */
    public DataStatus getDataStatus() {
        return dataStatus;
    }

    /**
     * 数据状态1-正常，0-未知，-1已删除
     * @param dataStatus 数据状态1-正常，0-未知，-1已删除
     */
    public void setDataStatus(DataStatus dataStatus) {
        this.dataStatus = dataStatus;
    }

    /**
     * 创建人
     * @return create_user_id 创建人
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * 创建人
     * @param createUserId 创建人
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 修改人
     * @return update_user_id 修改人
     */
    public Integer getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 修改人
     * @param updateUserId 修改人
     */
    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     * @return update_time 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}