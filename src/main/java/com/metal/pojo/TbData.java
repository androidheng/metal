package com.metal.pojo;

public class TbData {
    private Integer id;

    private String carno;

    private Integer mid;

    private String minename;

    private Integer wid;

    private String warename;

    private String tonnage;

    private String createtime;
    
    private String nums;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarno() {
        return carno;
    }

    public void setCarno(String carno) {
        this.carno = carno == null ? null : carno.trim();
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

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getWarename() {
        return warename;
    }

    public void setWarename(String warename) {
        this.warename = warename == null ? null : warename.trim();
    }

    public String getTonnage() {
        return tonnage;
    }

    public void setTonnage(String tonnage) {
        this.tonnage = tonnage == null ? null : tonnage.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

	public String getNums() {
		return nums;
	}

	public void setNums(String nums) {
		this.nums = nums;
	}
    
}