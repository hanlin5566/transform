package com.hanson.transform.dao.gen.entity;

import com.hanson.base.enums.DataStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SYFCSalesNoExample {
    /**
     * tb_syfc_sales_no
     */
    protected String orderByClause;

    /**
     * tb_syfc_sales_no
     */
    protected boolean distinct;

    /**
     * tb_syfc_sales_no
     */
    protected List<Criteria> oredCriteria;

    public SYFCSalesNoExample() {
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
     * tb_syfc_sales_no 2019-02-28
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

        public Criteria andThirdNoIsNull() {
            addCriterion("third_no is null");
            return (Criteria) this;
        }

        public Criteria andThirdNoIsNotNull() {
            addCriterion("third_no is not null");
            return (Criteria) this;
        }

        public Criteria andThirdNoEqualTo(Integer value) {
            addCriterion("third_no =", value, "thirdNo");
            return (Criteria) this;
        }

        public Criteria andThirdNoNotEqualTo(Integer value) {
            addCriterion("third_no <>", value, "thirdNo");
            return (Criteria) this;
        }

        public Criteria andThirdNoGreaterThan(Integer value) {
            addCriterion("third_no >", value, "thirdNo");
            return (Criteria) this;
        }

        public Criteria andThirdNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("third_no >=", value, "thirdNo");
            return (Criteria) this;
        }

        public Criteria andThirdNoLessThan(Integer value) {
            addCriterion("third_no <", value, "thirdNo");
            return (Criteria) this;
        }

        public Criteria andThirdNoLessThanOrEqualTo(Integer value) {
            addCriterion("third_no <=", value, "thirdNo");
            return (Criteria) this;
        }

        public Criteria andThirdNoIn(List<Integer> values) {
            addCriterion("third_no in", values, "thirdNo");
            return (Criteria) this;
        }

        public Criteria andThirdNoNotIn(List<Integer> values) {
            addCriterion("third_no not in", values, "thirdNo");
            return (Criteria) this;
        }

        public Criteria andThirdNoBetween(Integer value1, Integer value2) {
            addCriterion("third_no between", value1, value2, "thirdNo");
            return (Criteria) this;
        }

        public Criteria andThirdNoNotBetween(Integer value1, Integer value2) {
            addCriterion("third_no not between", value1, value2, "thirdNo");
            return (Criteria) this;
        }

        public Criteria andThirdRecordIdIsNull() {
            addCriterion("third_record_id is null");
            return (Criteria) this;
        }

        public Criteria andThirdRecordIdIsNotNull() {
            addCriterion("third_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andThirdRecordIdEqualTo(String value) {
            addCriterion("third_record_id =", value, "thirdRecordId");
            return (Criteria) this;
        }

        public Criteria andThirdRecordIdNotEqualTo(String value) {
            addCriterion("third_record_id <>", value, "thirdRecordId");
            return (Criteria) this;
        }

        public Criteria andThirdRecordIdGreaterThan(String value) {
            addCriterion("third_record_id >", value, "thirdRecordId");
            return (Criteria) this;
        }

        public Criteria andThirdRecordIdGreaterThanOrEqualTo(String value) {
            addCriterion("third_record_id >=", value, "thirdRecordId");
            return (Criteria) this;
        }

        public Criteria andThirdRecordIdLessThan(String value) {
            addCriterion("third_record_id <", value, "thirdRecordId");
            return (Criteria) this;
        }

        public Criteria andThirdRecordIdLessThanOrEqualTo(String value) {
            addCriterion("third_record_id <=", value, "thirdRecordId");
            return (Criteria) this;
        }

        public Criteria andThirdRecordIdLike(String value) {
            addCriterion("third_record_id like", value, "thirdRecordId");
            return (Criteria) this;
        }

        public Criteria andThirdRecordIdNotLike(String value) {
            addCriterion("third_record_id not like", value, "thirdRecordId");
            return (Criteria) this;
        }

        public Criteria andThirdRecordIdIn(List<String> values) {
            addCriterion("third_record_id in", values, "thirdRecordId");
            return (Criteria) this;
        }

        public Criteria andThirdRecordIdNotIn(List<String> values) {
            addCriterion("third_record_id not in", values, "thirdRecordId");
            return (Criteria) this;
        }

        public Criteria andThirdRecordIdBetween(String value1, String value2) {
            addCriterion("third_record_id between", value1, value2, "thirdRecordId");
            return (Criteria) this;
        }

        public Criteria andThirdRecordIdNotBetween(String value1, String value2) {
            addCriterion("third_record_id not between", value1, value2, "thirdRecordId");
            return (Criteria) this;
        }

        public Criteria andSalesNoIsNull() {
            addCriterion("sales_no is null");
            return (Criteria) this;
        }

        public Criteria andSalesNoIsNotNull() {
            addCriterion("sales_no is not null");
            return (Criteria) this;
        }

        public Criteria andSalesNoEqualTo(String value) {
            addCriterion("sales_no =", value, "salesNo");
            return (Criteria) this;
        }

        public Criteria andSalesNoNotEqualTo(String value) {
            addCriterion("sales_no <>", value, "salesNo");
            return (Criteria) this;
        }

        public Criteria andSalesNoGreaterThan(String value) {
            addCriterion("sales_no >", value, "salesNo");
            return (Criteria) this;
        }

        public Criteria andSalesNoGreaterThanOrEqualTo(String value) {
            addCriterion("sales_no >=", value, "salesNo");
            return (Criteria) this;
        }

        public Criteria andSalesNoLessThan(String value) {
            addCriterion("sales_no <", value, "salesNo");
            return (Criteria) this;
        }

        public Criteria andSalesNoLessThanOrEqualTo(String value) {
            addCriterion("sales_no <=", value, "salesNo");
            return (Criteria) this;
        }

        public Criteria andSalesNoLike(String value) {
            addCriterion("sales_no like", value, "salesNo");
            return (Criteria) this;
        }

        public Criteria andSalesNoNotLike(String value) {
            addCriterion("sales_no not like", value, "salesNo");
            return (Criteria) this;
        }

        public Criteria andSalesNoIn(List<String> values) {
            addCriterion("sales_no in", values, "salesNo");
            return (Criteria) this;
        }

        public Criteria andSalesNoNotIn(List<String> values) {
            addCriterion("sales_no not in", values, "salesNo");
            return (Criteria) this;
        }

        public Criteria andSalesNoBetween(String value1, String value2) {
            addCriterion("sales_no between", value1, value2, "salesNo");
            return (Criteria) this;
        }

        public Criteria andSalesNoNotBetween(String value1, String value2) {
            addCriterion("sales_no not between", value1, value2, "salesNo");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyFriendlyIsNull() {
            addCriterion("company_friendly is null");
            return (Criteria) this;
        }

        public Criteria andCompanyFriendlyIsNotNull() {
            addCriterion("company_friendly is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyFriendlyEqualTo(String value) {
            addCriterion("company_friendly =", value, "companyFriendly");
            return (Criteria) this;
        }

        public Criteria andCompanyFriendlyNotEqualTo(String value) {
            addCriterion("company_friendly <>", value, "companyFriendly");
            return (Criteria) this;
        }

        public Criteria andCompanyFriendlyGreaterThan(String value) {
            addCriterion("company_friendly >", value, "companyFriendly");
            return (Criteria) this;
        }

        public Criteria andCompanyFriendlyGreaterThanOrEqualTo(String value) {
            addCriterion("company_friendly >=", value, "companyFriendly");
            return (Criteria) this;
        }

        public Criteria andCompanyFriendlyLessThan(String value) {
            addCriterion("company_friendly <", value, "companyFriendly");
            return (Criteria) this;
        }

        public Criteria andCompanyFriendlyLessThanOrEqualTo(String value) {
            addCriterion("company_friendly <=", value, "companyFriendly");
            return (Criteria) this;
        }

        public Criteria andCompanyFriendlyLike(String value) {
            addCriterion("company_friendly like", value, "companyFriendly");
            return (Criteria) this;
        }

        public Criteria andCompanyFriendlyNotLike(String value) {
            addCriterion("company_friendly not like", value, "companyFriendly");
            return (Criteria) this;
        }

        public Criteria andCompanyFriendlyIn(List<String> values) {
            addCriterion("company_friendly in", values, "companyFriendly");
            return (Criteria) this;
        }

        public Criteria andCompanyFriendlyNotIn(List<String> values) {
            addCriterion("company_friendly not in", values, "companyFriendly");
            return (Criteria) this;
        }

        public Criteria andCompanyFriendlyBetween(String value1, String value2) {
            addCriterion("company_friendly between", value1, value2, "companyFriendly");
            return (Criteria) this;
        }

        public Criteria andCompanyFriendlyNotBetween(String value1, String value2) {
            addCriterion("company_friendly not between", value1, value2, "companyFriendly");
            return (Criteria) this;
        }

        public Criteria andProgramNameIsNull() {
            addCriterion("program_name is null");
            return (Criteria) this;
        }

        public Criteria andProgramNameIsNotNull() {
            addCriterion("program_name is not null");
            return (Criteria) this;
        }

        public Criteria andProgramNameEqualTo(String value) {
            addCriterion("program_name =", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameNotEqualTo(String value) {
            addCriterion("program_name <>", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameGreaterThan(String value) {
            addCriterion("program_name >", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameGreaterThanOrEqualTo(String value) {
            addCriterion("program_name >=", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameLessThan(String value) {
            addCriterion("program_name <", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameLessThanOrEqualTo(String value) {
            addCriterion("program_name <=", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameLike(String value) {
            addCriterion("program_name like", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameNotLike(String value) {
            addCriterion("program_name not like", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameIn(List<String> values) {
            addCriterion("program_name in", values, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameNotIn(List<String> values) {
            addCriterion("program_name not in", values, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameBetween(String value1, String value2) {
            addCriterion("program_name between", value1, value2, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameNotBetween(String value1, String value2) {
            addCriterion("program_name not between", value1, value2, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionIsNull() {
            addCriterion("program_localtion is null");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionIsNotNull() {
            addCriterion("program_localtion is not null");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionEqualTo(String value) {
            addCriterion("program_localtion =", value, "programLocaltion");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionNotEqualTo(String value) {
            addCriterion("program_localtion <>", value, "programLocaltion");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionGreaterThan(String value) {
            addCriterion("program_localtion >", value, "programLocaltion");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionGreaterThanOrEqualTo(String value) {
            addCriterion("program_localtion >=", value, "programLocaltion");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionLessThan(String value) {
            addCriterion("program_localtion <", value, "programLocaltion");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionLessThanOrEqualTo(String value) {
            addCriterion("program_localtion <=", value, "programLocaltion");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionLike(String value) {
            addCriterion("program_localtion like", value, "programLocaltion");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionNotLike(String value) {
            addCriterion("program_localtion not like", value, "programLocaltion");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionIn(List<String> values) {
            addCriterion("program_localtion in", values, "programLocaltion");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionNotIn(List<String> values) {
            addCriterion("program_localtion not in", values, "programLocaltion");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionBetween(String value1, String value2) {
            addCriterion("program_localtion between", value1, value2, "programLocaltion");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionNotBetween(String value1, String value2) {
            addCriterion("program_localtion not between", value1, value2, "programLocaltion");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionFriendlyIsNull() {
            addCriterion("program_localtion_friendly is null");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionFriendlyIsNotNull() {
            addCriterion("program_localtion_friendly is not null");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionFriendlyEqualTo(String value) {
            addCriterion("program_localtion_friendly =", value, "programLocaltionFriendly");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionFriendlyNotEqualTo(String value) {
            addCriterion("program_localtion_friendly <>", value, "programLocaltionFriendly");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionFriendlyGreaterThan(String value) {
            addCriterion("program_localtion_friendly >", value, "programLocaltionFriendly");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionFriendlyGreaterThanOrEqualTo(String value) {
            addCriterion("program_localtion_friendly >=", value, "programLocaltionFriendly");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionFriendlyLessThan(String value) {
            addCriterion("program_localtion_friendly <", value, "programLocaltionFriendly");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionFriendlyLessThanOrEqualTo(String value) {
            addCriterion("program_localtion_friendly <=", value, "programLocaltionFriendly");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionFriendlyLike(String value) {
            addCriterion("program_localtion_friendly like", value, "programLocaltionFriendly");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionFriendlyNotLike(String value) {
            addCriterion("program_localtion_friendly not like", value, "programLocaltionFriendly");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionFriendlyIn(List<String> values) {
            addCriterion("program_localtion_friendly in", values, "programLocaltionFriendly");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionFriendlyNotIn(List<String> values) {
            addCriterion("program_localtion_friendly not in", values, "programLocaltionFriendly");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionFriendlyBetween(String value1, String value2) {
            addCriterion("program_localtion_friendly between", value1, value2, "programLocaltionFriendly");
            return (Criteria) this;
        }

        public Criteria andProgramLocaltionFriendlyNotBetween(String value1, String value2) {
            addCriterion("program_localtion_friendly not between", value1, value2, "programLocaltionFriendly");
            return (Criteria) this;
        }

        public Criteria andBuildCountIsNull() {
            addCriterion("build_count is null");
            return (Criteria) this;
        }

        public Criteria andBuildCountIsNotNull() {
            addCriterion("build_count is not null");
            return (Criteria) this;
        }

        public Criteria andBuildCountEqualTo(Integer value) {
            addCriterion("build_count =", value, "buildCount");
            return (Criteria) this;
        }

        public Criteria andBuildCountNotEqualTo(Integer value) {
            addCriterion("build_count <>", value, "buildCount");
            return (Criteria) this;
        }

        public Criteria andBuildCountGreaterThan(Integer value) {
            addCriterion("build_count >", value, "buildCount");
            return (Criteria) this;
        }

        public Criteria andBuildCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("build_count >=", value, "buildCount");
            return (Criteria) this;
        }

        public Criteria andBuildCountLessThan(Integer value) {
            addCriterion("build_count <", value, "buildCount");
            return (Criteria) this;
        }

        public Criteria andBuildCountLessThanOrEqualTo(Integer value) {
            addCriterion("build_count <=", value, "buildCount");
            return (Criteria) this;
        }

        public Criteria andBuildCountIn(List<Integer> values) {
            addCriterion("build_count in", values, "buildCount");
            return (Criteria) this;
        }

        public Criteria andBuildCountNotIn(List<Integer> values) {
            addCriterion("build_count not in", values, "buildCount");
            return (Criteria) this;
        }

        public Criteria andBuildCountBetween(Integer value1, Integer value2) {
            addCriterion("build_count between", value1, value2, "buildCount");
            return (Criteria) this;
        }

        public Criteria andBuildCountNotBetween(Integer value1, Integer value2) {
            addCriterion("build_count not between", value1, value2, "buildCount");
            return (Criteria) this;
        }

        public Criteria andTotalBuildAreaIsNull() {
            addCriterion("total_build_area is null");
            return (Criteria) this;
        }

        public Criteria andTotalBuildAreaIsNotNull() {
            addCriterion("total_build_area is not null");
            return (Criteria) this;
        }

        public Criteria andTotalBuildAreaEqualTo(Float value) {
            addCriterion("total_build_area =", value, "totalBuildArea");
            return (Criteria) this;
        }

        public Criteria andTotalBuildAreaNotEqualTo(Float value) {
            addCriterion("total_build_area <>", value, "totalBuildArea");
            return (Criteria) this;
        }

        public Criteria andTotalBuildAreaGreaterThan(Float value) {
            addCriterion("total_build_area >", value, "totalBuildArea");
            return (Criteria) this;
        }

        public Criteria andTotalBuildAreaGreaterThanOrEqualTo(Float value) {
            addCriterion("total_build_area >=", value, "totalBuildArea");
            return (Criteria) this;
        }

        public Criteria andTotalBuildAreaLessThan(Float value) {
            addCriterion("total_build_area <", value, "totalBuildArea");
            return (Criteria) this;
        }

        public Criteria andTotalBuildAreaLessThanOrEqualTo(Float value) {
            addCriterion("total_build_area <=", value, "totalBuildArea");
            return (Criteria) this;
        }

        public Criteria andTotalBuildAreaIn(List<Float> values) {
            addCriterion("total_build_area in", values, "totalBuildArea");
            return (Criteria) this;
        }

        public Criteria andTotalBuildAreaNotIn(List<Float> values) {
            addCriterion("total_build_area not in", values, "totalBuildArea");
            return (Criteria) this;
        }

        public Criteria andTotalBuildAreaBetween(Float value1, Float value2) {
            addCriterion("total_build_area between", value1, value2, "totalBuildArea");
            return (Criteria) this;
        }

        public Criteria andTotalBuildAreaNotBetween(Float value1, Float value2) {
            addCriterion("total_build_area not between", value1, value2, "totalBuildArea");
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

        public Criteria andSalesAreaEqualTo(Float value) {
            addCriterion("sales_area =", value, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaNotEqualTo(Float value) {
            addCriterion("sales_area <>", value, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaGreaterThan(Float value) {
            addCriterion("sales_area >", value, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaGreaterThanOrEqualTo(Float value) {
            addCriterion("sales_area >=", value, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaLessThan(Float value) {
            addCriterion("sales_area <", value, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaLessThanOrEqualTo(Float value) {
            addCriterion("sales_area <=", value, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaIn(List<Float> values) {
            addCriterion("sales_area in", values, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaNotIn(List<Float> values) {
            addCriterion("sales_area not in", values, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaBetween(Float value1, Float value2) {
            addCriterion("sales_area between", value1, value2, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaNotBetween(Float value1, Float value2) {
            addCriterion("sales_area not between", value1, value2, "salesArea");
            return (Criteria) this;
        }

        public Criteria andDwellingAreaIsNull() {
            addCriterion("dwelling_area is null");
            return (Criteria) this;
        }

        public Criteria andDwellingAreaIsNotNull() {
            addCriterion("dwelling_area is not null");
            return (Criteria) this;
        }

        public Criteria andDwellingAreaEqualTo(Float value) {
            addCriterion("dwelling_area =", value, "dwellingArea");
            return (Criteria) this;
        }

        public Criteria andDwellingAreaNotEqualTo(Float value) {
            addCriterion("dwelling_area <>", value, "dwellingArea");
            return (Criteria) this;
        }

        public Criteria andDwellingAreaGreaterThan(Float value) {
            addCriterion("dwelling_area >", value, "dwellingArea");
            return (Criteria) this;
        }

        public Criteria andDwellingAreaGreaterThanOrEqualTo(Float value) {
            addCriterion("dwelling_area >=", value, "dwellingArea");
            return (Criteria) this;
        }

        public Criteria andDwellingAreaLessThan(Float value) {
            addCriterion("dwelling_area <", value, "dwellingArea");
            return (Criteria) this;
        }

        public Criteria andDwellingAreaLessThanOrEqualTo(Float value) {
            addCriterion("dwelling_area <=", value, "dwellingArea");
            return (Criteria) this;
        }

        public Criteria andDwellingAreaIn(List<Float> values) {
            addCriterion("dwelling_area in", values, "dwellingArea");
            return (Criteria) this;
        }

        public Criteria andDwellingAreaNotIn(List<Float> values) {
            addCriterion("dwelling_area not in", values, "dwellingArea");
            return (Criteria) this;
        }

        public Criteria andDwellingAreaBetween(Float value1, Float value2) {
            addCriterion("dwelling_area between", value1, value2, "dwellingArea");
            return (Criteria) this;
        }

        public Criteria andDwellingAreaNotBetween(Float value1, Float value2) {
            addCriterion("dwelling_area not between", value1, value2, "dwellingArea");
            return (Criteria) this;
        }

        public Criteria andShopAreaIsNull() {
            addCriterion("shop_area is null");
            return (Criteria) this;
        }

        public Criteria andShopAreaIsNotNull() {
            addCriterion("shop_area is not null");
            return (Criteria) this;
        }

        public Criteria andShopAreaEqualTo(Float value) {
            addCriterion("shop_area =", value, "shopArea");
            return (Criteria) this;
        }

        public Criteria andShopAreaNotEqualTo(Float value) {
            addCriterion("shop_area <>", value, "shopArea");
            return (Criteria) this;
        }

        public Criteria andShopAreaGreaterThan(Float value) {
            addCriterion("shop_area >", value, "shopArea");
            return (Criteria) this;
        }

        public Criteria andShopAreaGreaterThanOrEqualTo(Float value) {
            addCriterion("shop_area >=", value, "shopArea");
            return (Criteria) this;
        }

        public Criteria andShopAreaLessThan(Float value) {
            addCriterion("shop_area <", value, "shopArea");
            return (Criteria) this;
        }

        public Criteria andShopAreaLessThanOrEqualTo(Float value) {
            addCriterion("shop_area <=", value, "shopArea");
            return (Criteria) this;
        }

        public Criteria andShopAreaIn(List<Float> values) {
            addCriterion("shop_area in", values, "shopArea");
            return (Criteria) this;
        }

        public Criteria andShopAreaNotIn(List<Float> values) {
            addCriterion("shop_area not in", values, "shopArea");
            return (Criteria) this;
        }

        public Criteria andShopAreaBetween(Float value1, Float value2) {
            addCriterion("shop_area between", value1, value2, "shopArea");
            return (Criteria) this;
        }

        public Criteria andShopAreaNotBetween(Float value1, Float value2) {
            addCriterion("shop_area not between", value1, value2, "shopArea");
            return (Criteria) this;
        }

        public Criteria andPublicAreaIsNull() {
            addCriterion("public_area is null");
            return (Criteria) this;
        }

        public Criteria andPublicAreaIsNotNull() {
            addCriterion("public_area is not null");
            return (Criteria) this;
        }

        public Criteria andPublicAreaEqualTo(Float value) {
            addCriterion("public_area =", value, "publicArea");
            return (Criteria) this;
        }

        public Criteria andPublicAreaNotEqualTo(Float value) {
            addCriterion("public_area <>", value, "publicArea");
            return (Criteria) this;
        }

        public Criteria andPublicAreaGreaterThan(Float value) {
            addCriterion("public_area >", value, "publicArea");
            return (Criteria) this;
        }

        public Criteria andPublicAreaGreaterThanOrEqualTo(Float value) {
            addCriterion("public_area >=", value, "publicArea");
            return (Criteria) this;
        }

        public Criteria andPublicAreaLessThan(Float value) {
            addCriterion("public_area <", value, "publicArea");
            return (Criteria) this;
        }

        public Criteria andPublicAreaLessThanOrEqualTo(Float value) {
            addCriterion("public_area <=", value, "publicArea");
            return (Criteria) this;
        }

        public Criteria andPublicAreaIn(List<Float> values) {
            addCriterion("public_area in", values, "publicArea");
            return (Criteria) this;
        }

        public Criteria andPublicAreaNotIn(List<Float> values) {
            addCriterion("public_area not in", values, "publicArea");
            return (Criteria) this;
        }

        public Criteria andPublicAreaBetween(Float value1, Float value2) {
            addCriterion("public_area between", value1, value2, "publicArea");
            return (Criteria) this;
        }

        public Criteria andPublicAreaNotBetween(Float value1, Float value2) {
            addCriterion("public_area not between", value1, value2, "publicArea");
            return (Criteria) this;
        }

        public Criteria andOtherAreaIsNull() {
            addCriterion("other_area is null");
            return (Criteria) this;
        }

        public Criteria andOtherAreaIsNotNull() {
            addCriterion("other_area is not null");
            return (Criteria) this;
        }

        public Criteria andOtherAreaEqualTo(Float value) {
            addCriterion("other_area =", value, "otherArea");
            return (Criteria) this;
        }

        public Criteria andOtherAreaNotEqualTo(Float value) {
            addCriterion("other_area <>", value, "otherArea");
            return (Criteria) this;
        }

        public Criteria andOtherAreaGreaterThan(Float value) {
            addCriterion("other_area >", value, "otherArea");
            return (Criteria) this;
        }

        public Criteria andOtherAreaGreaterThanOrEqualTo(Float value) {
            addCriterion("other_area >=", value, "otherArea");
            return (Criteria) this;
        }

        public Criteria andOtherAreaLessThan(Float value) {
            addCriterion("other_area <", value, "otherArea");
            return (Criteria) this;
        }

        public Criteria andOtherAreaLessThanOrEqualTo(Float value) {
            addCriterion("other_area <=", value, "otherArea");
            return (Criteria) this;
        }

        public Criteria andOtherAreaIn(List<Float> values) {
            addCriterion("other_area in", values, "otherArea");
            return (Criteria) this;
        }

        public Criteria andOtherAreaNotIn(List<Float> values) {
            addCriterion("other_area not in", values, "otherArea");
            return (Criteria) this;
        }

        public Criteria andOtherAreaBetween(Float value1, Float value2) {
            addCriterion("other_area between", value1, value2, "otherArea");
            return (Criteria) this;
        }

        public Criteria andOtherAreaNotBetween(Float value1, Float value2) {
            addCriterion("other_area not between", value1, value2, "otherArea");
            return (Criteria) this;
        }

        public Criteria andApproveDateIsNull() {
            addCriterion("approve_date is null");
            return (Criteria) this;
        }

        public Criteria andApproveDateIsNotNull() {
            addCriterion("approve_date is not null");
            return (Criteria) this;
        }

        public Criteria andApproveDateEqualTo(Date value) {
            addCriterion("approve_date =", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotEqualTo(Date value) {
            addCriterion("approve_date <>", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateGreaterThan(Date value) {
            addCriterion("approve_date >", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateGreaterThanOrEqualTo(Date value) {
            addCriterion("approve_date >=", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateLessThan(Date value) {
            addCriterion("approve_date <", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateLessThanOrEqualTo(Date value) {
            addCriterion("approve_date <=", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateIn(List<Date> values) {
            addCriterion("approve_date in", values, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotIn(List<Date> values) {
            addCriterion("approve_date not in", values, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateBetween(Date value1, Date value2) {
            addCriterion("approve_date between", value1, value2, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotBetween(Date value1, Date value2) {
            addCriterion("approve_date not between", value1, value2, "approveDate");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildNoIsNull() {
            addCriterion("dwelling_build_no is null");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildNoIsNotNull() {
            addCriterion("dwelling_build_no is not null");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildNoEqualTo(String value) {
            addCriterion("dwelling_build_no =", value, "dwellingBuildNo");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildNoNotEqualTo(String value) {
            addCriterion("dwelling_build_no <>", value, "dwellingBuildNo");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildNoGreaterThan(String value) {
            addCriterion("dwelling_build_no >", value, "dwellingBuildNo");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildNoGreaterThanOrEqualTo(String value) {
            addCriterion("dwelling_build_no >=", value, "dwellingBuildNo");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildNoLessThan(String value) {
            addCriterion("dwelling_build_no <", value, "dwellingBuildNo");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildNoLessThanOrEqualTo(String value) {
            addCriterion("dwelling_build_no <=", value, "dwellingBuildNo");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildNoLike(String value) {
            addCriterion("dwelling_build_no like", value, "dwellingBuildNo");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildNoNotLike(String value) {
            addCriterion("dwelling_build_no not like", value, "dwellingBuildNo");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildNoIn(List<String> values) {
            addCriterion("dwelling_build_no in", values, "dwellingBuildNo");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildNoNotIn(List<String> values) {
            addCriterion("dwelling_build_no not in", values, "dwellingBuildNo");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildNoBetween(String value1, String value2) {
            addCriterion("dwelling_build_no between", value1, value2, "dwellingBuildNo");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildNoNotBetween(String value1, String value2) {
            addCriterion("dwelling_build_no not between", value1, value2, "dwellingBuildNo");
            return (Criteria) this;
        }

        public Criteria andShopBuildNoIsNull() {
            addCriterion("shop_build_no is null");
            return (Criteria) this;
        }

        public Criteria andShopBuildNoIsNotNull() {
            addCriterion("shop_build_no is not null");
            return (Criteria) this;
        }

        public Criteria andShopBuildNoEqualTo(String value) {
            addCriterion("shop_build_no =", value, "shopBuildNo");
            return (Criteria) this;
        }

        public Criteria andShopBuildNoNotEqualTo(String value) {
            addCriterion("shop_build_no <>", value, "shopBuildNo");
            return (Criteria) this;
        }

        public Criteria andShopBuildNoGreaterThan(String value) {
            addCriterion("shop_build_no >", value, "shopBuildNo");
            return (Criteria) this;
        }

        public Criteria andShopBuildNoGreaterThanOrEqualTo(String value) {
            addCriterion("shop_build_no >=", value, "shopBuildNo");
            return (Criteria) this;
        }

        public Criteria andShopBuildNoLessThan(String value) {
            addCriterion("shop_build_no <", value, "shopBuildNo");
            return (Criteria) this;
        }

        public Criteria andShopBuildNoLessThanOrEqualTo(String value) {
            addCriterion("shop_build_no <=", value, "shopBuildNo");
            return (Criteria) this;
        }

        public Criteria andShopBuildNoLike(String value) {
            addCriterion("shop_build_no like", value, "shopBuildNo");
            return (Criteria) this;
        }

        public Criteria andShopBuildNoNotLike(String value) {
            addCriterion("shop_build_no not like", value, "shopBuildNo");
            return (Criteria) this;
        }

        public Criteria andShopBuildNoIn(List<String> values) {
            addCriterion("shop_build_no in", values, "shopBuildNo");
            return (Criteria) this;
        }

        public Criteria andShopBuildNoNotIn(List<String> values) {
            addCriterion("shop_build_no not in", values, "shopBuildNo");
            return (Criteria) this;
        }

        public Criteria andShopBuildNoBetween(String value1, String value2) {
            addCriterion("shop_build_no between", value1, value2, "shopBuildNo");
            return (Criteria) this;
        }

        public Criteria andShopBuildNoNotBetween(String value1, String value2) {
            addCriterion("shop_build_no not between", value1, value2, "shopBuildNo");
            return (Criteria) this;
        }

        public Criteria andPublicBuildNoIsNull() {
            addCriterion("public_build_no is null");
            return (Criteria) this;
        }

        public Criteria andPublicBuildNoIsNotNull() {
            addCriterion("public_build_no is not null");
            return (Criteria) this;
        }

        public Criteria andPublicBuildNoEqualTo(String value) {
            addCriterion("public_build_no =", value, "publicBuildNo");
            return (Criteria) this;
        }

        public Criteria andPublicBuildNoNotEqualTo(String value) {
            addCriterion("public_build_no <>", value, "publicBuildNo");
            return (Criteria) this;
        }

        public Criteria andPublicBuildNoGreaterThan(String value) {
            addCriterion("public_build_no >", value, "publicBuildNo");
            return (Criteria) this;
        }

        public Criteria andPublicBuildNoGreaterThanOrEqualTo(String value) {
            addCriterion("public_build_no >=", value, "publicBuildNo");
            return (Criteria) this;
        }

        public Criteria andPublicBuildNoLessThan(String value) {
            addCriterion("public_build_no <", value, "publicBuildNo");
            return (Criteria) this;
        }

        public Criteria andPublicBuildNoLessThanOrEqualTo(String value) {
            addCriterion("public_build_no <=", value, "publicBuildNo");
            return (Criteria) this;
        }

        public Criteria andPublicBuildNoLike(String value) {
            addCriterion("public_build_no like", value, "publicBuildNo");
            return (Criteria) this;
        }

        public Criteria andPublicBuildNoNotLike(String value) {
            addCriterion("public_build_no not like", value, "publicBuildNo");
            return (Criteria) this;
        }

        public Criteria andPublicBuildNoIn(List<String> values) {
            addCriterion("public_build_no in", values, "publicBuildNo");
            return (Criteria) this;
        }

        public Criteria andPublicBuildNoNotIn(List<String> values) {
            addCriterion("public_build_no not in", values, "publicBuildNo");
            return (Criteria) this;
        }

        public Criteria andPublicBuildNoBetween(String value1, String value2) {
            addCriterion("public_build_no between", value1, value2, "publicBuildNo");
            return (Criteria) this;
        }

        public Criteria andPublicBuildNoNotBetween(String value1, String value2) {
            addCriterion("public_build_no not between", value1, value2, "publicBuildNo");
            return (Criteria) this;
        }

        public Criteria andOtherBuildNoIsNull() {
            addCriterion("other_build_no is null");
            return (Criteria) this;
        }

        public Criteria andOtherBuildNoIsNotNull() {
            addCriterion("other_build_no is not null");
            return (Criteria) this;
        }

        public Criteria andOtherBuildNoEqualTo(String value) {
            addCriterion("other_build_no =", value, "otherBuildNo");
            return (Criteria) this;
        }

        public Criteria andOtherBuildNoNotEqualTo(String value) {
            addCriterion("other_build_no <>", value, "otherBuildNo");
            return (Criteria) this;
        }

        public Criteria andOtherBuildNoGreaterThan(String value) {
            addCriterion("other_build_no >", value, "otherBuildNo");
            return (Criteria) this;
        }

        public Criteria andOtherBuildNoGreaterThanOrEqualTo(String value) {
            addCriterion("other_build_no >=", value, "otherBuildNo");
            return (Criteria) this;
        }

        public Criteria andOtherBuildNoLessThan(String value) {
            addCriterion("other_build_no <", value, "otherBuildNo");
            return (Criteria) this;
        }

        public Criteria andOtherBuildNoLessThanOrEqualTo(String value) {
            addCriterion("other_build_no <=", value, "otherBuildNo");
            return (Criteria) this;
        }

        public Criteria andOtherBuildNoLike(String value) {
            addCriterion("other_build_no like", value, "otherBuildNo");
            return (Criteria) this;
        }

        public Criteria andOtherBuildNoNotLike(String value) {
            addCriterion("other_build_no not like", value, "otherBuildNo");
            return (Criteria) this;
        }

        public Criteria andOtherBuildNoIn(List<String> values) {
            addCriterion("other_build_no in", values, "otherBuildNo");
            return (Criteria) this;
        }

        public Criteria andOtherBuildNoNotIn(List<String> values) {
            addCriterion("other_build_no not in", values, "otherBuildNo");
            return (Criteria) this;
        }

        public Criteria andOtherBuildNoBetween(String value1, String value2) {
            addCriterion("other_build_no between", value1, value2, "otherBuildNo");
            return (Criteria) this;
        }

        public Criteria andOtherBuildNoNotBetween(String value1, String value2) {
            addCriterion("other_build_no not between", value1, value2, "otherBuildNo");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildCountIsNull() {
            addCriterion("dwelling_build_count is null");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildCountIsNotNull() {
            addCriterion("dwelling_build_count is not null");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildCountEqualTo(Integer value) {
            addCriterion("dwelling_build_count =", value, "dwellingBuildCount");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildCountNotEqualTo(Integer value) {
            addCriterion("dwelling_build_count <>", value, "dwellingBuildCount");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildCountGreaterThan(Integer value) {
            addCriterion("dwelling_build_count >", value, "dwellingBuildCount");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("dwelling_build_count >=", value, "dwellingBuildCount");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildCountLessThan(Integer value) {
            addCriterion("dwelling_build_count <", value, "dwellingBuildCount");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildCountLessThanOrEqualTo(Integer value) {
            addCriterion("dwelling_build_count <=", value, "dwellingBuildCount");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildCountIn(List<Integer> values) {
            addCriterion("dwelling_build_count in", values, "dwellingBuildCount");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildCountNotIn(List<Integer> values) {
            addCriterion("dwelling_build_count not in", values, "dwellingBuildCount");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildCountBetween(Integer value1, Integer value2) {
            addCriterion("dwelling_build_count between", value1, value2, "dwellingBuildCount");
            return (Criteria) this;
        }

        public Criteria andDwellingBuildCountNotBetween(Integer value1, Integer value2) {
            addCriterion("dwelling_build_count not between", value1, value2, "dwellingBuildCount");
            return (Criteria) this;
        }

        public Criteria andShopBuildCountIsNull() {
            addCriterion("shop_build_count is null");
            return (Criteria) this;
        }

        public Criteria andShopBuildCountIsNotNull() {
            addCriterion("shop_build_count is not null");
            return (Criteria) this;
        }

        public Criteria andShopBuildCountEqualTo(Integer value) {
            addCriterion("shop_build_count =", value, "shopBuildCount");
            return (Criteria) this;
        }

        public Criteria andShopBuildCountNotEqualTo(Integer value) {
            addCriterion("shop_build_count <>", value, "shopBuildCount");
            return (Criteria) this;
        }

        public Criteria andShopBuildCountGreaterThan(Integer value) {
            addCriterion("shop_build_count >", value, "shopBuildCount");
            return (Criteria) this;
        }

        public Criteria andShopBuildCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_build_count >=", value, "shopBuildCount");
            return (Criteria) this;
        }

        public Criteria andShopBuildCountLessThan(Integer value) {
            addCriterion("shop_build_count <", value, "shopBuildCount");
            return (Criteria) this;
        }

        public Criteria andShopBuildCountLessThanOrEqualTo(Integer value) {
            addCriterion("shop_build_count <=", value, "shopBuildCount");
            return (Criteria) this;
        }

        public Criteria andShopBuildCountIn(List<Integer> values) {
            addCriterion("shop_build_count in", values, "shopBuildCount");
            return (Criteria) this;
        }

        public Criteria andShopBuildCountNotIn(List<Integer> values) {
            addCriterion("shop_build_count not in", values, "shopBuildCount");
            return (Criteria) this;
        }

        public Criteria andShopBuildCountBetween(Integer value1, Integer value2) {
            addCriterion("shop_build_count between", value1, value2, "shopBuildCount");
            return (Criteria) this;
        }

        public Criteria andShopBuildCountNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_build_count not between", value1, value2, "shopBuildCount");
            return (Criteria) this;
        }

        public Criteria andPublicBuildCountIsNull() {
            addCriterion("public_build_count is null");
            return (Criteria) this;
        }

        public Criteria andPublicBuildCountIsNotNull() {
            addCriterion("public_build_count is not null");
            return (Criteria) this;
        }

        public Criteria andPublicBuildCountEqualTo(Integer value) {
            addCriterion("public_build_count =", value, "publicBuildCount");
            return (Criteria) this;
        }

        public Criteria andPublicBuildCountNotEqualTo(Integer value) {
            addCriterion("public_build_count <>", value, "publicBuildCount");
            return (Criteria) this;
        }

        public Criteria andPublicBuildCountGreaterThan(Integer value) {
            addCriterion("public_build_count >", value, "publicBuildCount");
            return (Criteria) this;
        }

        public Criteria andPublicBuildCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("public_build_count >=", value, "publicBuildCount");
            return (Criteria) this;
        }

        public Criteria andPublicBuildCountLessThan(Integer value) {
            addCriterion("public_build_count <", value, "publicBuildCount");
            return (Criteria) this;
        }

        public Criteria andPublicBuildCountLessThanOrEqualTo(Integer value) {
            addCriterion("public_build_count <=", value, "publicBuildCount");
            return (Criteria) this;
        }

        public Criteria andPublicBuildCountIn(List<Integer> values) {
            addCriterion("public_build_count in", values, "publicBuildCount");
            return (Criteria) this;
        }

        public Criteria andPublicBuildCountNotIn(List<Integer> values) {
            addCriterion("public_build_count not in", values, "publicBuildCount");
            return (Criteria) this;
        }

        public Criteria andPublicBuildCountBetween(Integer value1, Integer value2) {
            addCriterion("public_build_count between", value1, value2, "publicBuildCount");
            return (Criteria) this;
        }

        public Criteria andPublicBuildCountNotBetween(Integer value1, Integer value2) {
            addCriterion("public_build_count not between", value1, value2, "publicBuildCount");
            return (Criteria) this;
        }

        public Criteria andOtherBuildCountIsNull() {
            addCriterion("other_build_count is null");
            return (Criteria) this;
        }

        public Criteria andOtherBuildCountIsNotNull() {
            addCriterion("other_build_count is not null");
            return (Criteria) this;
        }

        public Criteria andOtherBuildCountEqualTo(Integer value) {
            addCriterion("other_build_count =", value, "otherBuildCount");
            return (Criteria) this;
        }

        public Criteria andOtherBuildCountNotEqualTo(Integer value) {
            addCriterion("other_build_count <>", value, "otherBuildCount");
            return (Criteria) this;
        }

        public Criteria andOtherBuildCountGreaterThan(Integer value) {
            addCriterion("other_build_count >", value, "otherBuildCount");
            return (Criteria) this;
        }

        public Criteria andOtherBuildCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("other_build_count >=", value, "otherBuildCount");
            return (Criteria) this;
        }

        public Criteria andOtherBuildCountLessThan(Integer value) {
            addCriterion("other_build_count <", value, "otherBuildCount");
            return (Criteria) this;
        }

        public Criteria andOtherBuildCountLessThanOrEqualTo(Integer value) {
            addCriterion("other_build_count <=", value, "otherBuildCount");
            return (Criteria) this;
        }

        public Criteria andOtherBuildCountIn(List<Integer> values) {
            addCriterion("other_build_count in", values, "otherBuildCount");
            return (Criteria) this;
        }

        public Criteria andOtherBuildCountNotIn(List<Integer> values) {
            addCriterion("other_build_count not in", values, "otherBuildCount");
            return (Criteria) this;
        }

        public Criteria andOtherBuildCountBetween(Integer value1, Integer value2) {
            addCriterion("other_build_count between", value1, value2, "otherBuildCount");
            return (Criteria) this;
        }

        public Criteria andOtherBuildCountNotBetween(Integer value1, Integer value2) {
            addCriterion("other_build_count not between", value1, value2, "otherBuildCount");
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

        public Criteria andCreateUidIsNull() {
            addCriterion("create_uid is null");
            return (Criteria) this;
        }

        public Criteria andCreateUidIsNotNull() {
            addCriterion("create_uid is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUidEqualTo(Integer value) {
            addCriterion("create_uid =", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidNotEqualTo(Integer value) {
            addCriterion("create_uid <>", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidGreaterThan(Integer value) {
            addCriterion("create_uid >", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_uid >=", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidLessThan(Integer value) {
            addCriterion("create_uid <", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidLessThanOrEqualTo(Integer value) {
            addCriterion("create_uid <=", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidIn(List<Integer> values) {
            addCriterion("create_uid in", values, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidNotIn(List<Integer> values) {
            addCriterion("create_uid not in", values, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidBetween(Integer value1, Integer value2) {
            addCriterion("create_uid between", value1, value2, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidNotBetween(Integer value1, Integer value2) {
            addCriterion("create_uid not between", value1, value2, "createUid");
            return (Criteria) this;
        }

        public Criteria andUpdateUidIsNull() {
            addCriterion("update_uid is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUidIsNotNull() {
            addCriterion("update_uid is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUidEqualTo(Integer value) {
            addCriterion("update_uid =", value, "updateUid");
            return (Criteria) this;
        }

        public Criteria andUpdateUidNotEqualTo(Integer value) {
            addCriterion("update_uid <>", value, "updateUid");
            return (Criteria) this;
        }

        public Criteria andUpdateUidGreaterThan(Integer value) {
            addCriterion("update_uid >", value, "updateUid");
            return (Criteria) this;
        }

        public Criteria andUpdateUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_uid >=", value, "updateUid");
            return (Criteria) this;
        }

        public Criteria andUpdateUidLessThan(Integer value) {
            addCriterion("update_uid <", value, "updateUid");
            return (Criteria) this;
        }

        public Criteria andUpdateUidLessThanOrEqualTo(Integer value) {
            addCriterion("update_uid <=", value, "updateUid");
            return (Criteria) this;
        }

        public Criteria andUpdateUidIn(List<Integer> values) {
            addCriterion("update_uid in", values, "updateUid");
            return (Criteria) this;
        }

        public Criteria andUpdateUidNotIn(List<Integer> values) {
            addCriterion("update_uid not in", values, "updateUid");
            return (Criteria) this;
        }

        public Criteria andUpdateUidBetween(Integer value1, Integer value2) {
            addCriterion("update_uid between", value1, value2, "updateUid");
            return (Criteria) this;
        }

        public Criteria andUpdateUidNotBetween(Integer value1, Integer value2) {
            addCriterion("update_uid not between", value1, value2, "updateUid");
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
     * tb_syfc_sales_no
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * tb_syfc_sales_no 2019-02-28
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