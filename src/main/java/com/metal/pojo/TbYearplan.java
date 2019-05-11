package com.metal.pojo;

public class TbYearplan {
    private Integer id;

    private Integer mid;

    private String minename;

    private String quantity;

    private String goodsweight;

    private String machine1;

    private String machine2;

    private String maintenance;

    private String wage;

    private String createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMinename() {
        return minename;
    }

    public void setMinename(String minename) {
        this.minename = minename == null ? null : minename.trim();
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity == null ? null : quantity.trim();
    }

    public String getGoodsweight() {
        return goodsweight;
    }

    public void setGoodsweight(String goodsweight) {
        this.goodsweight = goodsweight == null ? null : goodsweight.trim();
    }

    public String getMachine1() {
        return machine1;
    }

    public void setMachine1(String machine1) {
        this.machine1 = machine1 == null ? null : machine1.trim();
    }

    public String getMachine2() {
        return machine2;
    }

    public void setMachine2(String machine2) {
        this.machine2 = machine2 == null ? null : machine2.trim();
    }

    public String getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance == null ? null : maintenance.trim();
    }

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage == null ? null : wage.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
}