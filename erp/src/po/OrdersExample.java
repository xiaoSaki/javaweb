package po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
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

        public Criteria andOidIsNull() {
            addCriterion("oid is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("oid is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(String value) {
            addCriterion("oid =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(String value) {
            addCriterion("oid <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(String value) {
            addCriterion("oid >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(String value) {
            addCriterion("oid >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(String value) {
            addCriterion("oid <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(String value) {
            addCriterion("oid <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLike(String value) {
            addCriterion("oid like", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotLike(String value) {
            addCriterion("oid not like", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<String> values) {
            addCriterion("oid in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<String> values) {
            addCriterion("oid not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(String value1, String value2) {
            addCriterion("oid between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(String value1, String value2) {
            addCriterion("oid not between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andMidIsNull() {
            addCriterion("mid is null");
            return (Criteria) this;
        }

        public Criteria andMidIsNotNull() {
            addCriterion("mid is not null");
            return (Criteria) this;
        }

        public Criteria andMidEqualTo(String value) {
            addCriterion("mid =", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotEqualTo(String value) {
            addCriterion("mid <>", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThan(String value) {
            addCriterion("mid >", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThanOrEqualTo(String value) {
            addCriterion("mid >=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThan(String value) {
            addCriterion("mid <", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThanOrEqualTo(String value) {
            addCriterion("mid <=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLike(String value) {
            addCriterion("mid like", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotLike(String value) {
            addCriterion("mid not like", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidIn(List<String> values) {
            addCriterion("mid in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotIn(List<String> values) {
            addCriterion("mid not in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidBetween(String value1, String value2) {
            addCriterion("mid between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotBetween(String value1, String value2) {
            addCriterion("mid not between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andEidIsNull() {
            addCriterion("eid is null");
            return (Criteria) this;
        }

        public Criteria andEidIsNotNull() {
            addCriterion("eid is not null");
            return (Criteria) this;
        }

        public Criteria andEidEqualTo(String value) {
            addCriterion("eid =", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotEqualTo(String value) {
            addCriterion("eid <>", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThan(String value) {
            addCriterion("eid >", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThanOrEqualTo(String value) {
            addCriterion("eid >=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThan(String value) {
            addCriterion("eid <", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThanOrEqualTo(String value) {
            addCriterion("eid <=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLike(String value) {
            addCriterion("eid like", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotLike(String value) {
            addCriterion("eid not like", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidIn(List<String> values) {
            addCriterion("eid in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotIn(List<String> values) {
            addCriterion("eid not in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidBetween(String value1, String value2) {
            addCriterion("eid between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotBetween(String value1, String value2) {
            addCriterion("eid not between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andOmeneyIsNull() {
            addCriterion("omeney is null");
            return (Criteria) this;
        }

        public Criteria andOmeneyIsNotNull() {
            addCriterion("omeney is not null");
            return (Criteria) this;
        }

        public Criteria andOmeneyEqualTo(Double value) {
            addCriterion("omeney =", value, "omeney");
            return (Criteria) this;
        }

        public Criteria andOmeneyNotEqualTo(Double value) {
            addCriterion("omeney <>", value, "omeney");
            return (Criteria) this;
        }

        public Criteria andOmeneyGreaterThan(Double value) {
            addCriterion("omeney >", value, "omeney");
            return (Criteria) this;
        }

        public Criteria andOmeneyGreaterThanOrEqualTo(Double value) {
            addCriterion("omeney >=", value, "omeney");
            return (Criteria) this;
        }

        public Criteria andOmeneyLessThan(Double value) {
            addCriterion("omeney <", value, "omeney");
            return (Criteria) this;
        }

        public Criteria andOmeneyLessThanOrEqualTo(Double value) {
            addCriterion("omeney <=", value, "omeney");
            return (Criteria) this;
        }

        public Criteria andOmeneyIn(List<Double> values) {
            addCriterion("omeney in", values, "omeney");
            return (Criteria) this;
        }

        public Criteria andOmeneyNotIn(List<Double> values) {
            addCriterion("omeney not in", values, "omeney");
            return (Criteria) this;
        }

        public Criteria andOmeneyBetween(Double value1, Double value2) {
            addCriterion("omeney between", value1, value2, "omeney");
            return (Criteria) this;
        }

        public Criteria andOmeneyNotBetween(Double value1, Double value2) {
            addCriterion("omeney not between", value1, value2, "omeney");
            return (Criteria) this;
        }

        public Criteria andBuyerIsNull() {
            addCriterion("buyer is null");
            return (Criteria) this;
        }

        public Criteria andBuyerIsNotNull() {
            addCriterion("buyer is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerEqualTo(String value) {
            addCriterion("buyer =", value, "buyer");
            return (Criteria) this;
        }

        public Criteria andBuyerNotEqualTo(String value) {
            addCriterion("buyer <>", value, "buyer");
            return (Criteria) this;
        }

        public Criteria andBuyerGreaterThan(String value) {
            addCriterion("buyer >", value, "buyer");
            return (Criteria) this;
        }

        public Criteria andBuyerGreaterThanOrEqualTo(String value) {
            addCriterion("buyer >=", value, "buyer");
            return (Criteria) this;
        }

        public Criteria andBuyerLessThan(String value) {
            addCriterion("buyer <", value, "buyer");
            return (Criteria) this;
        }

        public Criteria andBuyerLessThanOrEqualTo(String value) {
            addCriterion("buyer <=", value, "buyer");
            return (Criteria) this;
        }

        public Criteria andBuyerLike(String value) {
            addCriterion("buyer like", value, "buyer");
            return (Criteria) this;
        }

        public Criteria andBuyerNotLike(String value) {
            addCriterion("buyer not like", value, "buyer");
            return (Criteria) this;
        }

        public Criteria andBuyerIn(List<String> values) {
            addCriterion("buyer in", values, "buyer");
            return (Criteria) this;
        }

        public Criteria andBuyerNotIn(List<String> values) {
            addCriterion("buyer not in", values, "buyer");
            return (Criteria) this;
        }

        public Criteria andBuyerBetween(String value1, String value2) {
            addCriterion("buyer between", value1, value2, "buyer");
            return (Criteria) this;
        }

        public Criteria andBuyerNotBetween(String value1, String value2) {
            addCriterion("buyer not between", value1, value2, "buyer");
            return (Criteria) this;
        }

        public Criteria andHandlerxIsNull() {
            addCriterion("handlerx is null");
            return (Criteria) this;
        }

        public Criteria andHandlerxIsNotNull() {
            addCriterion("handlerx is not null");
            return (Criteria) this;
        }

        public Criteria andHandlerxEqualTo(String value) {
            addCriterion("handlerx =", value, "handlerx");
            return (Criteria) this;
        }

        public Criteria andHandlerxNotEqualTo(String value) {
            addCriterion("handlerx <>", value, "handlerx");
            return (Criteria) this;
        }

        public Criteria andHandlerxGreaterThan(String value) {
            addCriterion("handlerx >", value, "handlerx");
            return (Criteria) this;
        }

        public Criteria andHandlerxGreaterThanOrEqualTo(String value) {
            addCriterion("handlerx >=", value, "handlerx");
            return (Criteria) this;
        }

        public Criteria andHandlerxLessThan(String value) {
            addCriterion("handlerx <", value, "handlerx");
            return (Criteria) this;
        }

        public Criteria andHandlerxLessThanOrEqualTo(String value) {
            addCriterion("handlerx <=", value, "handlerx");
            return (Criteria) this;
        }

        public Criteria andHandlerxLike(String value) {
            addCriterion("handlerx like", value, "handlerx");
            return (Criteria) this;
        }

        public Criteria andHandlerxNotLike(String value) {
            addCriterion("handlerx not like", value, "handlerx");
            return (Criteria) this;
        }

        public Criteria andHandlerxIn(List<String> values) {
            addCriterion("handlerx in", values, "handlerx");
            return (Criteria) this;
        }

        public Criteria andHandlerxNotIn(List<String> values) {
            addCriterion("handlerx not in", values, "handlerx");
            return (Criteria) this;
        }

        public Criteria andHandlerxBetween(String value1, String value2) {
            addCriterion("handlerx between", value1, value2, "handlerx");
            return (Criteria) this;
        }

        public Criteria andHandlerxNotBetween(String value1, String value2) {
            addCriterion("handlerx not between", value1, value2, "handlerx");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andBuydateIsNull() {
            addCriterion("buydate is null");
            return (Criteria) this;
        }

        public Criteria andBuydateIsNotNull() {
            addCriterion("buydate is not null");
            return (Criteria) this;
        }

        public Criteria andBuydateEqualTo(Date value) {
            addCriterionForJDBCDate("buydate =", value, "buydate");
            return (Criteria) this;
        }

        public Criteria andBuydateNotEqualTo(Date value) {
            addCriterionForJDBCDate("buydate <>", value, "buydate");
            return (Criteria) this;
        }

        public Criteria andBuydateGreaterThan(Date value) {
            addCriterionForJDBCDate("buydate >", value, "buydate");
            return (Criteria) this;
        }

        public Criteria andBuydateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("buydate >=", value, "buydate");
            return (Criteria) this;
        }

        public Criteria andBuydateLessThan(Date value) {
            addCriterionForJDBCDate("buydate <", value, "buydate");
            return (Criteria) this;
        }

        public Criteria andBuydateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("buydate <=", value, "buydate");
            return (Criteria) this;
        }

        public Criteria andBuydateIn(List<Date> values) {
            addCriterionForJDBCDate("buydate in", values, "buydate");
            return (Criteria) this;
        }

        public Criteria andBuydateNotIn(List<Date> values) {
            addCriterionForJDBCDate("buydate not in", values, "buydate");
            return (Criteria) this;
        }

        public Criteria andBuydateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("buydate between", value1, value2, "buydate");
            return (Criteria) this;
        }

        public Criteria andBuydateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("buydate not between", value1, value2, "buydate");
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