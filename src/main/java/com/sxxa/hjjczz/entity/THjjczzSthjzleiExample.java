package com.sxxa.hjjczz.entity;

import java.util.ArrayList;
import java.util.List;

public class THjjczzSthjzleiExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_hjjczz_sthjzlei
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_hjjczz_sthjzlei
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_hjjczz_sthjzlei
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_sthjzlei
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    public THjjczzSthjzleiExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_sthjzlei
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_sthjzlei
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_sthjzlei
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_sthjzlei
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_sthjzlei
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_sthjzlei
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_sthjzlei
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
     * This method corresponds to the database table t_hjjczz_sthjzlei
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
     * This method corresponds to the database table t_hjjczz_sthjzlei
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_sthjzlei
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
     * This class corresponds to the database table t_hjjczz_sthjzlei
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

        public Criteria andXzqmcIsNull() {
            addCriterion("XZQMC is null");
            return (Criteria) this;
        }

        public Criteria andXzqmcIsNotNull() {
            addCriterion("XZQMC is not null");
            return (Criteria) this;
        }

        public Criteria andXzqmcEqualTo(String value) {
            addCriterion("XZQMC =", value, "xzqmc");
            return (Criteria) this;
        }

        public Criteria andXzqmcNotEqualTo(String value) {
            addCriterion("XZQMC <>", value, "xzqmc");
            return (Criteria) this;
        }

        public Criteria andXzqmcGreaterThan(String value) {
            addCriterion("XZQMC >", value, "xzqmc");
            return (Criteria) this;
        }

        public Criteria andXzqmcGreaterThanOrEqualTo(String value) {
            addCriterion("XZQMC >=", value, "xzqmc");
            return (Criteria) this;
        }

        public Criteria andXzqmcLessThan(String value) {
            addCriterion("XZQMC <", value, "xzqmc");
            return (Criteria) this;
        }

        public Criteria andXzqmcLessThanOrEqualTo(String value) {
            addCriterion("XZQMC <=", value, "xzqmc");
            return (Criteria) this;
        }

        public Criteria andXzqmcLike(String value) {
            addCriterion("XZQMC like", value, "xzqmc");
            return (Criteria) this;
        }

        public Criteria andXzqmcNotLike(String value) {
            addCriterion("XZQMC not like", value, "xzqmc");
            return (Criteria) this;
        }

        public Criteria andXzqmcIn(List<String> values) {
            addCriterion("XZQMC in", values, "xzqmc");
            return (Criteria) this;
        }

        public Criteria andXzqmcNotIn(List<String> values) {
            addCriterion("XZQMC not in", values, "xzqmc");
            return (Criteria) this;
        }

        public Criteria andXzqmcBetween(String value1, String value2) {
            addCriterion("XZQMC between", value1, value2, "xzqmc");
            return (Criteria) this;
        }

        public Criteria andXzqmcNotBetween(String value1, String value2) {
            addCriterion("XZQMC not between", value1, value2, "xzqmc");
            return (Criteria) this;
        }

        public Criteria andXzqdmIsNull() {
            addCriterion("XZQDM is null");
            return (Criteria) this;
        }

        public Criteria andXzqdmIsNotNull() {
            addCriterion("XZQDM is not null");
            return (Criteria) this;
        }

        public Criteria andXzqdmEqualTo(String value) {
            addCriterion("XZQDM =", value, "xzqdm");
            return (Criteria) this;
        }

        public Criteria andXzqdmNotEqualTo(String value) {
            addCriterion("XZQDM <>", value, "xzqdm");
            return (Criteria) this;
        }

        public Criteria andXzqdmGreaterThan(String value) {
            addCriterion("XZQDM >", value, "xzqdm");
            return (Criteria) this;
        }

        public Criteria andXzqdmGreaterThanOrEqualTo(String value) {
            addCriterion("XZQDM >=", value, "xzqdm");
            return (Criteria) this;
        }

        public Criteria andXzqdmLessThan(String value) {
            addCriterion("XZQDM <", value, "xzqdm");
            return (Criteria) this;
        }

        public Criteria andXzqdmLessThanOrEqualTo(String value) {
            addCriterion("XZQDM <=", value, "xzqdm");
            return (Criteria) this;
        }

        public Criteria andXzqdmLike(String value) {
            addCriterion("XZQDM like", value, "xzqdm");
            return (Criteria) this;
        }

        public Criteria andXzqdmNotLike(String value) {
            addCriterion("XZQDM not like", value, "xzqdm");
            return (Criteria) this;
        }

        public Criteria andXzqdmIn(List<String> values) {
            addCriterion("XZQDM in", values, "xzqdm");
            return (Criteria) this;
        }

        public Criteria andXzqdmNotIn(List<String> values) {
            addCriterion("XZQDM not in", values, "xzqdm");
            return (Criteria) this;
        }

        public Criteria andXzqdmBetween(String value1, String value2) {
            addCriterion("XZQDM between", value1, value2, "xzqdm");
            return (Criteria) this;
        }

        public Criteria andXzqdmNotBetween(String value1, String value2) {
            addCriterion("XZQDM not between", value1, value2, "xzqdm");
            return (Criteria) this;
        }

        public Criteria andSwfdzsIsNull() {
            addCriterion("SWFDZS is null");
            return (Criteria) this;
        }

        public Criteria andSwfdzsIsNotNull() {
            addCriterion("SWFDZS is not null");
            return (Criteria) this;
        }

        public Criteria andSwfdzsEqualTo(Double value) {
            addCriterion("SWFDZS =", value, "swfdzs");
            return (Criteria) this;
        }

        public Criteria andSwfdzsNotEqualTo(Double value) {
            addCriterion("SWFDZS <>", value, "swfdzs");
            return (Criteria) this;
        }

        public Criteria andSwfdzsGreaterThan(Double value) {
            addCriterion("SWFDZS >", value, "swfdzs");
            return (Criteria) this;
        }

        public Criteria andSwfdzsGreaterThanOrEqualTo(Double value) {
            addCriterion("SWFDZS >=", value, "swfdzs");
            return (Criteria) this;
        }

        public Criteria andSwfdzsLessThan(Double value) {
            addCriterion("SWFDZS <", value, "swfdzs");
            return (Criteria) this;
        }

        public Criteria andSwfdzsLessThanOrEqualTo(Double value) {
            addCriterion("SWFDZS <=", value, "swfdzs");
            return (Criteria) this;
        }

        public Criteria andSwfdzsIn(List<Double> values) {
            addCriterion("SWFDZS in", values, "swfdzs");
            return (Criteria) this;
        }

        public Criteria andSwfdzsNotIn(List<Double> values) {
            addCriterion("SWFDZS not in", values, "swfdzs");
            return (Criteria) this;
        }

        public Criteria andSwfdzsBetween(Double value1, Double value2) {
            addCriterion("SWFDZS between", value1, value2, "swfdzs");
            return (Criteria) this;
        }

        public Criteria andSwfdzsNotBetween(Double value1, Double value2) {
            addCriterion("SWFDZS not between", value1, value2, "swfdzs");
            return (Criteria) this;
        }

        public Criteria andZbfgzsIsNull() {
            addCriterion("ZBFGZS is null");
            return (Criteria) this;
        }

        public Criteria andZbfgzsIsNotNull() {
            addCriterion("ZBFGZS is not null");
            return (Criteria) this;
        }

        public Criteria andZbfgzsEqualTo(Double value) {
            addCriterion("ZBFGZS =", value, "zbfgzs");
            return (Criteria) this;
        }

        public Criteria andZbfgzsNotEqualTo(Double value) {
            addCriterion("ZBFGZS <>", value, "zbfgzs");
            return (Criteria) this;
        }

        public Criteria andZbfgzsGreaterThan(Double value) {
            addCriterion("ZBFGZS >", value, "zbfgzs");
            return (Criteria) this;
        }

        public Criteria andZbfgzsGreaterThanOrEqualTo(Double value) {
            addCriterion("ZBFGZS >=", value, "zbfgzs");
            return (Criteria) this;
        }

        public Criteria andZbfgzsLessThan(Double value) {
            addCriterion("ZBFGZS <", value, "zbfgzs");
            return (Criteria) this;
        }

        public Criteria andZbfgzsLessThanOrEqualTo(Double value) {
            addCriterion("ZBFGZS <=", value, "zbfgzs");
            return (Criteria) this;
        }

        public Criteria andZbfgzsIn(List<Double> values) {
            addCriterion("ZBFGZS in", values, "zbfgzs");
            return (Criteria) this;
        }

        public Criteria andZbfgzsNotIn(List<Double> values) {
            addCriterion("ZBFGZS not in", values, "zbfgzs");
            return (Criteria) this;
        }

        public Criteria andZbfgzsBetween(Double value1, Double value2) {
            addCriterion("ZBFGZS between", value1, value2, "zbfgzs");
            return (Criteria) this;
        }

        public Criteria andZbfgzsNotBetween(Double value1, Double value2) {
            addCriterion("ZBFGZS not between", value1, value2, "zbfgzs");
            return (Criteria) this;
        }

        public Criteria andSwmdzsIsNull() {
            addCriterion("SWMDZS is null");
            return (Criteria) this;
        }

        public Criteria andSwmdzsIsNotNull() {
            addCriterion("SWMDZS is not null");
            return (Criteria) this;
        }

        public Criteria andSwmdzsEqualTo(Double value) {
            addCriterion("SWMDZS =", value, "swmdzs");
            return (Criteria) this;
        }

        public Criteria andSwmdzsNotEqualTo(Double value) {
            addCriterion("SWMDZS <>", value, "swmdzs");
            return (Criteria) this;
        }

        public Criteria andSwmdzsGreaterThan(Double value) {
            addCriterion("SWMDZS >", value, "swmdzs");
            return (Criteria) this;
        }

        public Criteria andSwmdzsGreaterThanOrEqualTo(Double value) {
            addCriterion("SWMDZS >=", value, "swmdzs");
            return (Criteria) this;
        }

        public Criteria andSwmdzsLessThan(Double value) {
            addCriterion("SWMDZS <", value, "swmdzs");
            return (Criteria) this;
        }

        public Criteria andSwmdzsLessThanOrEqualTo(Double value) {
            addCriterion("SWMDZS <=", value, "swmdzs");
            return (Criteria) this;
        }

        public Criteria andSwmdzsIn(List<Double> values) {
            addCriterion("SWMDZS in", values, "swmdzs");
            return (Criteria) this;
        }

        public Criteria andSwmdzsNotIn(List<Double> values) {
            addCriterion("SWMDZS not in", values, "swmdzs");
            return (Criteria) this;
        }

        public Criteria andSwmdzsBetween(Double value1, Double value2) {
            addCriterion("SWMDZS between", value1, value2, "swmdzs");
            return (Criteria) this;
        }

        public Criteria andSwmdzsNotBetween(Double value1, Double value2) {
            addCriterion("SWMDZS not between", value1, value2, "swmdzs");
            return (Criteria) this;
        }

        public Criteria andTdxpzsIsNull() {
            addCriterion("TDXPZS is null");
            return (Criteria) this;
        }

        public Criteria andTdxpzsIsNotNull() {
            addCriterion("TDXPZS is not null");
            return (Criteria) this;
        }

        public Criteria andTdxpzsEqualTo(Double value) {
            addCriterion("TDXPZS =", value, "tdxpzs");
            return (Criteria) this;
        }

        public Criteria andTdxpzsNotEqualTo(Double value) {
            addCriterion("TDXPZS <>", value, "tdxpzs");
            return (Criteria) this;
        }

        public Criteria andTdxpzsGreaterThan(Double value) {
            addCriterion("TDXPZS >", value, "tdxpzs");
            return (Criteria) this;
        }

        public Criteria andTdxpzsGreaterThanOrEqualTo(Double value) {
            addCriterion("TDXPZS >=", value, "tdxpzs");
            return (Criteria) this;
        }

        public Criteria andTdxpzsLessThan(Double value) {
            addCriterion("TDXPZS <", value, "tdxpzs");
            return (Criteria) this;
        }

        public Criteria andTdxpzsLessThanOrEqualTo(Double value) {
            addCriterion("TDXPZS <=", value, "tdxpzs");
            return (Criteria) this;
        }

        public Criteria andTdxpzsIn(List<Double> values) {
            addCriterion("TDXPZS in", values, "tdxpzs");
            return (Criteria) this;
        }

        public Criteria andTdxpzsNotIn(List<Double> values) {
            addCriterion("TDXPZS not in", values, "tdxpzs");
            return (Criteria) this;
        }

        public Criteria andTdxpzsBetween(Double value1, Double value2) {
            addCriterion("TDXPZS between", value1, value2, "tdxpzs");
            return (Criteria) this;
        }

        public Criteria andTdxpzsNotBetween(Double value1, Double value2) {
            addCriterion("TDXPZS not between", value1, value2, "tdxpzs");
            return (Criteria) this;
        }

        public Criteria andWrfhzsIsNull() {
            addCriterion("WRFHZS is null");
            return (Criteria) this;
        }

        public Criteria andWrfhzsIsNotNull() {
            addCriterion("WRFHZS is not null");
            return (Criteria) this;
        }

        public Criteria andWrfhzsEqualTo(Double value) {
            addCriterion("WRFHZS =", value, "wrfhzs");
            return (Criteria) this;
        }

        public Criteria andWrfhzsNotEqualTo(Double value) {
            addCriterion("WRFHZS <>", value, "wrfhzs");
            return (Criteria) this;
        }

        public Criteria andWrfhzsGreaterThan(Double value) {
            addCriterion("WRFHZS >", value, "wrfhzs");
            return (Criteria) this;
        }

        public Criteria andWrfhzsGreaterThanOrEqualTo(Double value) {
            addCriterion("WRFHZS >=", value, "wrfhzs");
            return (Criteria) this;
        }

        public Criteria andWrfhzsLessThan(Double value) {
            addCriterion("WRFHZS <", value, "wrfhzs");
            return (Criteria) this;
        }

        public Criteria andWrfhzsLessThanOrEqualTo(Double value) {
            addCriterion("WRFHZS <=", value, "wrfhzs");
            return (Criteria) this;
        }

        public Criteria andWrfhzsIn(List<Double> values) {
            addCriterion("WRFHZS in", values, "wrfhzs");
            return (Criteria) this;
        }

        public Criteria andWrfhzsNotIn(List<Double> values) {
            addCriterion("WRFHZS not in", values, "wrfhzs");
            return (Criteria) this;
        }

        public Criteria andWrfhzsBetween(Double value1, Double value2) {
            addCriterion("WRFHZS between", value1, value2, "wrfhzs");
            return (Criteria) this;
        }

        public Criteria andWrfhzsNotBetween(Double value1, Double value2) {
            addCriterion("WRFHZS not between", value1, value2, "wrfhzs");
            return (Criteria) this;
        }

        public Criteria andSthjzkzseiIsNull() {
            addCriterion("STHJZKZSEI is null");
            return (Criteria) this;
        }

        public Criteria andSthjzkzseiIsNotNull() {
            addCriterion("STHJZKZSEI is not null");
            return (Criteria) this;
        }

        public Criteria andSthjzkzseiEqualTo(Double value) {
            addCriterion("STHJZKZSEI =", value, "sthjzkzsei");
            return (Criteria) this;
        }

        public Criteria andSthjzkzseiNotEqualTo(Double value) {
            addCriterion("STHJZKZSEI <>", value, "sthjzkzsei");
            return (Criteria) this;
        }

        public Criteria andSthjzkzseiGreaterThan(Double value) {
            addCriterion("STHJZKZSEI >", value, "sthjzkzsei");
            return (Criteria) this;
        }

        public Criteria andSthjzkzseiGreaterThanOrEqualTo(Double value) {
            addCriterion("STHJZKZSEI >=", value, "sthjzkzsei");
            return (Criteria) this;
        }

        public Criteria andSthjzkzseiLessThan(Double value) {
            addCriterion("STHJZKZSEI <", value, "sthjzkzsei");
            return (Criteria) this;
        }

        public Criteria andSthjzkzseiLessThanOrEqualTo(Double value) {
            addCriterion("STHJZKZSEI <=", value, "sthjzkzsei");
            return (Criteria) this;
        }

        public Criteria andSthjzkzseiIn(List<Double> values) {
            addCriterion("STHJZKZSEI in", values, "sthjzkzsei");
            return (Criteria) this;
        }

        public Criteria andSthjzkzseiNotIn(List<Double> values) {
            addCriterion("STHJZKZSEI not in", values, "sthjzkzsei");
            return (Criteria) this;
        }

        public Criteria andSthjzkzseiBetween(Double value1, Double value2) {
            addCriterion("STHJZKZSEI between", value1, value2, "sthjzkzsei");
            return (Criteria) this;
        }

        public Criteria andSthjzkzseiNotBetween(Double value1, Double value2) {
            addCriterion("STHJZKZSEI not between", value1, value2, "sthjzkzsei");
            return (Criteria) this;
        }

        public Criteria andPjjgIsNull() {
            addCriterion("PJJG is null");
            return (Criteria) this;
        }

        public Criteria andPjjgIsNotNull() {
            addCriterion("PJJG is not null");
            return (Criteria) this;
        }

        public Criteria andPjjgEqualTo(String value) {
            addCriterion("PJJG =", value, "pjjg");
            return (Criteria) this;
        }

        public Criteria andPjjgNotEqualTo(String value) {
            addCriterion("PJJG <>", value, "pjjg");
            return (Criteria) this;
        }

        public Criteria andPjjgGreaterThan(String value) {
            addCriterion("PJJG >", value, "pjjg");
            return (Criteria) this;
        }

        public Criteria andPjjgGreaterThanOrEqualTo(String value) {
            addCriterion("PJJG >=", value, "pjjg");
            return (Criteria) this;
        }

        public Criteria andPjjgLessThan(String value) {
            addCriterion("PJJG <", value, "pjjg");
            return (Criteria) this;
        }

        public Criteria andPjjgLessThanOrEqualTo(String value) {
            addCriterion("PJJG <=", value, "pjjg");
            return (Criteria) this;
        }

        public Criteria andPjjgLike(String value) {
            addCriterion("PJJG like", value, "pjjg");
            return (Criteria) this;
        }

        public Criteria andPjjgNotLike(String value) {
            addCriterion("PJJG not like", value, "pjjg");
            return (Criteria) this;
        }

        public Criteria andPjjgIn(List<String> values) {
            addCriterion("PJJG in", values, "pjjg");
            return (Criteria) this;
        }

        public Criteria andPjjgNotIn(List<String> values) {
            addCriterion("PJJG not in", values, "pjjg");
            return (Criteria) this;
        }

        public Criteria andPjjgBetween(String value1, String value2) {
            addCriterion("PJJG between", value1, value2, "pjjg");
            return (Criteria) this;
        }

        public Criteria andPjjgNotBetween(String value1, String value2) {
            addCriterion("PJJG not between", value1, value2, "pjjg");
            return (Criteria) this;
        }

        public Criteria andXymjIsNull() {
            addCriterion("XYMJ is null");
            return (Criteria) this;
        }

        public Criteria andXymjIsNotNull() {
            addCriterion("XYMJ is not null");
            return (Criteria) this;
        }

        public Criteria andXymjEqualTo(Double value) {
            addCriterion("XYMJ =", value, "xymj");
            return (Criteria) this;
        }

        public Criteria andXymjNotEqualTo(Double value) {
            addCriterion("XYMJ <>", value, "xymj");
            return (Criteria) this;
        }

        public Criteria andXymjGreaterThan(Double value) {
            addCriterion("XYMJ >", value, "xymj");
            return (Criteria) this;
        }

        public Criteria andXymjGreaterThanOrEqualTo(Double value) {
            addCriterion("XYMJ >=", value, "xymj");
            return (Criteria) this;
        }

        public Criteria andXymjLessThan(Double value) {
            addCriterion("XYMJ <", value, "xymj");
            return (Criteria) this;
        }

        public Criteria andXymjLessThanOrEqualTo(Double value) {
            addCriterion("XYMJ <=", value, "xymj");
            return (Criteria) this;
        }

        public Criteria andXymjIn(List<Double> values) {
            addCriterion("XYMJ in", values, "xymj");
            return (Criteria) this;
        }

        public Criteria andXymjNotIn(List<Double> values) {
            addCriterion("XYMJ not in", values, "xymj");
            return (Criteria) this;
        }

        public Criteria andXymjBetween(Double value1, Double value2) {
            addCriterion("XYMJ between", value1, value2, "xymj");
            return (Criteria) this;
        }

        public Criteria andXymjNotBetween(Double value1, Double value2) {
            addCriterion("XYMJ not between", value1, value2, "xymj");
            return (Criteria) this;
        }

        public Criteria andHjxzzsIsNull() {
            addCriterion("HJXZZS is null");
            return (Criteria) this;
        }

        public Criteria andHjxzzsIsNotNull() {
            addCriterion("HJXZZS is not null");
            return (Criteria) this;
        }

        public Criteria andHjxzzsEqualTo(Double value) {
            addCriterion("HJXZZS =", value, "hjxzzs");
            return (Criteria) this;
        }

        public Criteria andHjxzzsNotEqualTo(Double value) {
            addCriterion("HJXZZS <>", value, "hjxzzs");
            return (Criteria) this;
        }

        public Criteria andHjxzzsGreaterThan(Double value) {
            addCriterion("HJXZZS >", value, "hjxzzs");
            return (Criteria) this;
        }

        public Criteria andHjxzzsGreaterThanOrEqualTo(Double value) {
            addCriterion("HJXZZS >=", value, "hjxzzs");
            return (Criteria) this;
        }

        public Criteria andHjxzzsLessThan(Double value) {
            addCriterion("HJXZZS <", value, "hjxzzs");
            return (Criteria) this;
        }

        public Criteria andHjxzzsLessThanOrEqualTo(Double value) {
            addCriterion("HJXZZS <=", value, "hjxzzs");
            return (Criteria) this;
        }

        public Criteria andHjxzzsIn(List<Double> values) {
            addCriterion("HJXZZS in", values, "hjxzzs");
            return (Criteria) this;
        }

        public Criteria andHjxzzsNotIn(List<Double> values) {
            addCriterion("HJXZZS not in", values, "hjxzzs");
            return (Criteria) this;
        }

        public Criteria andHjxzzsBetween(Double value1, Double value2) {
            addCriterion("HJXZZS between", value1, value2, "hjxzzs");
            return (Criteria) this;
        }

        public Criteria andHjxzzsNotBetween(Double value1, Double value2) {
            addCriterion("HJXZZS not between", value1, value2, "hjxzzs");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("YEAR is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("YEAR is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("YEAR =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("YEAR <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("YEAR >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("YEAR >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("YEAR <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("YEAR <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("YEAR like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("YEAR not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("YEAR in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("YEAR not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("YEAR between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("YEAR not between", value1, value2, "year");
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
     * This class corresponds to the database table t_hjjczz_sthjzlei
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
     * This class corresponds to the database table t_hjjczz_sthjzlei
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