package po;

import java.util.ArrayList;
import java.util.List;

public class BomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BomExample() {
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

        public Criteria andProductmidIsNull() {
            addCriterion("productmid is null");
            return (Criteria) this;
        }

        public Criteria andProductmidIsNotNull() {
            addCriterion("productmid is not null");
            return (Criteria) this;
        }

        public Criteria andProductmidEqualTo(String value) {
            addCriterion("productmid =", value, "productmid");
            return (Criteria) this;
        }

        public Criteria andProductmidNotEqualTo(String value) {
            addCriterion("productmid <>", value, "productmid");
            return (Criteria) this;
        }

        public Criteria andProductmidGreaterThan(String value) {
            addCriterion("productmid >", value, "productmid");
            return (Criteria) this;
        }

        public Criteria andProductmidGreaterThanOrEqualTo(String value) {
            addCriterion("productmid >=", value, "productmid");
            return (Criteria) this;
        }

        public Criteria andProductmidLessThan(String value) {
            addCriterion("productmid <", value, "productmid");
            return (Criteria) this;
        }

        public Criteria andProductmidLessThanOrEqualTo(String value) {
            addCriterion("productmid <=", value, "productmid");
            return (Criteria) this;
        }

        public Criteria andProductmidLike(String value) {
            addCriterion("productmid like", value, "productmid");
            return (Criteria) this;
        }

        public Criteria andProductmidNotLike(String value) {
            addCriterion("productmid not like", value, "productmid");
            return (Criteria) this;
        }

        public Criteria andProductmidIn(List<String> values) {
            addCriterion("productmid in", values, "productmid");
            return (Criteria) this;
        }

        public Criteria andProductmidNotIn(List<String> values) {
            addCriterion("productmid not in", values, "productmid");
            return (Criteria) this;
        }

        public Criteria andProductmidBetween(String value1, String value2) {
            addCriterion("productmid between", value1, value2, "productmid");
            return (Criteria) this;
        }

        public Criteria andProductmidNotBetween(String value1, String value2) {
            addCriterion("productmid not between", value1, value2, "productmid");
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

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andPnumIsNull() {
            addCriterion("pnum is null");
            return (Criteria) this;
        }

        public Criteria andPnumIsNotNull() {
            addCriterion("pnum is not null");
            return (Criteria) this;
        }

        public Criteria andPnumEqualTo(Double value) {
            addCriterion("pnum =", value, "pnum");
            return (Criteria) this;
        }

        public Criteria andPnumNotEqualTo(Double value) {
            addCriterion("pnum <>", value, "pnum");
            return (Criteria) this;
        }

        public Criteria andPnumGreaterThan(Double value) {
            addCriterion("pnum >", value, "pnum");
            return (Criteria) this;
        }

        public Criteria andPnumGreaterThanOrEqualTo(Double value) {
            addCriterion("pnum >=", value, "pnum");
            return (Criteria) this;
        }

        public Criteria andPnumLessThan(Double value) {
            addCriterion("pnum <", value, "pnum");
            return (Criteria) this;
        }

        public Criteria andPnumLessThanOrEqualTo(Double value) {
            addCriterion("pnum <=", value, "pnum");
            return (Criteria) this;
        }

        public Criteria andPnumIn(List<Double> values) {
            addCriterion("pnum in", values, "pnum");
            return (Criteria) this;
        }

        public Criteria andPnumNotIn(List<Double> values) {
            addCriterion("pnum not in", values, "pnum");
            return (Criteria) this;
        }

        public Criteria andPnumBetween(Double value1, Double value2) {
            addCriterion("pnum between", value1, value2, "pnum");
            return (Criteria) this;
        }

        public Criteria andPnumNotBetween(Double value1, Double value2) {
            addCriterion("pnum not between", value1, value2, "pnum");
            return (Criteria) this;
        }

        public Criteria andLayerIsNull() {
            addCriterion("layer is null");
            return (Criteria) this;
        }

        public Criteria andLayerIsNotNull() {
            addCriterion("layer is not null");
            return (Criteria) this;
        }

        public Criteria andLayerEqualTo(Integer value) {
            addCriterion("layer =", value, "layer");
            return (Criteria) this;
        }

        public Criteria andLayerNotEqualTo(Integer value) {
            addCriterion("layer <>", value, "layer");
            return (Criteria) this;
        }

        public Criteria andLayerGreaterThan(Integer value) {
            addCriterion("layer >", value, "layer");
            return (Criteria) this;
        }

        public Criteria andLayerGreaterThanOrEqualTo(Integer value) {
            addCriterion("layer >=", value, "layer");
            return (Criteria) this;
        }

        public Criteria andLayerLessThan(Integer value) {
            addCriterion("layer <", value, "layer");
            return (Criteria) this;
        }

        public Criteria andLayerLessThanOrEqualTo(Integer value) {
            addCriterion("layer <=", value, "layer");
            return (Criteria) this;
        }

        public Criteria andLayerIn(List<Integer> values) {
            addCriterion("layer in", values, "layer");
            return (Criteria) this;
        }

        public Criteria andLayerNotIn(List<Integer> values) {
            addCriterion("layer not in", values, "layer");
            return (Criteria) this;
        }

        public Criteria andLayerBetween(Integer value1, Integer value2) {
            addCriterion("layer between", value1, value2, "layer");
            return (Criteria) this;
        }

        public Criteria andLayerNotBetween(Integer value1, Integer value2) {
            addCriterion("layer not between", value1, value2, "layer");
            return (Criteria) this;
        }

        public Criteria andProcnoIsNull() {
            addCriterion("procno is null");
            return (Criteria) this;
        }

        public Criteria andProcnoIsNotNull() {
            addCriterion("procno is not null");
            return (Criteria) this;
        }

        public Criteria andProcnoEqualTo(Integer value) {
            addCriterion("procno =", value, "procno");
            return (Criteria) this;
        }

        public Criteria andProcnoNotEqualTo(Integer value) {
            addCriterion("procno <>", value, "procno");
            return (Criteria) this;
        }

        public Criteria andProcnoGreaterThan(Integer value) {
            addCriterion("procno >", value, "procno");
            return (Criteria) this;
        }

        public Criteria andProcnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("procno >=", value, "procno");
            return (Criteria) this;
        }

