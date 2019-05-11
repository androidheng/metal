package com.metal.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbBaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbBaseExample() {
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

        public Criteria andMidIsNull() {
            addCriterion("mid is null");
            return (Criteria) this;
        }

        public Criteria andMidIsNotNull() {
            addCriterion("mid is not null");
            return (Criteria) this;
        }

        public Criteria andMidEqualTo(Integer value) {
            addCriterion("mid =", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotEqualTo(Integer value) {
            addCriterion("mid <>", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThan(Integer value) {
            addCriterion("mid >", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThanOrEqualTo(Integer value) {
            addCriterion("mid >=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThan(Integer value) {
            addCriterion("mid <", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThanOrEqualTo(Integer value) {
            addCriterion("mid <=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidIn(List<Integer> values) {
            addCriterion("mid in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotIn(List<Integer> values) {
            addCriterion("mid not in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidBetween(Integer value1, Integer value2) {
            addCriterion("mid between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotBetween(Integer value1, Integer value2) {
            addCriterion("mid not between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMinenameIsNull() {
            addCriterion("minename is null");
            return (Criteria) this;
        }

        public Criteria andMinenameIsNotNull() {
            addCriterion("minename is not null");
            return (Criteria) this;
        }

        public Criteria andMinenameEqualTo(String value) {
            addCriterion("minename =", value, "minename");
            return (Criteria) this;
        }

        public Criteria andMinenameNotEqualTo(String value) {
            addCriterion("minename <>", value, "minename");
            return (Criteria) this;
        }

        public Criteria andMinenameGreaterThan(String value) {
            addCriterion("minename >", value, "minename");
            return (Criteria) this;
        }

        public Criteria andMinenameGreaterThanOrEqualTo(String value) {
            addCriterion("minename >=", value, "minename");
            return (Criteria) this;
        }

        public Criteria andMinenameLessThan(String value) {
            addCriterion("minename <", value, "minename");
            return (Criteria) this;
        }

        public Criteria andMinenameLessThanOrEqualTo(String value) {
            addCriterion("minename <=", value, "minename");
            return (Criteria) this;
        }

        public Criteria andMinenameLike(String value) {
            addCriterion("minename like", value, "minename");
            return (Criteria) this;
        }

        public Criteria andMinenameNotLike(String value) {
            addCriterion("minename not like", value, "minename");
            return (Criteria) this;
        }

        public Criteria andMinenameIn(List<String> values) {
            addCriterion("minename in", values, "minename");
            return (Criteria) this;
        }

        public Criteria andMinenameNotIn(List<String> values) {
            addCriterion("minename not in", values, "minename");
            return (Criteria) this;
        }

        public Criteria andMinenameBetween(String value1, String value2) {
            addCriterion("minename between", value1, value2, "minename");
            return (Criteria) this;
        }

        public Criteria andMinenameNotBetween(String value1, String value2) {
            addCriterion("minename not between", value1, value2, "minename");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(String value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(String value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(String value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(String value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(String value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLike(String value) {
            addCriterion("quantity like", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotLike(String value) {
            addCriterion("quantity not like", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<String> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<String> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(String value1, String value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(String value1, String value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andGoodsweightIsNull() {
            addCriterion("goodsweight is null");
            return (Criteria) this;
        }

        public Criteria andGoodsweightIsNotNull() {
            addCriterion("goodsweight is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsweightEqualTo(String value) {
            addCriterion("goodsweight =", value, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightNotEqualTo(String value) {
            addCriterion("goodsweight <>", value, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightGreaterThan(String value) {
            addCriterion("goodsweight >", value, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightGreaterThanOrEqualTo(String value) {
            addCriterion("goodsweight >=", value, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightLessThan(String value) {
            addCriterion("goodsweight <", value, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightLessThanOrEqualTo(String value) {
            addCriterion("goodsweight <=", value, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightLike(String value) {
            addCriterion("goodsweight like", value, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightNotLike(String value) {
            addCriterion("goodsweight not like", value, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightIn(List<String> values) {
            addCriterion("goodsweight in", values, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightNotIn(List<String> values) {
            addCriterion("goodsweight not in", values, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightBetween(String value1, String value2) {
            addCriterion("goodsweight between", value1, value2, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightNotBetween(String value1, String value2) {
            addCriterion("goodsweight not between", value1, value2, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andMachine1IsNull() {
            addCriterion("machine1 is null");
            return (Criteria) this;
        }

        public Criteria andMachine1IsNotNull() {
            addCriterion("machine1 is not null");
            return (Criteria) this;
        }

        public Criteria andMachine1EqualTo(String value) {
            addCriterion("machine1 =", value, "machine1");
            return (Criteria) this;
        }

        public Criteria andMachine1NotEqualTo(String value) {
            addCriterion("machine1 <>", value, "machine1");
            return (Criteria) this;
        }

        public Criteria andMachine1GreaterThan(String value) {
            addCriterion("machine1 >", value, "machine1");
            return (Criteria) this;
        }

        public Criteria andMachine1GreaterThanOrEqualTo(String value) {
            addCriterion("machine1 >=", value, "machine1");
            return (Criteria) this;
        }

        public Criteria andMachine1LessThan(String value) {
            addCriterion("machine1 <", value, "machine1");
            return (Criteria) this;
        }

        public Criteria andMachine1LessThanOrEqualTo(String value) {
            addCriterion("machine1 <=", value, "machine1");
            return (Criteria) this;
        }

        public Criteria andMachine1Like(String value) {
            addCriterion("machine1 like", value, "machine1");
            return (Criteria) this;
        }

        public Criteria andMachine1NotLike(String value) {
            addCriterion("machine1 not like", value, "machine1");
            return (Criteria) this;
        }

        public Criteria andMachine1In(List<String> values) {
            addCriterion("machine1 in", values, "machine1");
            return (Criteria) this;
        }

        public Criteria andMachine1NotIn(List<String> values) {
            addCriterion("machine1 not in", values, "machine1");
            return (Criteria) this;
        }

        public Criteria andMachine1Between(String value1, String value2) {
            addCriterion("machine1 between", value1, value2, "machine1");
            return (Criteria) this;
        }

        public Criteria andMachine1NotBetween(String value1, String value2) {
            addCriterion("machine1 not between", value1, value2, "machine1");
            return (Criteria) this;
        }

        public Criteria andMachine2IsNull() {
            addCriterion("machine2 is null");
            return (Criteria) this;
        }

        public Criteria andMachine2IsNotNull() {
            addCriterion("machine2 is not null");
            return (Criteria) this;
        }

        public Criteria andMachine2EqualTo(String value) {
            addCriterion("machine2 =", value, "machine2");
            return (Criteria) this;
        }

        public Criteria andMachine2NotEqualTo(String value) {
            addCriterion("machine2 <>", value, "machine2");
            return (Criteria) this;
        }

        public Criteria andMachine2GreaterThan(String value) {
            addCriterion("machine2 >", value, "machine2");
            return (Criteria) this;
        }

        public Criteria andMachine2GreaterThanOrEqualTo(String value) {
            addCriterion("machine2 >=", value, "machine2");
            return (Criteria) this;
        }

        public Criteria andMachine2LessThan(String value) {
            addCriterion("machine2 <", value, "machine2");
            return (Criteria) this;
        }

        public Criteria andMachine2LessThanOrEqualTo(String value) {
            addCriterion("machine2 <=", value, "machine2");
            return (Criteria) this;
        }

        public Criteria andMachine2Like(String value) {
            addCriterion("machine2 like", value, "machine2");
            return (Criteria) this;
        }

        public Criteria andMachine2NotLike(String value) {
            addCriterion("machine2 not like", value, "machine2");
            return (Criteria) this;
        }

        public Criteria andMachine2In(List<String> values) {
            addCriterion("machine2 in", values, "machine2");
            return (Criteria) this;
        }

        public Criteria andMachine2NotIn(List<String> values) {
            addCriterion("machine2 not in", values, "machine2");
            return (Criteria) this;
        }

        public Criteria andMachine2Between(String value1, String value2) {
            addCriterion("machine2 between", value1, value2, "machine2");
            return (Criteria) this;
        }

        public Criteria andMachine2NotBetween(String value1, String value2) {
            addCriterion("machine2 not between", value1, value2, "machine2");
            return (Criteria) this;
        }

        public Criteria andMaintenanceIsNull() {
            addCriterion("maintenance is null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceIsNotNull() {
            addCriterion("maintenance is not null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceEqualTo(String value) {
            addCriterion("maintenance =", value, "maintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceNotEqualTo(String value) {
            addCriterion("maintenance <>", value, "maintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceGreaterThan(String value) {
            addCriterion("maintenance >", value, "maintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceGreaterThanOrEqualTo(String value) {
            addCriterion("maintenance >=", value, "maintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceLessThan(String value) {
            addCriterion("maintenance <", value, "maintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceLessThanOrEqualTo(String value) {
            addCriterion("maintenance <=", value, "maintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceLike(String value) {
            addCriterion("maintenance like", value, "maintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceNotLike(String value) {
            addCriterion("maintenance not like", value, "maintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceIn(List<String> values) {
            addCriterion("maintenance in", values, "maintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceNotIn(List<String> values) {
            addCriterion("maintenance not in", values, "maintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceBetween(String value1, String value2) {
            addCriterion("maintenance between", value1, value2, "maintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceNotBetween(String value1, String value2) {
            addCriterion("maintenance not between", value1, value2, "maintenance");
            return (Criteria) this;
        }

        public Criteria andWageIsNull() {
            addCriterion("wage is null");
            return (Criteria) this;
        }

        public Criteria andWageIsNotNull() {
            addCriterion("wage is not null");
            return (Criteria) this;
        }

        public Criteria andWageEqualTo(String value) {
            addCriterion("wage =", value, "wage");
            return (Criteria) this;
        }

        public Criteria andWageNotEqualTo(String value) {
            addCriterion("wage <>", value, "wage");
            return (Criteria) this;
        }

        public Criteria andWageGreaterThan(String value) {
            addCriterion("wage >", value, "wage");
            return (Criteria) this;
        }

        public Criteria andWageGreaterThanOrEqualTo(String value) {
            addCriterion("wage >=", value, "wage");
            return (Criteria) this;
        }

        public Criteria andWageLessThan(String value) {
            addCriterion("wage <", value, "wage");
            return (Criteria) this;
        }

        public Criteria andWageLessThanOrEqualTo(String value) {
            addCriterion("wage <=", value, "wage");
            return (Criteria) this;
        }

        public Criteria andWageLike(String value) {
            addCriterion("wage like", value, "wage");
            return (Criteria) this;
        }

        public Criteria andWageNotLike(String value) {
            addCriterion("wage not like", value, "wage");
            return (Criteria) this;
        }

        public Criteria andWageIn(List<String> values) {
            addCriterion("wage in", values, "wage");
            return (Criteria) this;
        }

        public Criteria andWageNotIn(List<String> values) {
            addCriterion("wage not in", values, "wage");
            return (Criteria) this;
        }

        public Criteria andWageBetween(String value1, String value2) {
            addCriterion("wage between", value1, value2, "wage");
            return (Criteria) this;
        }

        public Criteria andWageNotBetween(String value1, String value2) {
            addCriterion("wage not between", value1, value2, "wage");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(String value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(String value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(String value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(String value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLike(String value) {
            addCriterion("createtime like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotLike(String value) {
            addCriterion("createtime not like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<String> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<String> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(String value1, String value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
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