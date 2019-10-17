package com.hanson.transform.dao.gen.entity;

import com.hanson.base.enums.DataStatus;
import com.hanson.transform.enums.HouseStateEnum;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SYFCHouseExample {
    /**
     * tb_syfc_house
     */
    protected String orderByClause;

    /**
     * tb_syfc_house
     */
    protected boolean distinct;

    /**
     * tb_syfc_house
     */
    protected List<Criteria> oredCriteria;

    public SYFCHouseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * tb_syfc_house 2019-04-03
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andThirdHouseIdIsNull() {
            addCriterion("third_house_id is null");
            return (Criteria) this;
        }

        public Criteria andThirdHouseIdIsNotNull() {
            addCriterion("third_house_id is not null");
            return (Criteria) this;
        }

        public Criteria andThirdHouseIdEqualTo(Integer value) {
            addCriterion("third_house_id =", value, "thirdHouseId");
            return (Criteria) this;
        }

        public Criteria andThirdHouseIdNotEqualTo(Integer value) {
            addCriterion("third_house_id <>", value, "thirdHouseId");
            return (Criteria) this;
        }

        public Criteria andThirdHouseIdGreaterThan(Integer value) {
            addCriterion("third_house_id >", value, "thirdHouseId");
            return (Criteria) this;
        }

        public Criteria andThirdHouseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("third_house_id >=", value, "thirdHouseId");
            return (Criteria) this;
        }

        public Criteria andThirdHouseIdLessThan(Integer value) {
            addCriterion("third_house_id <", value, "thirdHouseId");
            return (Criteria) this;
        }

        public Criteria andThirdHouseIdLessThanOrEqualTo(Integer value) {
            addCriterion("third_house_id <=", value, "thirdHouseId");
            return (Criteria) this;
        }

        public Criteria andThirdHouseIdIn(List<Integer> values) {
            addCriterion("third_house_id in", values, "thirdHouseId");
            return (Criteria) this;
        }

        public Criteria andThirdHouseIdNotIn(List<Integer> values) {
            addCriterion("third_house_id not in", values, "thirdHouseId");
            return (Criteria) this;
        }

        public Criteria andThirdHouseIdBetween(Integer value1, Integer value2) {
            addCriterion("third_house_id between", value1, value2, "thirdHouseId");
            return (Criteria) this;
        }

        public Criteria andThirdHouseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("third_house_id not between", value1, value2, "thirdHouseId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNull() {
            addCriterion("building_id is null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNotNull() {
            addCriterion("building_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdEqualTo(Integer value) {
            addCriterion("building_id =", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotEqualTo(Integer value) {
            addCriterion("building_id <>", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThan(Integer value) {
            addCriterion("building_id >", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("building_id >=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThan(Integer value) {
            addCriterion("building_id <", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThanOrEqualTo(Integer value) {
            addCriterion("building_id <=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIn(List<Integer> values) {
            addCriterion("building_id in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotIn(List<Integer> values) {
            addCriterion("building_id not in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdBetween(Integer value1, Integer value2) {
            addCriterion("building_id between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("building_id not between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andHouseStatusIsNull() {
            addCriterion("house_status is null");
            return (Criteria) this;
        }

        public Criteria andHouseStatusIsNotNull() {
            addCriterion("house_status is not null");
            return (Criteria) this;
        }

        public Criteria andHouseStatusEqualTo(HouseStateEnum value) {
            addCriterion("house_status =", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNotEqualTo(HouseStateEnum value) {
            addCriterion("house_status <>", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusGreaterThan(HouseStateEnum value) {
            addCriterion("house_status >", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusGreaterThanOrEqualTo(HouseStateEnum value) {
            addCriterion("house_status >=", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusLessThan(HouseStateEnum value) {
            addCriterion("house_status <", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusLessThanOrEqualTo(HouseStateEnum value) {
            addCriterion("house_status <=", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusIn(List<HouseStateEnum> values) {
            addCriterion("house_status in", values, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNotIn(List<HouseStateEnum> values) {
            addCriterion("house_status not in", values, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusBetween(HouseStateEnum value1, HouseStateEnum value2) {
            addCriterion("house_status between", value1, value2, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNotBetween(HouseStateEnum value1, HouseStateEnum value2) {
            addCriterion("house_status not between", value1, value2, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNull() {
            addCriterion("unit_price is null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNotNull() {
            addCriterion("unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceEqualTo(BigDecimal value) {
            addCriterion("unit_price =", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("unit_price <>", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("unit_price >", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_price >=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThan(BigDecimal value) {
            addCriterion("unit_price <", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_price <=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIn(List<BigDecimal> values) {
            addCriterion("unit_price in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("unit_price not in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_price between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_price not between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(BigDecimal value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(BigDecimal value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<BigDecimal> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andHouseNumIsNull() {
            addCriterion("house_num is null");
            return (Criteria) this;
        }

        public Criteria andHouseNumIsNotNull() {
            addCriterion("house_num is not null");
            return (Criteria) this;
        }

        public Criteria andHouseNumEqualTo(String value) {
            addCriterion("house_num =", value, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumNotEqualTo(String value) {
            addCriterion("house_num <>", value, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumGreaterThan(String value) {
            addCriterion("house_num >", value, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumGreaterThanOrEqualTo(String value) {
            addCriterion("house_num >=", value, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumLessThan(String value) {
            addCriterion("house_num <", value, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumLessThanOrEqualTo(String value) {
            addCriterion("house_num <=", value, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumLike(String value) {
            addCriterion("house_num like", value, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumNotLike(String value) {
            addCriterion("house_num not like", value, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumIn(List<String> values) {
            addCriterion("house_num in", values, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumNotIn(List<String> values) {
            addCriterion("house_num not in", values, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumBetween(String value1, String value2) {
            addCriterion("house_num between", value1, value2, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumNotBetween(String value1, String value2) {
            addCriterion("house_num not between", value1, value2, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseTierIsNull() {
            addCriterion("house_tier is null");
            return (Criteria) this;
        }

        public Criteria andHouseTierIsNotNull() {
            addCriterion("house_tier is not null");
            return (Criteria) this;
        }

        public Criteria andHouseTierEqualTo(String value) {
            addCriterion("house_tier =", value, "houseTier");
            return (Criteria) this;
        }

        public Criteria andHouseTierNotEqualTo(String value) {
            addCriterion("house_tier <>", value, "houseTier");
            return (Criteria) this;
        }

        public Criteria andHouseTierGreaterThan(String value) {
            addCriterion("house_tier >", value, "houseTier");
            return (Criteria) this;
        }

        public Criteria andHouseTierGreaterThanOrEqualTo(String value) {
            addCriterion("house_tier >=", value, "houseTier");
            return (Criteria) this;
        }

        public Criteria andHouseTierLessThan(String value) {
            addCriterion("house_tier <", value, "houseTier");
            return (Criteria) this;
        }

        public Criteria andHouseTierLessThanOrEqualTo(String value) {
            addCriterion("house_tier <=", value, "houseTier");
            return (Criteria) this;
        }

        public Criteria andHouseTierLike(String value) {
            addCriterion("house_tier like", value, "houseTier");
            return (Criteria) this;
        }

        public Criteria andHouseTierNotLike(String value) {
            addCriterion("house_tier not like", value, "houseTier");
            return (Criteria) this;
        }

        public Criteria andHouseTierIn(List<String> values) {
            addCriterion("house_tier in", values, "houseTier");
            return (Criteria) this;
        }

        public Criteria andHouseTierNotIn(List<String> values) {
            addCriterion("house_tier not in", values, "houseTier");
            return (Criteria) this;
        }

        public Criteria andHouseTierBetween(String value1, String value2) {
            addCriterion("house_tier between", value1, value2, "houseTier");
            return (Criteria) this;
        }

        public Criteria andHouseTierNotBetween(String value1, String value2) {
            addCriterion("house_tier not between", value1, value2, "houseTier");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIsNull() {
            addCriterion("house_type is null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIsNotNull() {
            addCriterion("house_type is not null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeEqualTo(String value) {
            addCriterion("house_type =", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotEqualTo(String value) {
            addCriterion("house_type <>", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThan(String value) {
            addCriterion("house_type >", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("house_type >=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThan(String value) {
            addCriterion("house_type <", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThanOrEqualTo(String value) {
            addCriterion("house_type <=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLike(String value) {
            addCriterion("house_type like", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotLike(String value) {
            addCriterion("house_type not like", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIn(List<String> values) {
            addCriterion("house_type in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotIn(List<String> values) {
            addCriterion("house_type not in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeBetween(String value1, String value2) {
            addCriterion("house_type between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotBetween(String value1, String value2) {
            addCriterion("house_type not between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseStructureIsNull() {
            addCriterion("house_structure is null");
            return (Criteria) this;
        }

        public Criteria andHouseStructureIsNotNull() {
            addCriterion("house_structure is not null");
            return (Criteria) this;
        }

        public Criteria andHouseStructureEqualTo(String value) {
            addCriterion("house_structure =", value, "houseStructure");
            return (Criteria) this;
        }

        public Criteria andHouseStructureNotEqualTo(String value) {
            addCriterion("house_structure <>", value, "houseStructure");
            return (Criteria) this;
        }

        public Criteria andHouseStructureGreaterThan(String value) {
            addCriterion("house_structure >", value, "houseStructure");
            return (Criteria) this;
        }

        public Criteria andHouseStructureGreaterThanOrEqualTo(String value) {
            addCriterion("house_structure >=", value, "houseStructure");
            return (Criteria) this;
        }

        public Criteria andHouseStructureLessThan(String value) {
            addCriterion("house_structure <", value, "houseStructure");
            return (Criteria) this;
        }

        public Criteria andHouseStructureLessThanOrEqualTo(String value) {
            addCriterion("house_structure <=", value, "houseStructure");
            return (Criteria) this;
        }

        public Criteria andHouseStructureLike(String value) {
            addCriterion("house_structure like", value, "houseStructure");
            return (Criteria) this;
        }

        public Criteria andHouseStructureNotLike(String value) {
            addCriterion("house_structure not like", value, "houseStructure");
            return (Criteria) this;
        }

        public Criteria andHouseStructureIn(List<String> values) {
            addCriterion("house_structure in", values, "houseStructure");
            return (Criteria) this;
        }

        public Criteria andHouseStructureNotIn(List<String> values) {
            addCriterion("house_structure not in", values, "houseStructure");
            return (Criteria) this;
        }

        public Criteria andHouseStructureBetween(String value1, String value2) {
            addCriterion("house_structure between", value1, value2, "houseStructure");
            return (Criteria) this;
        }

        public Criteria andHouseStructureNotBetween(String value1, String value2) {
            addCriterion("house_structure not between", value1, value2, "houseStructure");
            return (Criteria) this;
        }

        public Criteria andInsideAreaIsNull() {
            addCriterion("inside_area is null");
            return (Criteria) this;
        }

        public Criteria andInsideAreaIsNotNull() {
            addCriterion("inside_area is not null");
            return (Criteria) this;
        }

        public Criteria andInsideAreaEqualTo(BigDecimal value) {
            addCriterion("inside_area =", value, "insideArea");
            return (Criteria) this;
        }

        public Criteria andInsideAreaNotEqualTo(BigDecimal value) {
            addCriterion("inside_area <>", value, "insideArea");
            return (Criteria) this;
        }

        public Criteria andInsideAreaGreaterThan(BigDecimal value) {
            addCriterion("inside_area >", value, "insideArea");
            return (Criteria) this;
        }

        public Criteria andInsideAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("inside_area >=", value, "insideArea");
            return (Criteria) this;
        }

        public Criteria andInsideAreaLessThan(BigDecimal value) {
            addCriterion("inside_area <", value, "insideArea");
            return (Criteria) this;
        }

        public Criteria andInsideAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("inside_area <=", value, "insideArea");
            return (Criteria) this;
        }

        public Criteria andInsideAreaIn(List<BigDecimal> values) {
            addCriterion("inside_area in", values, "insideArea");
            return (Criteria) this;
        }

        public Criteria andInsideAreaNotIn(List<BigDecimal> values) {
            addCriterion("inside_area not in", values, "insideArea");
            return (Criteria) this;
        }

        public Criteria andInsideAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("inside_area between", value1, value2, "insideArea");
            return (Criteria) this;
        }

        public Criteria andInsideAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("inside_area not between", value1, value2, "insideArea");
            return (Criteria) this;
        }

        public Criteria andApportionAreaIsNull() {
            addCriterion("apportion_area is null");
            return (Criteria) this;
        }

        public Criteria andApportionAreaIsNotNull() {
            addCriterion("apportion_area is not null");
            return (Criteria) this;
        }

        public Criteria andApportionAreaEqualTo(BigDecimal value) {
            addCriterion("apportion_area =", value, "apportionArea");
            return (Criteria) this;
        }

        public Criteria andApportionAreaNotEqualTo(BigDecimal value) {
            addCriterion("apportion_area <>", value, "apportionArea");
            return (Criteria) this;
        }

        public Criteria andApportionAreaGreaterThan(BigDecimal value) {
            addCriterion("apportion_area >", value, "apportionArea");
            return (Criteria) this;
        }

        public Criteria andApportionAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("apportion_area >=", value, "apportionArea");
            return (Criteria) this;
        }

        public Criteria andApportionAreaLessThan(BigDecimal value) {
            addCriterion("apportion_area <", value, "apportionArea");
            return (Criteria) this;
        }

        public Criteria andApportionAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("apportion_area <=", value, "apportionArea");
            return (Criteria) this;
        }

        public Criteria andApportionAreaIn(List<BigDecimal> values) {
            addCriterion("apportion_area in", values, "apportionArea");
            return (Criteria) this;
        }

        public Criteria andApportionAreaNotIn(List<BigDecimal> values) {
            addCriterion("apportion_area not in", values, "apportionArea");
            return (Criteria) this;
        }

        public Criteria andApportionAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("apportion_area between", value1, value2, "apportionArea");
            return (Criteria) this;
        }

        public Criteria andApportionAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("apportion_area not between", value1, value2, "apportionArea");
            return (Criteria) this;
        }

        public Criteria andBalconyAreaIsNull() {
            addCriterion("balcony_area is null");
            return (Criteria) this;
        }

        public Criteria andBalconyAreaIsNotNull() {
            addCriterion("balcony_area is not null");
            return (Criteria) this;
        }

        public Criteria andBalconyAreaEqualTo(BigDecimal value) {
            addCriterion("balcony_area =", value, "balconyArea");
            return (Criteria) this;
        }

        public Criteria andBalconyAreaNotEqualTo(BigDecimal value) {
            addCriterion("balcony_area <>", value, "balconyArea");
            return (Criteria) this;
        }

        public Criteria andBalconyAreaGreaterThan(BigDecimal value) {
            addCriterion("balcony_area >", value, "balconyArea");
            return (Criteria) this;
        }

        public Criteria andBalconyAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balcony_area >=", value, "balconyArea");
            return (Criteria) this;
        }

        public Criteria andBalconyAreaLessThan(BigDecimal value) {
            addCriterion("balcony_area <", value, "balconyArea");
            return (Criteria) this;
        }

        public Criteria andBalconyAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balcony_area <=", value, "balconyArea");
            return (Criteria) this;
        }

        public Criteria andBalconyAreaIn(List<BigDecimal> values) {
            addCriterion("balcony_area in", values, "balconyArea");
            return (Criteria) this;
        }

        public Criteria andBalconyAreaNotIn(List<BigDecimal> values) {
            addCriterion("balcony_area not in", values, "balconyArea");
            return (Criteria) this;
        }

        public Criteria andBalconyAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balcony_area between", value1, value2, "balconyArea");
            return (Criteria) this;
        }

        public Criteria andBalconyAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balcony_area not between", value1, value2, "balconyArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaIsNull() {
            addCriterion("sales_area is null");
            return (Criteria) this;
        }

        public Criteria andSalesAreaIsNotNull() {
            addCriterion("sales_area is not null");
            return (Criteria) this;
        }

        public Criteria andSalesAreaEqualTo(BigDecimal value) {
            addCriterion("sales_area =", value, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaNotEqualTo(BigDecimal value) {
            addCriterion("sales_area <>", value, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaGreaterThan(BigDecimal value) {
            addCriterion("sales_area >", value, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sales_area >=", value, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaLessThan(BigDecimal value) {
            addCriterion("sales_area <", value, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sales_area <=", value, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaIn(List<BigDecimal> values) {
            addCriterion("sales_area in", values, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaNotIn(List<BigDecimal> values) {
            addCriterion("sales_area not in", values, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sales_area between", value1, value2, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sales_area not between", value1, value2, "salesArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIsNull() {
            addCriterion("build_area is null");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIsNotNull() {
            addCriterion("build_area is not null");
            return (Criteria) this;
        }

        public Criteria andBuildAreaEqualTo(BigDecimal value) {
            addCriterion("build_area =", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotEqualTo(BigDecimal value) {
            addCriterion("build_area <>", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaGreaterThan(BigDecimal value) {
            addCriterion("build_area >", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("build_area >=", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaLessThan(BigDecimal value) {
            addCriterion("build_area <", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("build_area <=", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIn(List<BigDecimal> values) {
            addCriterion("build_area in", values, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotIn(List<BigDecimal> values) {
            addCriterion("build_area not in", values, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("build_area between", value1, value2, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("build_area not between", value1, value2, "buildArea");
            return (Criteria) this;
        }

        public Criteria andApportionRatioIsNull() {
            addCriterion("apportion_ratio is null");
            return (Criteria) this;
        }

        public Criteria andApportionRatioIsNotNull() {
            addCriterion("apportion_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andApportionRatioEqualTo(BigDecimal value) {
            addCriterion("apportion_ratio =", value, "apportionRatio");
            return (Criteria) this;
        }

        public Criteria andApportionRatioNotEqualTo(BigDecimal value) {
            addCriterion("apportion_ratio <>", value, "apportionRatio");
            return (Criteria) this;
        }

        public Criteria andApportionRatioGreaterThan(BigDecimal value) {
            addCriterion("apportion_ratio >", value, "apportionRatio");
            return (Criteria) this;
        }

        public Criteria andApportionRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("apportion_ratio >=", value, "apportionRatio");
            return (Criteria) this;
        }

        public Criteria andApportionRatioLessThan(BigDecimal value) {
            addCriterion("apportion_ratio <", value, "apportionRatio");
            return (Criteria) this;
        }

        public Criteria andApportionRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("apportion_ratio <=", value, "apportionRatio");
            return (Criteria) this;
        }

        public Criteria andApportionRatioIn(List<BigDecimal> values) {
            addCriterion("apportion_ratio in", values, "apportionRatio");
            return (Criteria) this;
        }

        public Criteria andApportionRatioNotIn(List<BigDecimal> values) {
            addCriterion("apportion_ratio not in", values, "apportionRatio");
            return (Criteria) this;
        }

        public Criteria andApportionRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("apportion_ratio between", value1, value2, "apportionRatio");
            return (Criteria) this;
        }

        public Criteria andApportionRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("apportion_ratio not between", value1, value2, "apportionRatio");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andDataStatusIsNull() {
            addCriterion("data_status is null");
            return (Criteria) this;
        }

        public Criteria andDataStatusIsNotNull() {
            addCriterion("data_status is not null");
            return (Criteria) this;
        }

        public Criteria andDataStatusEqualTo(DataStatus value) {
            addCriterion("data_status =", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotEqualTo(DataStatus value) {
            addCriterion("data_status <>", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusGreaterThan(DataStatus value) {
            addCriterion("data_status >", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusGreaterThanOrEqualTo(DataStatus value) {
            addCriterion("data_status >=", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusLessThan(DataStatus value) {
            addCriterion("data_status <", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusLessThanOrEqualTo(DataStatus value) {
            addCriterion("data_status <=", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusIn(List<DataStatus> values) {
            addCriterion("data_status in", values, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotIn(List<DataStatus> values) {
            addCriterion("data_status not in", values, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusBetween(DataStatus value1, DataStatus value2) {
            addCriterion("data_status between", value1, value2, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotBetween(DataStatus value1, DataStatus value2) {
            addCriterion("data_status not between", value1, value2, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Integer value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Integer value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Integer value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Integer value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Integer> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Integer> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(Integer value) {
            addCriterion("update_user_id =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(Integer value) {
            addCriterion("update_user_id <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(Integer value) {
            addCriterion("update_user_id >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_user_id >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(Integer value) {
            addCriterion("update_user_id <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("update_user_id <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<Integer> values) {
            addCriterion("update_user_id in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<Integer> values) {
            addCriterion("update_user_id not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("update_user_id between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("update_user_id not between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    /**
     * tb_syfc_house
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * tb_syfc_house 2019-04-03
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}