        public Criteria andProcnoLessThan(Integer value) {
            addCriterion("procno <", value, "procno");
            return (Criteria) this;
        }

        public Criteria andProcnoLessThanOrEqualTo(Integer value) {
            addCriterion("procno <=", value, "procno");
            return (Criteria) this;
        }

        public Criteria andProcnoIn(List<Integer> values) {
            addCriterion("procno in", values, "procno");
            return (Criteria) this;
        }

        public Criteria andProcnoNotIn(List<Integer> values) {
            addCriterion("procno not in", values, "procno");
            return (Criteria) this;
        }

        public Criteria andProcnoBetween(Integer value1, Integer value2) {
            addCriterion("procno between", value1, value2, "procno");
            return (Criteria) this;
        }

        public Criteria andProcnoNotBetween(Integer value1, Integer value2) {
            addCriterion("procno not between", value1, value2, "procno");
            return (Criteria) this;
        }

        public Criteria andProcnameIsNull() {
            addCriterion("procname is null");
            return (Criteria) this;
        }

        public Criteria andProcnameIsNotNull() {
            addCriterion("procname is not null");
            return (Criteria) this;
        }

        public Criteria andProcnameEqualTo(String value) {
            addCriterion("procname =", value, "procname");
            return (Criteria) this;
        }

        public Criteria andProcnameNotEqualTo(String value) {
            addCriterion("procname <>", value, "procname");
            return (Criteria) this;
        }

        public Criteria andProcnameGreaterThan(String value) {
            addCriterion("procname >", value, "procname");
            return (Criteria) this;
        }

        public Criteria andProcnameGreaterThanOrEqualTo(String value) {
            addCriterion("procname >=", value, "procname");
            return (Criteria) this;
        }

        public Criteria andProcnameLessThan(String value) {
            addCriterion("procname <", value, "procname");
            return (Criteria) this;
        }

        public Criteria andProcnameLessThanOrEqualTo(String value) {
            addCriterion("procname <=", value, "procname");
            return (Criteria) this;
        }

        public Criteria andProcnameLike(String value) {
            addCriterion("procname like", value, "procname");
            return (Criteria) this;
        }

        public Criteria andProcnameNotLike(String value) {
            addCriterion("procname not like", value, "procname");
            return (Criteria) this;
        }

        public Criteria andProcnameIn(List<String> values) {
            addCriterion("procname in", values, "procname");
            return (Criteria) this;
        }

        public Criteria andProcnameNotIn(List<String> values) {
            addCriterion("procname not in", values, "procname");
            return (Criteria) this;
        }

        public Criteria andProcnameBetween(String value1, String value2) {
            addCriterion("procname between", value1, value2, "procname");
            return (Criteria) this;
        }

        public Criteria andProcnameNotBetween(String value1, String value2) {
            addCriterion("procname not between", value1, value2, "procname");
            return (Criteria) this;
        }

        public Criteria andPlaceIsNull() {
            addCriterion("place is null");
            return (Criteria) this;
        }

        public Criteria andPlaceIsNotNull() {
            addCriterion("place is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceEqualTo(String value) {
            addCriterion("place =", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotEqualTo(String value) {
            addCriterion("place <>", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceGreaterThan(String value) {
            addCriterion("place >", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("place >=", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLessThan(String value) {
            addCriterion("place <", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLessThanOrEqualTo(String value) {
            addCriterion("place <=", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLike(String value) {
            addCriterion("place like", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotLike(String value) {
            addCriterion("place not like", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceIn(List<String> values) {
            addCriterion("place in", values, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotIn(List<String> values) {
            addCriterion("place not in", values, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceBetween(String value1, String value2) {
            addCriterion("place between", value1, value2, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotBetween(String value1, String value2) {
            addCriterion("place not between", value1, value2, "place");
            return (Criteria) this;
        }

        public Criteria andMaketimeIsNull() {
            addCriterion("maketime is null");
            return (Criteria) this;
        }

        public Criteria andMaketimeIsNotNull() {
            addCriterion("maketime is not null");
            return (Criteria) this;
        }

        public Criteria andMaketimeEqualTo(Double value) {
            addCriterion("maketime =", value, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeNotEqualTo(Double value) {
            addCriterion("maketime <>", value, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeGreaterThan(Double value) {
            addCriterion("maketime >", value, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeGreaterThanOrEqualTo(Double value) {
            addCriterion("maketime >=", value, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeLessThan(Double value) {
            addCriterion("maketime <", value, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeLessThanOrEqualTo(Double value) {
            addCriterion("maketime <=", value, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeIn(List<Double> values) {
            addCriterion("maketime in", values, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeNotIn(List<Double> values) {
            addCriterion("maketime not in", values, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeBetween(Double value1, Double value2) {
            addCriterion("maketime between", value1, value2, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeNotBetween(Double value1, Double value2) {
            addCriterion("maketime not between", value1, value2, "maketime");
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