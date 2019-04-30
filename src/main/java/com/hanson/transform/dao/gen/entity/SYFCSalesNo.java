package com.hanson.transform.dao.gen.entity;

import com.hanson.base.enums.DataStatus;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hanson.base.annotation.AutoWriteParam;
import com.hanson.base.mybatis.serializer.DatePattern;
import com.hanson.base.serializer.EnumJsonSerializer;
/**
 * tb_syfc_sales_no 
 * @author huhanlin 2019-02-28
 */
@AutoWriteParam
public class SYFCSalesNo {
    /**
     * 
     */
    private Integer id;

    /**
     * 第三方编号
     */
    private Integer thirdNo;

    /**
     * 第三方记录ID
     */
    private String thirdRecordId;

    /**
     * 房产预售号
     */
    private String salesNo;

    /**
     * 开发商名称
     */
    private String company;

    /**
     * 开发商可读名称
     */
    private String companyFriendly;

    /**
     * 项目名称
     */
    private String programName;

    /**
     * 
     */
    private String programLocaltion;

    /**
     * 友好的项目地址
     */
    private String programLocaltionFriendly;

    /**
     * 商品房栋数
     */
    private Integer buildCount;

    /**
     * 总建筑面积
     */
    private Float totalBuildArea;

    /**
     * 销售面积
     */
    private Float salesArea;

    /**
     * 住宅面积
     */
    private Float dwellingArea;

    /**
     * 网点面积
     */
    private Float shopArea;

    /**
     * 公建面积
     */
    private Float publicArea;

    /**
     * 其他面积
     */
    private Float otherArea;

    /**
     * 审批日期
     */
    @DateTimeFormat(pattern = DatePattern.ISO_DATE)
    private Date approveDate;

    /**
     * 住宅栋号
     */
    private String dwellingBuildNo;

    /**
     * 网点栋号
     */
    private String shopBuildNo;

    /**
     * 公建栋号
     */
    private String publicBuildNo;

    /**
     * 其他栋号
     */
    private String otherBuildNo;

    /**
     * 住宅套数
     */
    private Integer dwellingBuildCount;

    /**
     * 网点套数
     */
    private Integer shopBuildCount;

    /**
     * 公建套数
     */
    private Integer publicBuildCount;

    /**
     * 其他套数
     */
    private Integer otherBuildCount;

    /**
     * 
     */
    private String remark;

    /**
     * 
     */
    @JsonSerialize(using = EnumJsonSerializer.class)
    private DataStatus dataStatus;

    /**
     * 创建人
     */
    private Integer createUid;

