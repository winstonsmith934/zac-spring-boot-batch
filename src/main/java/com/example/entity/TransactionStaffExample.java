package com.example.entity;

import java.util.ArrayList;
import java.util.List;

public class TransactionStaffExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransactionStaffExample() {
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

        public Criteria andStaffIdIsNull() {
            addCriterion("staff_id is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdEqualTo(Integer value) {
            addCriterion("staff_id =", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotEqualTo(Integer value) {
            addCriterion("staff_id <>", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThan(Integer value) {
            addCriterion("staff_id >", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("staff_id >=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThan(Integer value) {
            addCriterion("staff_id <", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(Integer value) {
            addCriterion("staff_id <=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIn(List<Integer> values) {
            addCriterion("staff_id in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotIn(List<Integer> values) {
            addCriterion("staff_id not in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdBetween(Integer value1, Integer value2) {
            addCriterion("staff_id between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotBetween(Integer value1, Integer value2) {
            addCriterion("staff_id not between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffCodeIsNull() {
            addCriterion("staff_code is null");
            return (Criteria) this;
        }

        public Criteria andStaffCodeIsNotNull() {
            addCriterion("staff_code is not null");
            return (Criteria) this;
        }

        public Criteria andStaffCodeEqualTo(String value) {
            addCriterion("staff_code =", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeNotEqualTo(String value) {
            addCriterion("staff_code <>", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeGreaterThan(String value) {
            addCriterion("staff_code >", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeGreaterThanOrEqualTo(String value) {
            addCriterion("staff_code >=", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeLessThan(String value) {
            addCriterion("staff_code <", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeLessThanOrEqualTo(String value) {
            addCriterion("staff_code <=", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeLike(String value) {
            addCriterion("staff_code like", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeNotLike(String value) {
            addCriterion("staff_code not like", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeIn(List<String> values) {
            addCriterion("staff_code in", values, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeNotIn(List<String> values) {
            addCriterion("staff_code not in", values, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeBetween(String value1, String value2) {
            addCriterion("staff_code between", value1, value2, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeNotBetween(String value1, String value2) {
            addCriterion("staff_code not between", value1, value2, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNull() {
            addCriterion("staff_name is null");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNotNull() {
            addCriterion("staff_name is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNameEqualTo(String value) {
            addCriterion("staff_name =", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotEqualTo(String value) {
            addCriterion("staff_name <>", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThan(String value) {
            addCriterion("staff_name >", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("staff_name >=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThan(String value) {
            addCriterion("staff_name <", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThanOrEqualTo(String value) {
            addCriterion("staff_name <=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLike(String value) {
            addCriterion("staff_name like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotLike(String value) {
            addCriterion("staff_name not like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameIn(List<String> values) {
            addCriterion("staff_name in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotIn(List<String> values) {
            addCriterion("staff_name not in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameBetween(String value1, String value2) {
            addCriterion("staff_name between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotBetween(String value1, String value2) {
            addCriterion("staff_name not between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameKanaIsNull() {
            addCriterion("staff_name_kana is null");
            return (Criteria) this;
        }

        public Criteria andStaffNameKanaIsNotNull() {
            addCriterion("staff_name_kana is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNameKanaEqualTo(String value) {
            addCriterion("staff_name_kana =", value, "staffNameKana");
            return (Criteria) this;
        }

        public Criteria andStaffNameKanaNotEqualTo(String value) {
            addCriterion("staff_name_kana <>", value, "staffNameKana");
            return (Criteria) this;
        }

        public Criteria andStaffNameKanaGreaterThan(String value) {
            addCriterion("staff_name_kana >", value, "staffNameKana");
            return (Criteria) this;
        }

        public Criteria andStaffNameKanaGreaterThanOrEqualTo(String value) {
            addCriterion("staff_name_kana >=", value, "staffNameKana");
            return (Criteria) this;
        }

        public Criteria andStaffNameKanaLessThan(String value) {
            addCriterion("staff_name_kana <", value, "staffNameKana");
            return (Criteria) this;
        }

        public Criteria andStaffNameKanaLessThanOrEqualTo(String value) {
            addCriterion("staff_name_kana <=", value, "staffNameKana");
            return (Criteria) this;
        }

        public Criteria andStaffNameKanaLike(String value) {
            addCriterion("staff_name_kana like", value, "staffNameKana");
            return (Criteria) this;
        }

        public Criteria andStaffNameKanaNotLike(String value) {
            addCriterion("staff_name_kana not like", value, "staffNameKana");
            return (Criteria) this;
        }

        public Criteria andStaffNameKanaIn(List<String> values) {
            addCriterion("staff_name_kana in", values, "staffNameKana");
            return (Criteria) this;
        }

        public Criteria andStaffNameKanaNotIn(List<String> values) {
            addCriterion("staff_name_kana not in", values, "staffNameKana");
            return (Criteria) this;
        }

        public Criteria andStaffNameKanaBetween(String value1, String value2) {
            addCriterion("staff_name_kana between", value1, value2, "staffNameKana");
            return (Criteria) this;
        }

        public Criteria andStaffNameKanaNotBetween(String value1, String value2) {
            addCriterion("staff_name_kana not between", value1, value2, "staffNameKana");
            return (Criteria) this;
        }

        public Criteria andStaffDivisionIdIsNull() {
            addCriterion("staff_division_id is null");
            return (Criteria) this;
        }

        public Criteria andStaffDivisionIdIsNotNull() {
            addCriterion("staff_division_id is not null");
            return (Criteria) this;
        }

        public Criteria andStaffDivisionIdEqualTo(Integer value) {
            addCriterion("staff_division_id =", value, "staffDivisionId");
            return (Criteria) this;
        }

        public Criteria andStaffDivisionIdNotEqualTo(Integer value) {
            addCriterion("staff_division_id <>", value, "staffDivisionId");
            return (Criteria) this;
        }

        public Criteria andStaffDivisionIdGreaterThan(Integer value) {
            addCriterion("staff_division_id >", value, "staffDivisionId");
            return (Criteria) this;
        }

        public Criteria andStaffDivisionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("staff_division_id >=", value, "staffDivisionId");
            return (Criteria) this;
        }

        public Criteria andStaffDivisionIdLessThan(Integer value) {
            addCriterion("staff_division_id <", value, "staffDivisionId");
            return (Criteria) this;
        }

        public Criteria andStaffDivisionIdLessThanOrEqualTo(Integer value) {
            addCriterion("staff_division_id <=", value, "staffDivisionId");
            return (Criteria) this;
        }

        public Criteria andStaffDivisionIdIn(List<Integer> values) {
            addCriterion("staff_division_id in", values, "staffDivisionId");
            return (Criteria) this;
        }

        public Criteria andStaffDivisionIdNotIn(List<Integer> values) {
            addCriterion("staff_division_id not in", values, "staffDivisionId");
            return (Criteria) this;
        }

        public Criteria andStaffDivisionIdBetween(Integer value1, Integer value2) {
            addCriterion("staff_division_id between", value1, value2, "staffDivisionId");
            return (Criteria) this;
        }

        public Criteria andStaffDivisionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("staff_division_id not between", value1, value2, "staffDivisionId");
            return (Criteria) this;
        }

        public Criteria andStaffMailaddressIsNull() {
            addCriterion("staff_mailaddress is null");
            return (Criteria) this;
        }

        public Criteria andStaffMailaddressIsNotNull() {
            addCriterion("staff_mailaddress is not null");
            return (Criteria) this;
        }

        public Criteria andStaffMailaddressEqualTo(String value) {
            addCriterion("staff_mailaddress =", value, "staffMailaddress");
            return (Criteria) this;
        }

        public Criteria andStaffMailaddressNotEqualTo(String value) {
            addCriterion("staff_mailaddress <>", value, "staffMailaddress");
            return (Criteria) this;
        }

        public Criteria andStaffMailaddressGreaterThan(String value) {
            addCriterion("staff_mailaddress >", value, "staffMailaddress");
            return (Criteria) this;
        }

        public Criteria andStaffMailaddressGreaterThanOrEqualTo(String value) {
            addCriterion("staff_mailaddress >=", value, "staffMailaddress");
            return (Criteria) this;
        }

        public Criteria andStaffMailaddressLessThan(String value) {
            addCriterion("staff_mailaddress <", value, "staffMailaddress");
            return (Criteria) this;
        }

        public Criteria andStaffMailaddressLessThanOrEqualTo(String value) {
            addCriterion("staff_mailaddress <=", value, "staffMailaddress");
            return (Criteria) this;
        }

        public Criteria andStaffMailaddressLike(String value) {
            addCriterion("staff_mailaddress like", value, "staffMailaddress");
            return (Criteria) this;
        }

        public Criteria andStaffMailaddressNotLike(String value) {
            addCriterion("staff_mailaddress not like", value, "staffMailaddress");
            return (Criteria) this;
        }

        public Criteria andStaffMailaddressIn(List<String> values) {
            addCriterion("staff_mailaddress in", values, "staffMailaddress");
            return (Criteria) this;
        }

        public Criteria andStaffMailaddressNotIn(List<String> values) {
            addCriterion("staff_mailaddress not in", values, "staffMailaddress");
            return (Criteria) this;
        }

        public Criteria andStaffMailaddressBetween(String value1, String value2) {
            addCriterion("staff_mailaddress between", value1, value2, "staffMailaddress");
            return (Criteria) this;
        }

        public Criteria andStaffMailaddressNotBetween(String value1, String value2) {
            addCriterion("staff_mailaddress not between", value1, value2, "staffMailaddress");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIsNull() {
            addCriterion("staff_status is null");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIsNotNull() {
            addCriterion("staff_status is not null");
            return (Criteria) this;
        }

        public Criteria andStaffStatusEqualTo(Byte value) {
            addCriterion("staff_status =", value, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNotEqualTo(Byte value) {
            addCriterion("staff_status <>", value, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusGreaterThan(Byte value) {
            addCriterion("staff_status >", value, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("staff_status >=", value, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusLessThan(Byte value) {
            addCriterion("staff_status <", value, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusLessThanOrEqualTo(Byte value) {
            addCriterion("staff_status <=", value, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIn(List<Byte> values) {
            addCriterion("staff_status in", values, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNotIn(List<Byte> values) {
            addCriterion("staff_status not in", values, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusBetween(Byte value1, Byte value2) {
            addCriterion("staff_status between", value1, value2, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("staff_status not between", value1, value2, "staffStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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