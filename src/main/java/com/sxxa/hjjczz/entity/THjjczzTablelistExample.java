package com.sxxa.hjjczz.entity;

import java.util.ArrayList;
import java.util.List;

public class THjjczzTablelistExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_hjjczz_tablelist
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_hjjczz_tablelist
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_hjjczz_tablelist
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_tablelist
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    public THjjczzTablelistExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_tablelist
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_tablelist
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_tablelist
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_tablelist
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_tablelist
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_tablelist
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_tablelist
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_tablelist
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_tablelist
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_tablelist
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_hjjczz_tablelist
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
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

        public Criteria andXhIsNull() {
            addCriterion("XH is null");
            return (Criteria) this;
        }

        public Criteria andXhIsNotNull() {
            addCriterion("XH is not null");
            return (Criteria) this;
        }

        public Criteria andXhEqualTo(Integer value) {
            addCriterion("XH =", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotEqualTo(Integer value) {
            addCriterion("XH <>", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhGreaterThan(Integer value) {
            addCriterion("XH >", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhGreaterThanOrEqualTo(Integer value) {
            addCriterion("XH >=", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLessThan(Integer value) {
            addCriterion("XH <", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLessThanOrEqualTo(Integer value) {
            addCriterion("XH <=", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhIn(List<Integer> values) {
            addCriterion("XH in", values, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotIn(List<Integer> values) {
            addCriterion("XH not in", values, "xh");
            return (Criteria) this;
        }

        public Criteria andXhBetween(Integer value1, Integer value2) {
            addCriterion("XH between", value1, value2, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotBetween(Integer value1, Integer value2) {
            addCriterion("XH not between", value1, value2, "xh");
            return (Criteria) this;
        }

        public Criteria andTablenameEnIsNull() {
            addCriterion("TABLENAME_EN is null");
            return (Criteria) this;
        }

        public Criteria andTablenameEnIsNotNull() {
            addCriterion("TABLENAME_EN is not null");
            return (Criteria) this;
        }

        public Criteria andTablenameEnEqualTo(String value) {
            addCriterion("TABLENAME_EN =", value, "tablenameEn");
            return (Criteria) this;
        }

        public Criteria andTablenameEnNotEqualTo(String value) {
            addCriterion("TABLENAME_EN <>", value, "tablenameEn");
            return (Criteria) this;
        }

        public Criteria andTablenameEnGreaterThan(String value) {
            addCriterion("TABLENAME_EN >", value, "tablenameEn");
            return (Criteria) this;
        }

        public Criteria andTablenameEnGreaterThanOrEqualTo(String value) {
            addCriterion("TABLENAME_EN >=", value, "tablenameEn");
            return (Criteria) this;
        }

        public Criteria andTablenameEnLessThan(String value) {
            addCriterion("TABLENAME_EN <", value, "tablenameEn");
            return (Criteria) this;
        }

        public Criteria andTablenameEnLessThanOrEqualTo(String value) {
            addCriterion("TABLENAME_EN <=", value, "tablenameEn");
            return (Criteria) this;
        }

        public Criteria andTablenameEnLike(String value) {
            addCriterion("TABLENAME_EN like", value, "tablenameEn");
            return (Criteria) this;
        }

        public Criteria andTablenameEnNotLike(String value) {
            addCriterion("TABLENAME_EN not like", value, "tablenameEn");
            return (Criteria) this;
        }

        public Criteria andTablenameEnIn(List<String> values) {
            addCriterion("TABLENAME_EN in", values, "tablenameEn");
            return (Criteria) this;
        }

        public Criteria andTablenameEnNotIn(List<String> values) {
            addCriterion("TABLENAME_EN not in", values, "tablenameEn");
            return (Criteria) this;
        }

        public Criteria andTablenameEnBetween(String value1, String value2) {
            addCriterion("TABLENAME_EN between", value1, value2, "tablenameEn");
            return (Criteria) this;
        }

        public Criteria andTablenameEnNotBetween(String value1, String value2) {
            addCriterion("TABLENAME_EN not between", value1, value2, "tablenameEn");
            return (Criteria) this;
        }

        public Criteria andTablenameCnIsNull() {
            addCriterion("TABLENAME_CN is null");
            return (Criteria) this;
        }

        public Criteria andTablenameCnIsNotNull() {
            addCriterion("TABLENAME_CN is not null");
            return (Criteria) this;
        }

        public Criteria andTablenameCnEqualTo(String value) {
            addCriterion("TABLENAME_CN =", value, "tablenameCn");
            return (Criteria) this;
        }

        public Criteria andTablenameCnNotEqualTo(String value) {
            addCriterion("TABLENAME_CN <>", value, "tablenameCn");
            return (Criteria) this;
        }

        public Criteria andTablenameCnGreaterThan(String value) {
            addCriterion("TABLENAME_CN >", value, "tablenameCn");
            return (Criteria) this;
        }

        public Criteria andTablenameCnGreaterThanOrEqualTo(String value) {
            addCriterion("TABLENAME_CN >=", value, "tablenameCn");
            return (Criteria) this;
        }

        public Criteria andTablenameCnLessThan(String value) {
            addCriterion("TABLENAME_CN <", value, "tablenameCn");
            return (Criteria) this;
        }

        public Criteria andTablenameCnLessThanOrEqualTo(String value) {
            addCriterion("TABLENAME_CN <=", value, "tablenameCn");
            return (Criteria) this;
        }

        public Criteria andTablenameCnLike(String value) {
            addCriterion("TABLENAME_CN like", value, "tablenameCn");
            return (Criteria) this;
        }

        public Criteria andTablenameCnNotLike(String value) {
            addCriterion("TABLENAME_CN not like", value, "tablenameCn");
            return (Criteria) this;
        }

        public Criteria andTablenameCnIn(List<String> values) {
            addCriterion("TABLENAME_CN in", values, "tablenameCn");
            return (Criteria) this;
        }

        public Criteria andTablenameCnNotIn(List<String> values) {
            addCriterion("TABLENAME_CN not in", values, "tablenameCn");
            return (Criteria) this;
        }

        public Criteria andTablenameCnBetween(String value1, String value2) {
            addCriterion("TABLENAME_CN between", value1, value2, "tablenameCn");
            return (Criteria) this;
        }

        public Criteria andTablenameCnNotBetween(String value1, String value2) {
            addCriterion("TABLENAME_CN not between", value1, value2, "tablenameCn");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_hjjczz_tablelist
     *
     * @mbggenerated do_not_delete_during_merge Thu Mar 04 17:03:32 CST 2021
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_hjjczz_tablelist
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
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