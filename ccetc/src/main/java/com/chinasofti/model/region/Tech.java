package com.chinasofti.model.region;

import java.util.Date;

public class Tech {
    private String technologyid;

    private String technologyname;

    private String areaid;

    private String createid;

    private Date createdate;

    private String editid;

    private Date editdate;
    
    //-----自定义属性-----
    //-----自定义属性-----
    private int row;
    
    private int page;
    
    private Region areaname;
    

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

	public String getTechnologyid() {
        return technologyid;
    }

    public void setTechnologyid(String technologyid) {
        this.technologyid = technologyid == null ? null : technologyid.trim();
    }

    public String getTechnologyname() {
        return technologyname;
    }

    public void setTechnologyname(String technologyname) {
        this.technologyname = technologyname == null ? null : technologyname.trim();
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid == null ? null : areaid.trim();
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