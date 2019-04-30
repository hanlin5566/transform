package com.hanson.transform.dao.gen.mapper;

import com.hanson.transform.dao.gen.entity.SYFCHouse;
import com.hanson.transform.dao.gen.entity.SYFCHouseExample;
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

public interface SYFCHouseMapper {
    @Delete({
        "delete from tb_syfc_house",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_syfc_house (third_house_id, building_id, ",
        "house_status, unit_price, ",
        "total_price, house_num, ",
        "house_tier, house_type, ",
        "house_structure, inside_area, ",
        "apportion_area, balcony_area, ",
        "sales_area, build_area, ",
        "apportion_ratio, remark, ",
        "data_status, create_user_id, ",
        "update_user_id, create_time, ",
        "update_time)",
        "values (#{thirdHouseId,jdbcType=INTEGER}, #{buildingId,jdbcType=INTEGER}, ",
        "#{houseStatus,jdbcType=INTEGER}, #{unitPrice,jdbcType=DECIMAL}, ",
        "#{totalPrice,jdbcType=DECIMAL}, #{houseNum,jdbcType=VARCHAR}, ",
        "#{houseTier,jdbcType=VARCHAR}, #{houseType,jdbcType=VARCHAR}, ",
        "#{houseStructure,jdbcType=VARCHAR}, #{insideArea,jdbcType=DECIMAL}, ",
        "#{apportionArea,jdbcType=DECIMAL}, #{balconyArea,jdbcType=DECIMAL}, ",
        "#{salesArea,jdbcType=DECIMAL}, #{buildArea,jdbcType=DECIMAL}, ",
        "#{apportionRatio,jdbcType=DECIMAL}, #{remark,jdbcType=VARCHAR}, ",
        "#{dataStatus,jdbcType=INTEGER}, #{createUserId,jdbcType=INTEGER}, ",
        "#{updateUserId,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(SYFCHouse record);

    @InsertProvider(type=SYFCHouseSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(SYFCHouse record);

    @SelectProvider(type=SYFCHouseSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="third_house_id", property="thirdHouseId", jdbcType=JdbcType.INTEGER),
        @Result(column="building_id", property="buildingId", jdbcType=JdbcType.INTEGER),
        @Result(column="house_status", property="houseStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="unit_price", property="unitPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_price", property="totalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="house_num", property="houseNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="house_tier", property="houseTier", jdbcType=JdbcType.VARCHAR),
        @Result(column="house_type", property="houseType", jdbcType=JdbcType.VARCHAR),
        @Result(column="house_structure", property="houseStructure", jdbcType=JdbcType.VARCHAR),
        @Result(column="inside_area", property="insideArea", jdbcType=JdbcType.DECIMAL),
        @Result(column="apportion_area", property="apportionArea", jdbcType=JdbcType.DECIMAL),
        @Result(column="balcony_area", property="balconyArea", jdbcType=JdbcType.DECIMAL),
        @Result(column="sales_area", property="salesArea", jdbcType=JdbcType.DECIMAL),
        @Result(column="build_area", property="buildArea", jdbcType=JdbcType.DECIMAL),
        @Result(column="apportion_ratio", property="apportionRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="update_user_id", property="updateUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SYFCHouse> selectByExampleWithRowbounds(SYFCHouseExample example, RowBounds rowBounds);

    @SelectProvider(type=SYFCHouseSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="third_house_id", property="thirdHouseId", jdbcType=JdbcType.INTEGER),
        @Result(column="building_id", property="buildingId", jdbcType=JdbcType.INTEGER),
        @Result(column="house_status", property="houseStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="unit_price", property="unitPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_price", property="totalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="house_num", property="houseNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="house_tier", property="houseTier", jdbcType=JdbcType.VARCHAR),
        @Result(column="house_type", property="houseType", jdbcType=JdbcType.VARCHAR),
        @Result(column="house_structure", property="houseStructure", jdbcType=JdbcType.VARCHAR),
        @Result(column="inside_area", property="insideArea", jdbcType=JdbcType.DECIMAL),
        @Result(column="apportion_area", property="apportionArea", jdbcType=JdbcType.DECIMAL),
        @Result(column="balcony_area", property="balconyArea", jdbcType=JdbcType.DECIMAL),
        @Result(column="sales_area", property="salesArea", jdbcType=JdbcType.DECIMAL),
        @Result(column="build_area", property="buildArea", jdbcType=JdbcType.DECIMAL),
        @Result(column="apportion_ratio", property="apportionRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="update_user_id", property="updateUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SYFCHouse> selectByExample(SYFCHouseExample example);

    @Select({
        "select",
        "id, third_house_id, building_id, house_status, unit_price, total_price, house_num, ",
        "house_tier, house_type, house_structure, inside_area, apportion_area, balcony_area, ",
        "sales_area, build_area, apportion_ratio, remark, data_status, create_user_id, ",
        "update_user_id, create_time, update_time",
        "from tb_syfc_house",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="third_house_id", property="thirdHouseId", jdbcType=JdbcType.INTEGER),
        @Result(column="building_id", property="buildingId", jdbcType=JdbcType.INTEGER),
        @Result(column="house_status", property="houseStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="unit_price", property="unitPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_price", property="totalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="house_num", property="houseNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="house_tier", property="houseTier", jdbcType=JdbcType.VARCHAR),
        @Result(column="house_type", property="houseType", jdbcType=JdbcType.VARCHAR),
        @Result(column="house_structure", property="houseStructure", jdbcType=JdbcType.VARCHAR),
        @Result(column="inside_area", property="insideArea", jdbcType=JdbcType.DECIMAL),
        @Result(column="apportion_area", property="apportionArea", jdbcType=JdbcType.DECIMAL),
        @Result(column="balcony_area", property="balconyArea", jdbcType=JdbcType.DECIMAL),
        @Result(column="sales_area", property="salesArea", jdbcType=JdbcType.DECIMAL),
        @Result(column="build_area", property="buildArea", jdbcType=JdbcType.DECIMAL),
        @Result(column="apportion_ratio", property="apportionRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="update_user_id", property="updateUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SYFCHouse selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SYFCHouseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SYFCHouse record);

    @Update({
        "update tb_syfc_house",
        "set third_house_id = #{thirdHouseId,jdbcType=INTEGER},",
          "building_id = #{buildingId,jdbcType=INTEGER},",
          "house_status = #{houseStatus,jdbcType=INTEGER},",
          "unit_price = #{unitPrice,jdbcType=DECIMAL},",
          "total_price = #{totalPrice,jdbcType=DECIMAL},",
          "house_num = #{houseNum,jdbcType=VARCHAR},",
          "house_tier = #{houseTier,jdbcType=VARCHAR},",
          "house_type = #{houseType,jdbcType=VARCHAR},",
          "house_structure = #{houseStructure,jdbcType=VARCHAR},",
          "inside_area = #{insideArea,jdbcType=DECIMAL},",
          "apportion_area = #{apportionArea,jdbcType=DECIMAL},",
          "balcony_area = #{balconyArea,jdbcType=DECIMAL},",
          "sales_area = #{salesArea,jdbcType=DECIMAL},",
          "build_area = #{buildArea,jdbcType=DECIMAL},",
          "apportion_ratio = #{apportionRatio,jdbcType=DECIMAL},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "data_status = #{dataStatus,jdbcType=INTEGER},",
          "create_user_id = #{createUserId,jdbcType=INTEGER},",
          "update_user_id = #{updateUserId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SYFCHouse record);
}