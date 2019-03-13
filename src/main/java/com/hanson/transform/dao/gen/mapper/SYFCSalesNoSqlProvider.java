package com.hanson.transform.dao.gen.mapper;

import com.hanson.transform.dao.gen.entity.SYFCSalesNo;
import com.hanson.transform.dao.gen.entity.SYFCSalesNoExample.Criteria;
import com.hanson.transform.dao.gen.entity.SYFCSalesNoExample.Criterion;
import com.hanson.transform.dao.gen.entity.SYFCSalesNoExample;
import java.util.List;
import org.apache.ibatis.jdbc.SQL;

public class SYFCSalesNoSqlProvider {

    public String insertSelective(SYFCSalesNo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("tb_syfc_sales_no");
        
        if (record.getThirdNo() != null) {
            sql.VALUES("third_no", "#{thirdNo,jdbcType=INTEGER}");
        }
        
        if (record.getThirdRecordId() != null) {
            sql.VALUES("third_record_id", "#{thirdRecordId,jdbcType=VARCHAR}");
        }
        
        if (record.getSalesNo() != null) {
            sql.VALUES("sales_no", "#{salesNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCompany() != null) {
            sql.VALUES("company", "#{company,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyFriendly() != null) {
            sql.VALUES("company_friendly", "#{companyFriendly,jdbcType=VARCHAR}");
        }
        
        if (record.getProgramName() != null) {
            sql.VALUES("program_name", "#{programName,jdbcType=VARCHAR}");
        }
        
        if (record.getProgramLocaltion() != null) {
            sql.VALUES("program_localtion", "#{programLocaltion,jdbcType=VARCHAR}");
        }
        
        if (record.getProgramLocaltionFriendly() != null) {
            sql.VALUES("program_localtion_friendly", "#{programLocaltionFriendly,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildCount() != null) {
            sql.VALUES("build_count", "#{buildCount,jdbcType=INTEGER}");
        }
        
        if (record.getTotalBuildArea() != null) {
            sql.VALUES("total_build_area", "#{totalBuildArea,jdbcType=REAL}");
        }
        
        if (record.getSalesArea() != null) {
            sql.VALUES("sales_area", "#{salesArea,jdbcType=REAL}");
        }
        
        if (record.getDwellingArea() != null) {
            sql.VALUES("dwelling_area", "#{dwellingArea,jdbcType=REAL}");
        }
        
        if (record.getShopArea() != null) {
            sql.VALUES("shop_area", "#{shopArea,jdbcType=REAL}");
        }
        
        if (record.getPublicArea() != null) {
            sql.VALUES("public_area", "#{publicArea,jdbcType=REAL}");
        }
        
        if (record.getOtherArea() != null) {
            sql.VALUES("other_area", "#{otherArea,jdbcType=REAL}");
        }
        
        if (record.getApproveDate() != null) {
            sql.VALUES("approve_date", "#{approveDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDwellingBuildNo() != null) {
            sql.VALUES("dwelling_build_no", "#{dwellingBuildNo,jdbcType=VARCHAR}");
        }
        
        if (record.getShopBuildNo() != null) {
            sql.VALUES("shop_build_no", "#{shopBuildNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPublicBuildNo() != null) {
            sql.VALUES("public_build_no", "#{publicBuildNo,jdbcType=VARCHAR}");
        }
        
        if (record.getOtherBuildNo() != null) {
            sql.VALUES("other_build_no", "#{otherBuildNo,jdbcType=VARCHAR}");
        }
        
        if (record.getDwellingBuildCount() != null) {
            sql.VALUES("dwelling_build_count", "#{dwellingBuildCount,jdbcType=INTEGER}");
        }
        
        if (record.getShopBuildCount() != null) {
            sql.VALUES("shop_build_count", "#{shopBuildCount,jdbcType=INTEGER}");
        }
        
        if (record.getPublicBuildCount() != null) {
            sql.VALUES("public_build_count", "#{publicBuildCount,jdbcType=INTEGER}");
        }
        
        if (record.getOtherBuildCount() != null) {
            sql.VALUES("other_build_count", "#{otherBuildCount,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getDataStatus() != null) {
            sql.VALUES("data_status", "#{dataStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateUid() != null) {
            sql.VALUES("create_uid", "#{createUid,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateUid() != null) {
            sql.VALUES("update_uid", "#{updateUid,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SYFCSalesNoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("third_no");
        sql.SELECT("third_record_id");
        sql.SELECT("sales_no");
        sql.SELECT("company");
        sql.SELECT("company_friendly");
        sql.SELECT("program_name");
        sql.SELECT("program_localtion");
        sql.SELECT("program_localtion_friendly");
        sql.SELECT("build_count");
        sql.SELECT("total_build_area");
        sql.SELECT("sales_area");
        sql.SELECT("dwelling_area");
        sql.SELECT("shop_area");
        sql.SELECT("public_area");
        sql.SELECT("other_area");
        sql.SELECT("approve_date");
        sql.SELECT("dwelling_build_no");
        sql.SELECT("shop_build_no");
        sql.SELECT("public_build_no");
        sql.SELECT("other_build_no");
        sql.SELECT("dwelling_build_count");
        sql.SELECT("shop_build_count");
        sql.SELECT("public_build_count");
        sql.SELECT("other_build_count");
        sql.SELECT("remark");
        sql.SELECT("data_status");
        sql.SELECT("create_uid");
        sql.SELECT("update_uid");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("tb_syfc_sales_no");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SYFCSalesNo record) {
        SQL sql = new SQL();
        sql.UPDATE("tb_syfc_sales_no");
        
        if (record.getThirdNo() != null) {
            sql.SET("third_no = #{thirdNo,jdbcType=INTEGER}");
        }
        
        if (record.getThirdRecordId() != null) {
            sql.SET("third_record_id = #{thirdRecordId,jdbcType=VARCHAR}");
        }
        
        if (record.getSalesNo() != null) {
            sql.SET("sales_no = #{salesNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCompany() != null) {
            sql.SET("company = #{company,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyFriendly() != null) {
            sql.SET("company_friendly = #{companyFriendly,jdbcType=VARCHAR}");
        }
        
        if (record.getProgramName() != null) {
            sql.SET("program_name = #{programName,jdbcType=VARCHAR}");
        }
        
        if (record.getProgramLocaltion() != null) {
            sql.SET("program_localtion = #{programLocaltion,jdbcType=VARCHAR}");
        }
        
        if (record.getProgramLocaltionFriendly() != null) {
            sql.SET("program_localtion_friendly = #{programLocaltionFriendly,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildCount() != null) {
            sql.SET("build_count = #{buildCount,jdbcType=INTEGER}");
        }
        
        if (record.getTotalBuildArea() != null) {
            sql.SET("total_build_area = #{totalBuildArea,jdbcType=REAL}");
        }
        
        if (record.getSalesArea() != null) {
            sql.SET("sales_area = #{salesArea,jdbcType=REAL}");
        }
        
        if (record.getDwellingArea() != null) {
            sql.SET("dwelling_area = #{dwellingArea,jdbcType=REAL}");
        }
        
        if (record.getShopArea() != null) {
            sql.SET("shop_area = #{shopArea,jdbcType=REAL}");
        }
        
        if (record.getPublicArea() != null) {
            sql.SET("public_area = #{publicArea,jdbcType=REAL}");
        }
        
        if (record.getOtherArea() != null) {
            sql.SET("other_area = #{otherArea,jdbcType=REAL}");
        }
        
        if (record.getApproveDate() != null) {
            sql.SET("approve_date = #{approveDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDwellingBuildNo() != null) {
            sql.SET("dwelling_build_no = #{dwellingBuildNo,jdbcType=VARCHAR}");
        }
        
        if (record.getShopBuildNo() != null) {
            sql.SET("shop_build_no = #{shopBuildNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPublicBuildNo() != null) {
            sql.SET("public_build_no = #{publicBuildNo,jdbcType=VARCHAR}");
        }
        
        if (record.getOtherBuildNo() != null) {
            sql.SET("other_build_no = #{otherBuildNo,jdbcType=VARCHAR}");
        }
        
        if (record.getDwellingBuildCount() != null) {
            sql.SET("dwelling_build_count = #{dwellingBuildCount,jdbcType=INTEGER}");
        }
        
        if (record.getShopBuildCount() != null) {
            sql.SET("shop_build_count = #{shopBuildCount,jdbcType=INTEGER}");
        }
        
        if (record.getPublicBuildCount() != null) {
            sql.SET("public_build_count = #{publicBuildCount,jdbcType=INTEGER}");
        }
        
        if (record.getOtherBuildCount() != null) {
            sql.SET("other_build_count = #{otherBuildCount,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getDataStatus() != null) {
            sql.SET("data_status = #{dataStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateUid() != null) {
            sql.SET("create_uid = #{createUid,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateUid() != null) {
            sql.SET("update_uid = #{updateUid,jdbcType=INTEGER}");
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

    protected void applyWhere(SQL sql, SYFCSalesNoExample example, boolean includeExamplePhrase) {
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