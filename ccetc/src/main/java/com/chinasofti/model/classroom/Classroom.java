package com.chinasofti.model.classroom;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.chinasofti.model.region.Region;

public class Classroom {
    private Integer classroomid;

    private String calssroomname;

    private String areaid;

    private String contain;

    private String status;

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
    
    private String startdate;
    
    private String enddate;
    
    
    public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

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

	public Integer getClassroomid() {
        return classroomid;
    }

    public void setClassroomid(Integer classroomid) {
        this.classroomid = classroomid;
    }

    public String getCalssroomname() {
        return calssroomname;
    }

    public void setCalssroomname(String calssroomname) {
        this.calssroomname = calssroomname == null ? null : calssroomname.trim();
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid == null ? null : areaid.trim();
    }

    public String getContain() {
        return contain;
    }

    public void setContain(String contain) {
        this.contain = contain == null ? null : contain.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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