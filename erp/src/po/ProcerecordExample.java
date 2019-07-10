package po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProcerecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProcerecordExample() {
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

        public Criteria andPridIsNull() {
            addCriterion("prid is null");
            return (Criteria) this;
        }

        public Criteria andPridIsNotNull() {
            addCriterion("prid is not null");
            return (Criteria) this;
        }

        public Criteria andPridEqualTo(String value) {
            addCriterion("prid =", value, "prid");
            return (Criteria) this;
        }

        public Criteria andPridNotEqualTo(String value) {
            addCriterion("prid <>", value, "prid");
            return (Criteria) this;
        }

        public Criteria andPridGreaterThan(String value) {
            addCriterion("prid >", value, "prid");
            return (Criteria) this;
        }

        public Criteria andPridGreaterThanOrEqualTo(String value) {
            addCriterion("prid >=", value, "prid");
            return (Criteria) this;
        }

        public Criteria andPridLessThan(String value) {
            addCriterion("prid <", value, "prid");
            return (Criteria) this;
        }

        public Criteria andPridLessThanOrEqualTo(String value) {
            addCriterion("prid <=", value, "prid");
            return (Criteria) this;
        }

        public Criteria andPridLike(String value) {
            addCriterion("prid like", value, "prid");
            return (Criteria) this;
        }

        public Criteria andPridNotLike(String value) {
            addCriterion("prid not like", value, "prid");
            return (Criteria) this;
        }

        public Criteria andPridIn(List<String> values) {
            addCriterion("prid in", values, "prid");
            return (Criteria) this;
        }

        public Criteria andPridNotIn(List<String> values) {
            addCriterion("prid not in", values, "prid");
            return (Criteria) this;
        }

        public Criteria andPridBetween(String value1, String value2) {
            addCriterion("prid between", value1, value2, "prid");
            return (Criteria) this;
        }

        public Criteria andPridNotBetween(String value1, String value2) {
            addCriterion("prid not between", value1, value2, "prid");
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

        public Criteria andMnumIsNull() {
            addCriterion("mnum is null");
            return (Criteria) this;
        }

        public Criteria andMnumIsNotNull() {
            addCriterion("mnum is not null");
            return (Criteria) this;
        }

        public Criteria andMnumEqualTo(Integer value) {
            addCriterion("mnum =", value, "mnum");
            return (Criteria) this;
        }

        public Criteria andMnumNotEqualTo(Integer value) {
            addCriterion("mnum <>", value, "mnum");
            return (Criteria) this;
        }

        public Criteria andMnumGreaterThan(Integer value) {
            addCriterion("mnum >", value, "mnum");
            return (Criteria) this;
        }

        public Criteria andMnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("mnum >=", value, "mnum");
            return (Criteria) this;
        }

        public Criteria andMnumLessThan(Integer value) {
            addCriterion("mnum <", value, "mnum");
            return (Criteria) this;
        }

        public Criteria andMnumLessThanOrEqualTo(Integer value) {
            addCriterion("mnum <=", value, "mnum");
            return (Criteria) this;
        }

        public Criteria andMnumIn(List<Integer> values) {
            addCriterion("mnum in", values, "mnum");
            return (Criteria) this;
        }

        public Criteria andMnumNotIn(List<Integer> values) {
            addCriterion("mnum not in", values, "mnum");
            return (Criteria) this;
        }

        public Criteria andMnumBetween(Integer value1, Integer value2) {
            addCriterion("mnum between", value1, value2, "mnum");
            return (Criteria) this;
        }

        public Criteria andMnumNotBetween(Integer value1, Integer value2) {
            addCriterion("mnum not between", value1, value2, "mnum");
            return (Criteria) this;
        }

        public Criteria andAllmaterialIsNull() {
            addCriterion("allmaterial is null");
            return (Criteria) this;
        }

        public Criteria andAllmaterialIsNotNull() {
            addCriterion("allmaterial is not null");
            return (Criteria) this;
        }

        public Criteria andAllmaterialEqualTo(String value) {
            addCriterion("allmaterial =", value, "allmaterial");
            return (Criteria) this;
        }

        public Criteria andAllmaterialNotEqualTo(String value) {
            addCriterion("allmaterial <>", value, "allmaterial");
            return (Criteria) this;
        }

        public Criteria andAllmaterialGreaterThan(String value) {
            addCriterion("allmaterial >", value, "allmaterial");
            return (Criteria) this;
        }

        public Criteria andAllmaterialGreaterThanOrEqualTo(String value) {
            addCriterion("allmaterial >=", value, "allmaterial");
            return (Criteria) this;
        }

        public Criteria andAllmaterialLessThan(String value) {
            addCriterion("allmaterial <", value, "allmaterial");
            return (Criteria) this;
        }

        public Criteria andAllmaterialLessThanOrEqualTo(String value) {
            addCriterion("allmaterial <=", value, "allmaterial");
            return (Criteria) this;
        }

        public Criteria andAllmaterialLike(String value) {
            addCriterion("allmaterial like", value, "allmaterial");
            return (Criteria) this;
        }

        public Criteria andAllmaterialNotLike(String value) {
            addCriterion("allmaterial not like", value, "allmaterial");
            return (Criteria) this;
        }

        public Criteria andAllmaterialIn(List<String> values) {
            addCriterion("allmaterial in", values, "allmaterial");
            return (Criteria) this;
        }

        public Criteria andAllmaterialNotIn(List<String> values) {
            addCriterion("allmaterial not in", values, "allmaterial");
            return (Criteria) this;
        }

        public Criteria andAllmaterialBetween(String value1, String value2) {
            addCriterion("allmaterial between", value1, value2, "allmaterial");
            return (Criteria) this;
        }

        public Criteria andAllmaterialNotBetween(String value1, String value2) {
            addCriterion("allmaterial not between", value1, value2, "allmaterial");
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

        public Criteria andPrdateIsNull() {
            addCriterion("prdate is null");
            return (Criteria) this;
        }

        public Criteria andPrdateIsNotNull() {
            addCriterion("prdate is not null");
            return (Criteria) this;
        }

        public Criteria andPrdateEqualTo(Date value) {
            addCriterionForJDBCDate("prdate =", value, "prdate");
            return (Criteria) this;
        }

        public Criteria andPrdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("prdate <>", value, "prdate");
            return (Criteria) this;
        }

        public Criteria andPrdateGreaterThan(Date value) {
            addCriterionForJDBCDate("prdate >", value, "prdate");
            return (Criteria) this;
        }

        public Criteria andPrdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("prdate >=", value, "prdate");
            return (Criteria) this;
        }

        public Criteria andPrdateLessThan(Date value) {
            addCriterionForJDBCDate("prdate <", value, "prdate");
            return (Criteria) this;
        }

        public Criteria andPrdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("prdate <=", value, "prdate");
            return (Criteria) this;
        }

        public Criteria andPrdateIn(List<Date> values) {
            addCriterionForJDBCDate("prdate in", values, "prdate");
            return (Criteria) this;
        }

        public Criteria andPrdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("prdate not in", values, "prdate");
            return (Criteria) this;
        }

        public Criteria andPrdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("prdate between", value1, value2, "prdate");
            return (Criteria) this;
        }

        public Criteria andPrdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("prdate not between", value1, value2, "prdate");
            return (Criteria) this;
        }

        public Criteria andProducetimeIsNull() {
            addCriterion("producetime is null");
            return (Criteria) this;
        }

        public Criteria andProducetimeIsNotNull() {
            addCriterion("producetime is not null");
            return (Criteria) this;
        }

        public Criteria andProducetimeEqualTo(Integer value) {
            addCriterion("producetime =", value, "producetime");
            return (Criteria) this;
        }

        public Criteria andProducetimeNotEqualTo(Integer value) {
            addCriterion("producetime <>", value, "producetime");
            return (Criteria) this;
        }

        public Criteria andProducetimeGreaterThan(Integer value) {
            addCriterion("producetime >", value, "producetime");
            return (Criteria) this;
        }

        public Criteria andProducetimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("producetime >=", value, "producetime");
            return (Criteria) this;
        }

        public Criteria andProducetimeLessThan(Integer value) {
            addCriterion("producetime <", value, "producetime");
            return (Criteria) this;
        }

        public Criteria andProducetimeLessThanOrEqualTo(Integer value) {
            addCriterion("producetime <=", value, "producetime");
            return (Criteria) this;
        }

        public Criteria andProducetimeIn(List<Integer> values) {
            addCriterion("producetime in", values, "producetime");
            return (Criteria) this;
        }

        public Criteria andProducetimeNotIn(List<Integer> values) {
            addCriterion("producetime not in", values, "producetime");
            return (Criteria) this;
        }

        public Criteria andProducetimeBetween(Integer value1, Integer value2) {
            addCriterion("producetime between", value1, value2, "producetime");
            return (Criteria) this;
        }

        public Criteria andProducetimeNotBetween(Integer value1, Integer value2) {
            addCriterion("producetime not between", value1, value2, "producetime");
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

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("grade like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("grade not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("grade not between", value1, value2, "grade");
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