    /**
     * 修改人
     */
    private Integer updateUid;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = DatePattern.ISO_DATE)
    private Date createTime;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = DatePattern.ISO_DATE)
    private Date updateTime;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 第三方编号
     * @return third_no 第三方编号
     */
    public Integer getThirdNo() {
        return thirdNo;
    }

    /**
     * 第三方编号
     * @param thirdNo 第三方编号
     */
    public void setThirdNo(Integer thirdNo) {
        this.thirdNo = thirdNo;
    }

    /**
     * 第三方记录ID
     * @return third_record_id 第三方记录ID
     */
    public String getThirdRecordId() {
        return thirdRecordId;
    }

    /**
     * 第三方记录ID
     * @param thirdRecordId 第三方记录ID
     */
    public void setThirdRecordId(String thirdRecordId) {
        this.thirdRecordId = thirdRecordId == null ? null : thirdRecordId.trim();
    }

    /**
     * 房产预售号
     * @return sales_no 房产预售号
     */
    public String getSalesNo() {
        return salesNo;
    }

    /**
     * 房产预售号
     * @param salesNo 房产预售号
     */
    public void setSalesNo(String salesNo) {
        this.salesNo = salesNo == null ? null : salesNo.trim();
    }

    /**
     * 开发商名称
     * @return company 开发商名称
     */
    public String getCompany() {
        return company;
    }

    /**
     * 开发商名称
     * @param company 开发商名称
     */
    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    /**
     * 开发商可读名称
     * @return company_friendly 开发商可读名称
     */
    public String getCompanyFriendly() {
        return companyFriendly;
    }

    /**
     * 开发商可读名称
     * @param companyFriendly 开发商可读名称
     */
    public void setCompanyFriendly(String companyFriendly) {
        this.companyFriendly = companyFriendly == null ? null : companyFriendly.trim();
    }

    /**
     * 项目名称
     * @return program_name 项目名称
     */
    public String getProgramName() {
        return programName;
    }

    /**
     * 项目名称
     * @param programName 项目名称
     */
    public void setProgramName(String programName) {
        this.programName = programName == null ? null : programName.trim();
    }

    /**
     * 
     * @return program_localtion 
     */
    public String getProgramLocaltion() {
        return programLocaltion;
    }

    /**
     * 
     * @param programLocaltion 
     */
    public void setProgramLocaltion(String programLocaltion) {
        this.programLocaltion = programLocaltion == null ? null : programLocaltion.trim();
    }

    /**
     * 友好的项目地址
     * @return program_localtion_friendly 友好的项目地址
     */
    public String getProgramLocaltionFriendly() {
        return programLocaltionFriendly;
    }

    /**
     * 友好的项目地址
     * @param programLocaltionFriendly 友好的项目地址
     */
    public void setProgramLocaltionFriendly(String programLocaltionFriendly) {
        this.programLocaltionFriendly = programLocaltionFriendly == null ? null : programLocaltionFriendly.trim();
    }

    /**
     * 商品房栋数
     * @return build_count 商品房栋数
     */
    public Integer getBuildCount() {
        return buildCount;
    }

    /**
     * 商品房栋数
     * @param buildCount 商品房栋数
     */
    public void setBuildCount(Integer buildCount) {
        this.buildCount = buildCount;
    }

    /**
     * 总建筑面积
     * @return total_build_area 总建筑面积
     */
    public Float getTotalBuildArea() {
        return totalBuildArea;
    }

    /**
     * 总建筑面积
     * @param totalBuildArea 总建筑面积
     */
    public void setTotalBuildArea(Float totalBuildArea) {
        this.totalBuildArea = totalBuildArea;
    }

    /**
     * 销售面积
     * @return sales_area 销售面积
     */
    public Float getSalesArea() {
        return salesArea;
    }

    /**
     * 销售面积
     * @param salesArea 销售面积
     */
    public void setSalesArea(Float salesArea) {
        this.salesArea = salesArea;
    }

    /**
     * 住宅面积
     * @return dwelling_area 住宅面积
     */
    public Float getDwellingArea() {
        return dwellingArea;
    }

    /**
     * 住宅面积
     * @param dwellingArea 住宅面积
     */
    public void setDwellingArea(Float dwellingArea) {
        this.dwellingArea = dwellingArea;
    }

    /**
     * 网点面积
     * @return shop_area 网点面积
     */
    public Float getShopArea() {
        return shopArea;
    }

    /**
     * 网点面积
     * @param shopArea 网点面积
     */
    public void setShopArea(Float shopArea) {
        this.shopArea = shopArea;
    }

    /**
     * 公建面积
     * @return public_area 公建面积
     */
    public Float getPublicArea() {
        return publicArea;
    }

    /**
     * 公建面积
     * @param publicArea 公建面积
     */
    public void setPublicArea(Float publicArea) {
        this.publicArea = publicArea;
    }

    /**
     * 其他面积
     * @return other_area 其他面积
     */
    public Float getOtherArea() {
        return otherArea;
    }

    /**
     * 其他面积
     * @param otherArea 其他面积
     */
    public void setOtherArea(Float otherArea) {
        this.otherArea = otherArea;
    }

    /**
     * 审批日期
     * @return approve_date 审批日期
     */
    public Date getApproveDate() {
        return approveDate;
    }

    /**
     * 审批日期
     * @param approveDate 审批日期
     */
    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    /**
     * 住宅栋号
     * @return dwelling_build_no 住宅栋号
     */
    public String getDwellingBuildNo() {
        return dwellingBuildNo;
    }

    /**
     * 住宅栋号
     * @param dwellingBuildNo 住宅栋号
     */
    public void setDwellingBuildNo(String dwellingBuildNo) {
        this.dwellingBuildNo = dwellingBuildNo == null ? null : dwellingBuildNo.trim();
    }

    /**
     * 网点栋号
     * @return shop_build_no 网点栋号
     */
    public String getShopBuildNo() {
        return shopBuildNo;
    }

    /**
     * 网点栋号
     * @param shopBuildNo 网点栋号
     */
    public void setShopBuildNo(String shopBuildNo) {
        this.shopBuildNo = shopBuildNo == null ? null : shopBuildNo.trim();
    }

    /**
     * 公建栋号
     * @return public_build_no 公建栋号
     */
    public String getPublicBuildNo() {
        return publicBuildNo;
    }

    /**
     * 公建栋号
     * @param publicBuildNo 公建栋号
     */
    public void setPublicBuildNo(String publicBuildNo) {
        this.publicBuildNo = publicBuildNo == null ? null : publicBuildNo.trim();
    }

    /**
     * 其他栋号
     * @return other_build_no 其他栋号
     */
    public String getOtherBuildNo() {
        return otherBuildNo;
    }

    /**
     * 其他栋号
     * @param otherBuildNo 其他栋号
     */
    public void setOtherBuildNo(String otherBuildNo) {
        this.otherBuildNo = otherBuildNo == null ? null : otherBuildNo.trim();
    }

    /**
     * 住宅套数
     * @return dwelling_build_count 住宅套数
     */
    public Integer getDwellingBuildCount() {
        return dwellingBuildCount;
    }

    /**
     * 住宅套数
     * @param dwellingBuildCount 住宅套数
     */
    public void setDwellingBuildCount(Integer dwellingBuildCount) {
        this.dwellingBuildCount = dwellingBuildCount;
    }

    /**
     * 网点套数
     * @return shop_build_count 网点套数
     */
    public Integer getShopBuildCount() {
        return shopBuildCount;
    }

    /**
     * 网点套数
     * @param shopBuildCount 网点套数
     */
    public void setShopBuildCount(Integer shopBuildCount) {
        this.shopBuildCount = shopBuildCount;
    }

    /**
     * 公建套数
     * @return public_build_count 公建套数
     */
    public Integer getPublicBuildCount() {
        return publicBuildCount;
    }

    /**
     * 公建套数
     * @param publicBuildCount 公建套数
     */
    public void setPublicBuildCount(Integer publicBuildCount) {
        this.publicBuildCount = publicBuildCount;
    }

    /**
     * 其他套数
     * @return other_build_count 其他套数
     */
    public Integer getOtherBuildCount() {
        return otherBuildCount;
    }

    /**
     * 其他套数
     * @param otherBuildCount 其他套数
     */
    public void setOtherBuildCount(Integer otherBuildCount) {
        this.otherBuildCount = otherBuildCount;
    }

    /**
     * 
     * @return remark 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 
     * @param remark 
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 
     * @return data_status 
     */
    public DataStatus getDataStatus() {
        return dataStatus;
    }

    /**
     * 
     * @param dataStatus 
     */
    public void setDataStatus(DataStatus dataStatus) {
        this.dataStatus = dataStatus;
    }

    /**
     * 创建人
     * @return create_uid 创建人
     */
    public Integer getCreateUid() {
        return createUid;
    }

    /**
     * 创建人
     * @param createUid 创建人
     */
    public void setCreateUid(Integer createUid) {
        this.createUid = createUid;
    }

    /**
     * 修改人
     * @return update_uid 修改人
     */
    public Integer getUpdateUid() {
        return updateUid;
    }

    /**
     * 修改人
     * @param updateUid 修改人
     */
    public void setUpdateUid(Integer updateUid) {
        this.updateUid = updateUid;
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
     * 创建时间
     * @return update_time 创建时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 创建时间
     * @param updateTime 创建时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}