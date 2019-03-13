package com.hanson.transform.dao.gen.mapper;

import com.hanson.transform.dao.gen.entity.SYFCSalesNo;
import com.hanson.transform.dao.gen.entity.SYFCSalesNoExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface SYFCSalesNoMapper {
    @Delete({
        "delete from tb_syfc_sales_no",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_syfc_sales_no (third_no, third_record_id, ",
        "sales_no, company, ",
        "company_friendly, program_name, ",
        "program_localtion, program_localtion_friendly, ",
        "build_count, total_build_area, ",
        "sales_area, dwelling_area, ",
        "shop_area, public_area, ",
        "other_area, approve_date, ",
        "dwelling_build_no, shop_build_no, ",
        "public_build_no, other_build_no, ",
        "dwelling_build_count, shop_build_count, ",
        "public_build_count, other_build_count, ",
        "remark, data_status, ",
        "create_uid, update_uid, ",
        "create_time, update_time)",
        "values (#{thirdNo,jdbcType=INTEGER}, #{thirdRecordId,jdbcType=VARCHAR}, ",
        "#{salesNo,jdbcType=VARCHAR}, #{company,jdbcType=VARCHAR}, ",
        "#{companyFriendly,jdbcType=VARCHAR}, #{programName,jdbcType=VARCHAR}, ",
        "#{programLocaltion,jdbcType=VARCHAR}, #{programLocaltionFriendly,jdbcType=VARCHAR}, ",
        "#{buildCount,jdbcType=INTEGER}, #{totalBuildArea,jdbcType=REAL}, ",
        "#{salesArea,jdbcType=REAL}, #{dwellingArea,jdbcType=REAL}, ",
        "#{shopArea,jdbcType=REAL}, #{publicArea,jdbcType=REAL}, ",
        "#{otherArea,jdbcType=REAL}, #{approveDate,jdbcType=TIMESTAMP}, ",
        "#{dwellingBuildNo,jdbcType=VARCHAR}, #{shopBuildNo,jdbcType=VARCHAR}, ",
        "#{publicBuildNo,jdbcType=VARCHAR}, #{otherBuildNo,jdbcType=VARCHAR}, ",
        "#{dwellingBuildCount,jdbcType=INTEGER}, #{shopBuildCount,jdbcType=INTEGER}, ",
        "#{publicBuildCount,jdbcType=INTEGER}, #{otherBuildCount,jdbcType=INTEGER}, ",
        "#{remark,jdbcType=VARCHAR}, #{dataStatus,jdbcType=INTEGER}, ",
        "#{createUid,jdbcType=INTEGER}, #{updateUid,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(SYFCSalesNo record);

    @InsertProvider(type=SYFCSalesNoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(SYFCSalesNo record);

    @SelectProvider(type=SYFCSalesNoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="third_no", property="thirdNo", jdbcType=JdbcType.INTEGER),
        @Result(column="third_record_id", property="thirdRecordId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sales_no", property="salesNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_friendly", property="companyFriendly", jdbcType=JdbcType.VARCHAR),
        @Result(column="program_name", property="programName", jdbcType=JdbcType.VARCHAR),
        @Result(column="program_localtion", property="programLocaltion", jdbcType=JdbcType.VARCHAR),
        @Result(column="program_localtion_friendly", property="programLocaltionFriendly", jdbcType=JdbcType.VARCHAR),
        @Result(column="build_count", property="buildCount", jdbcType=JdbcType.INTEGER),
        @Result(column="total_build_area", property="totalBuildArea", jdbcType=JdbcType.REAL),
        @Result(column="sales_area", property="salesArea", jdbcType=JdbcType.REAL),
        @Result(column="dwelling_area", property="dwellingArea", jdbcType=JdbcType.REAL),
        @Result(column="shop_area", property="shopArea", jdbcType=JdbcType.REAL),
        @Result(column="public_area", property="publicArea", jdbcType=JdbcType.REAL),
        @Result(column="other_area", property="otherArea", jdbcType=JdbcType.REAL),
        @Result(column="approve_date", property="approveDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="dwelling_build_no", property="dwellingBuildNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_build_no", property="shopBuildNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="public_build_no", property="publicBuildNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="other_build_no", property="otherBuildNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="dwelling_build_count", property="dwellingBuildCount", jdbcType=JdbcType.INTEGER),
        @Result(column="shop_build_count", property="shopBuildCount", jdbcType=JdbcType.INTEGER),
        @Result(column="public_build_count", property="publicBuildCount", jdbcType=JdbcType.INTEGER),
        @Result(column="other_build_count", property="otherBuildCount", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SYFCSalesNo> selectByExampleWithRowbounds(SYFCSalesNoExample example, RowBounds rowBounds);

    @SelectProvider(type=SYFCSalesNoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="third_no", property="thirdNo", jdbcType=JdbcType.INTEGER),
        @Result(column="third_record_id", property="thirdRecordId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sales_no", property="salesNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_friendly", property="companyFriendly", jdbcType=JdbcType.VARCHAR),
        @Result(column="program_name", property="programName", jdbcType=JdbcType.VARCHAR),
        @Result(column="program_localtion", property="programLocaltion", jdbcType=JdbcType.VARCHAR),
        @Result(column="program_localtion_friendly", property="programLocaltionFriendly", jdbcType=JdbcType.VARCHAR),
        @Result(column="build_count", property="buildCount", jdbcType=JdbcType.INTEGER),
        @Result(column="total_build_area", property="totalBuildArea", jdbcType=JdbcType.REAL),
        @Result(column="sales_area", property="salesArea", jdbcType=JdbcType.REAL),
        @Result(column="dwelling_area", property="dwellingArea", jdbcType=JdbcType.REAL),
        @Result(column="shop_area", property="shopArea", jdbcType=JdbcType.REAL),
        @Result(column="public_area", property="publicArea", jdbcType=JdbcType.REAL),
        @Result(column="other_area", property="otherArea", jdbcType=JdbcType.REAL),
        @Result(column="approve_date", property="approveDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="dwelling_build_no", property="dwellingBuildNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_build_no", property="shopBuildNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="public_build_no", property="publicBuildNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="other_build_no", property="otherBuildNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="dwelling_build_count", property="dwellingBuildCount", jdbcType=JdbcType.INTEGER),
        @Result(column="shop_build_count", property="shopBuildCount", jdbcType=JdbcType.INTEGER),
        @Result(column="public_build_count", property="publicBuildCount", jdbcType=JdbcType.INTEGER),
        @Result(column="other_build_count", property="otherBuildCount", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SYFCSalesNo> selectByExample(SYFCSalesNoExample example);

    @Select({
        "select",
        "id, third_no, third_record_id, sales_no, company, company_friendly, program_name, ",
        "program_localtion, program_localtion_friendly, build_count, total_build_area, ",
        "sales_area, dwelling_area, shop_area, public_area, other_area, approve_date, ",
        "dwelling_build_no, shop_build_no, public_build_no, other_build_no, dwelling_build_count, ",
        "shop_build_count, public_build_count, other_build_count, remark, data_status, ",
        "create_uid, update_uid, create_time, update_time",
        "from tb_syfc_sales_no",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="third_no", property="thirdNo", jdbcType=JdbcType.INTEGER),
        @Result(column="third_record_id", property="thirdRecordId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sales_no", property="salesNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_friendly", property="companyFriendly", jdbcType=JdbcType.VARCHAR),
        @Result(column="program_name", property="programName", jdbcType=JdbcType.VARCHAR),
        @Result(column="program_localtion", property="programLocaltion", jdbcType=JdbcType.VARCHAR),
        @Result(column="program_localtion_friendly", property="programLocaltionFriendly", jdbcType=JdbcType.VARCHAR),
        @Result(column="build_count", property="buildCount", jdbcType=JdbcType.INTEGER),
        @Result(column="total_build_area", property="totalBuildArea", jdbcType=JdbcType.REAL),
        @Result(column="sales_area", property="salesArea", jdbcType=JdbcType.REAL),
        @Result(column="dwelling_area", property="dwellingArea", jdbcType=JdbcType.REAL),
        @Result(column="shop_area", property="shopArea", jdbcType=JdbcType.REAL),
        @Result(column="public_area", property="publicArea", jdbcType=JdbcType.REAL),
        @Result(column="other_area", property="otherArea", jdbcType=JdbcType.REAL),
        @Result(column="approve_date", property="approveDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="dwelling_build_no", property="dwellingBuildNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_build_no", property="shopBuildNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="public_build_no", property="publicBuildNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="other_build_no", property="otherBuildNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="dwelling_build_count", property="dwellingBuildCount", jdbcType=JdbcType.INTEGER),
        @Result(column="shop_build_count", property="shopBuildCount", jdbcType=JdbcType.INTEGER),
        @Result(column="public_build_count", property="publicBuildCount", jdbcType=JdbcType.INTEGER),
        @Result(column="other_build_count", property="otherBuildCount", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SYFCSalesNo selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SYFCSalesNoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SYFCSalesNo record);

    @Update({
        "update tb_syfc_sales_no",
        "set third_no = #{thirdNo,jdbcType=INTEGER},",
          "third_record_id = #{thirdRecordId,jdbcType=VARCHAR},",
          "sales_no = #{salesNo,jdbcType=VARCHAR},",
          "company = #{company,jdbcType=VARCHAR},",
          "company_friendly = #{companyFriendly,jdbcType=VARCHAR},",
          "program_name = #{programName,jdbcType=VARCHAR},",
          "program_localtion = #{programLocaltion,jdbcType=VARCHAR},",
          "program_localtion_friendly = #{programLocaltionFriendly,jdbcType=VARCHAR},",
          "build_count = #{buildCount,jdbcType=INTEGER},",
          "total_build_area = #{totalBuildArea,jdbcType=REAL},",
          "sales_area = #{salesArea,jdbcType=REAL},",
          "dwelling_area = #{dwellingArea,jdbcType=REAL},",
          "shop_area = #{shopArea,jdbcType=REAL},",
          "public_area = #{publicArea,jdbcType=REAL},",
          "other_area = #{otherArea,jdbcType=REAL},",
          "approve_date = #{approveDate,jdbcType=TIMESTAMP},",
          "dwelling_build_no = #{dwellingBuildNo,jdbcType=VARCHAR},",
          "shop_build_no = #{shopBuildNo,jdbcType=VARCHAR},",
          "public_build_no = #{publicBuildNo,jdbcType=VARCHAR},",
          "other_build_no = #{otherBuildNo,jdbcType=VARCHAR},",
          "dwelling_build_count = #{dwellingBuildCount,jdbcType=INTEGER},",
          "shop_build_count = #{shopBuildCount,jdbcType=INTEGER},",
          "public_build_count = #{publicBuildCount,jdbcType=INTEGER},",
          "other_build_count = #{otherBuildCount,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "data_status = #{dataStatus,jdbcType=INTEGER},",
          "create_uid = #{createUid,jdbcType=INTEGER},",
          "update_uid = #{updateUid,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SYFCSalesNo record);
}