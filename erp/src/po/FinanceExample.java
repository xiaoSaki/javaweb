package po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FinanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinanceExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andFidIsNull() {
            addCriterion("fid is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("fid is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(String value) {
            addCriterion("fid =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(String value) {
            addCriterion("fid <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(String value) {
            addCriterion("fid >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(String value) {
            addCriterion("fid >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(String value) {
            addCriterion("fid <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(String value) {
            addCriterion("fid <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLike(String value) {
            addCriterion("fid like", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotLike(String value) {
            addCriterion("fid not like", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<String> values) {
            addCriterion("fid in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<String> values) {
            addCriterion("fid not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(String value1, String value2) {
            addCriterion("fid between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(String value1, String value2) {
            addCriterion("fid not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andDetailIsNull() {
            addCriterion("detail is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("detail is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualTo(String value) {
            addCriterion("detail =", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("detail <>", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("detail >", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("detail >=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("detail <", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("detail <=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("detail like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotLike(String value) {
            addCriterion("detail not like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailIn(List<String> values) {
            addCriterion("detail in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("detail not in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("detail between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("detail not between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andFmoneyIsNull() {
            addCriterion("fmoney is null");
            return (Criteria) this;
        }

        public Criteria andFmoneyIsNotNull() {
            addCriterion("fmoney is not null");
            return (Criteria) this;
        }

        public Criteria andFmoneyEqualTo(BigDecimal value) {
            addCriterion("fmoney =", value, "fmoney");
            return (Criteria) this;
        }

        public Criteria andFmoneyNotEqualTo(BigDecimal value) {
            addCriterion("fmoney <>", value, "fmoney");
            return (Criteria) this;
        }

        public Criteria andFmoneyGreaterThan(BigDecimal value) {
            addCriterion("fmoney >", value, "fmoney");
            return (Criteria) this;
        }

        public Criteria andFmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fmoney >=", value, "fmoney");
            return (Criteria) this;
        }

        public Criteria andFmoneyLessThan(BigDecimal value) {
            addCriterion("fmoney <", value, "fmoney");
            return (Criteria) this;
        }

        public Criteria andFmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fmoney <=", value, "fmoney");
            return (Criteria) this;
        }

        public Criteria andFmoneyIn(List<BigDecimal> values) {
            addCriterion("fmoney in", values, "fmoney");
            return (Criteria) this;
        }

        public Criteria andFmoneyNotIn(List<BigDecimal> values) {
            addCriterion("fmoney not in", values, "fmoney");
            return (Criteria) this;
        }

        public Criteria andFmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fmoney between", value1, value2, "fmoney");
            return (Criteria) this;
        }

        public Criteria andFmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fmoney not between", value1, value2, "fmoney");
            return (Criteria) this;
        }

        public Criteria andFdateIsNull() {
            addCriterion("fdate is null");
            return (Criteria) this;
        }

        public Criteria andFdateIsNotNull() {
            addCriterion("fdate is not null");
            return (Criteria) this;
        }

        public Criteria andFdateEqualTo(Date value) {
            addCriterionForJDBCDate("fdate =", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("fdate <>", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateGreaterThan(Date value) {
            addCriterionForJDBCDate("fdate >", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fdate >=", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateLessThan(Date value) {
            addCriterionForJDBCDate("fdate <", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fdate <=", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateIn(List<Date> values) {
            addCriterionForJDBCDate("fdate in", values, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("fdate not in", values, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fdate between", value1, value2, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fdate not between", value1, value2, "fdate");
            return (Criteria) this;
        }

        public Criteria andEarnorpayIsNull() {
            addCriterion("earnorpay is null");
            return (Criteria) this;
        }

        public Criteria andEarnorpayIsNotNull() {
            addCriterion("earnorpay is not null");
            return (Criteria) this;
        }

        public Criteria andEarnorpayEqualTo(String value) {
            addCriterion("earnorpay =", value, "earnorpay");
            return (Criteria) this;
        }

        public Criteria andEarnorpayNotEqualTo(String value) {
            addCriterion("earnorpay <>", value, "earnorpay");
            return (Criteria) this;
        }

        public Criteria andEarnorpayGreaterThan(String value) {
            addCriterion("earnorpay >", value, "earnorpay");
            return (Criteria) this;
        }

        public Criteria andEarnorpayGreaterThanOrEqualTo(String value) {
            addCriterion("earnorpay >=", value, "earnorpay");
            return (Criteria) this;
        }

        public Criteria andEarnorpayLessThan(String value) {
            addCriterion("earnorpay <", value, "earnorpay");
            return (Criteria) this;
        }

        public Criteria andEarnorpayLessThanOrEqualTo(String value) {
            addCriterion("earnorpay <=", value, "earnorpay");
            return (Criteria) this;
        }

        public Criteria andEarnorpayLike(String value) {
            addCriterion("earnorpay like", value, "earnorpay");
            return (Criteria) this;
        }

        public Criteria andEarnorpayNotLike(String value) {
            addCriterion("earnorpay not like", value, "earnorpay");
            return (Criteria) this;
        }

        public Criteria andEarnorpayIn(List<String> values) {
            addCriterion("earnorpay in", values, "earnorpay");
            return (Criteria) this;
        }

        public Criteria andEarnorpayNotIn(List<String> values) {
            addCriterion("earnorpay not in", values, "earnorpay");
            return (Criteria) this;
        }

        public Criteria andEarnorpayBetween(String value1, String value2) {
            addCriterion("earnorpay between", value1, value2, "earnorpay");
            return (Criteria) this;
        }

        public Criteria andEarnorpayNotBetween(String value1, String value2) {
            addCriterion("earnorpay not between", value1, value2, "earnorpay");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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