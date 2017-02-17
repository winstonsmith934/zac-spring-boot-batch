package com.example.dao;

import com.example.entity.TransactionStaff;
import com.example.entity.TransactionStaffExample.Criteria;
import com.example.entity.TransactionStaffExample.Criterion;
import com.example.entity.TransactionStaffExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TransactionStaffSqlProvider {

    public String countByExample(TransactionStaffExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_staff");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TransactionStaffExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_staff");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(TransactionStaff record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_staff");
        
        if (record.getStaffId() != null) {
            sql.VALUES("staff_id", "#{staffId,jdbcType=INTEGER}");
        }
        
        if (record.getStaffCode() != null) {
            sql.VALUES("staff_code", "#{staffCode,jdbcType=VARCHAR}");
        }
        
        if (record.getStaffName() != null) {
            sql.VALUES("staff_name", "#{staffName,jdbcType=VARCHAR}");
        }
        
        if (record.getStaffNameKana() != null) {
            sql.VALUES("staff_name_kana", "#{staffNameKana,jdbcType=VARCHAR}");
        }
        
        if (record.getStaffDivisionId() != null) {
            sql.VALUES("staff_division_id", "#{staffDivisionId,jdbcType=INTEGER}");
        }
        
        if (record.getStaffMailaddress() != null) {
            sql.VALUES("staff_mailaddress", "#{staffMailaddress,jdbcType=VARCHAR}");
        }
        
        if (record.getStaffStatus() != null) {
            sql.VALUES("staff_status", "#{staffStatus,jdbcType=TINYINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(TransactionStaffExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("staff_id");
        } else {
            sql.SELECT("staff_id");
        }
        sql.SELECT("staff_code");
        sql.SELECT("staff_name");
        sql.SELECT("staff_name_kana");
        sql.SELECT("staff_division_id");
        sql.SELECT("staff_mailaddress");
        sql.SELECT("staff_status");
        sql.FROM("t_staff");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TransactionStaff record = (TransactionStaff) parameter.get("record");
        TransactionStaffExample example = (TransactionStaffExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_staff");
        
        if (record.getStaffId() != null) {
            sql.SET("staff_id = #{record.staffId,jdbcType=INTEGER}");
        }
        
        if (record.getStaffCode() != null) {
            sql.SET("staff_code = #{record.staffCode,jdbcType=VARCHAR}");
        }
        
        if (record.getStaffName() != null) {
            sql.SET("staff_name = #{record.staffName,jdbcType=VARCHAR}");
        }
        
        if (record.getStaffNameKana() != null) {
            sql.SET("staff_name_kana = #{record.staffNameKana,jdbcType=VARCHAR}");
        }
        
        if (record.getStaffDivisionId() != null) {
            sql.SET("staff_division_id = #{record.staffDivisionId,jdbcType=INTEGER}");
        }
        
        if (record.getStaffMailaddress() != null) {
            sql.SET("staff_mailaddress = #{record.staffMailaddress,jdbcType=VARCHAR}");
        }
        
        if (record.getStaffStatus() != null) {
            sql.SET("staff_status = #{record.staffStatus,jdbcType=TINYINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_staff");
        
        sql.SET("staff_id = #{record.staffId,jdbcType=INTEGER}");
        sql.SET("staff_code = #{record.staffCode,jdbcType=VARCHAR}");
        sql.SET("staff_name = #{record.staffName,jdbcType=VARCHAR}");
        sql.SET("staff_name_kana = #{record.staffNameKana,jdbcType=VARCHAR}");
        sql.SET("staff_division_id = #{record.staffDivisionId,jdbcType=INTEGER}");
        sql.SET("staff_mailaddress = #{record.staffMailaddress,jdbcType=VARCHAR}");
        sql.SET("staff_status = #{record.staffStatus,jdbcType=TINYINT}");
        
        TransactionStaffExample example = (TransactionStaffExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TransactionStaff record) {
        SQL sql = new SQL();
        sql.UPDATE("t_staff");
        
        if (record.getStaffCode() != null) {
            sql.SET("staff_code = #{staffCode,jdbcType=VARCHAR}");
        }
        
        if (record.getStaffName() != null) {
            sql.SET("staff_name = #{staffName,jdbcType=VARCHAR}");
        }
        
        if (record.getStaffNameKana() != null) {
            sql.SET("staff_name_kana = #{staffNameKana,jdbcType=VARCHAR}");
        }
        
        if (record.getStaffDivisionId() != null) {
            sql.SET("staff_division_id = #{staffDivisionId,jdbcType=INTEGER}");
        }
        
        if (record.getStaffMailaddress() != null) {
            sql.SET("staff_mailaddress = #{staffMailaddress,jdbcType=VARCHAR}");
        }
        
        if (record.getStaffStatus() != null) {
            sql.SET("staff_status = #{staffStatus,jdbcType=TINYINT}");
        }
        
        sql.WHERE("staff_id = #{staffId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, TransactionStaffExample example, boolean includeExamplePhrase) {
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