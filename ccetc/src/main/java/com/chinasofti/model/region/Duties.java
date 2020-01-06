package com.chinasofti.model.region;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Duties {
    private String dutiesid;

    private String dutiesname;

    private String areaid;

    private String deptid;

    private String createid;
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date createdate;

    private String editid;
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date editdate;
    //-----自定义属性-----
    //-----自定义属性-----
    private int row;
    
    private int page;
    private Region areaname;
    private Department deptname;

    
    public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Region getAreaname() {
		return areaname;
	}

	public void setAreaname(Region areaname) {
		this.areaname = areaname;
	}

	public Department getDeptname() {
		return deptname;
	}

	public void setDeptname(Department deptname) {
		this.deptname = deptname;
	}

	public String getDutiesid() {
        return dutiesid;
    }

    public void setDutiesid(String dutiesid) {
        this.dutiesid = dutiesid == null ? null : dutiesid.trim();
    }

    public String getDutiesname() {
        return dutiesname;
    }

    public void setDutiesname(String dutiesname) {
        this.dutiesname = dutiesname == null ? null : dutiesname.trim();
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid == null ? null : areaid.trim();
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    public String getCreateid() {
        return createid;
    }

    public void setCreateid(String createid) {
        this.createid = createid == null ? null : createid.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getEditid() {
        return editid;
    }

    public void setEditid(String editid) {
        this.editid = editid == null ? null : editid.trim();
    }

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }
}