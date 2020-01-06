package com.chinasofti.model.region;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.chinasofti.model.system.Role;
import com.chinasofti.model.user.User;

public class Region {
    private String areaid;

    private String areaname;

    private String createid;
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date createdate;

    private String editid;
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date editdate;
    //-----自定义属性-----
    private int row;
    
    private int page;
    
    private Role role;
  
    private Department deptname;
    
    private Duties dutiesname;
    
    private User username;
    
    private Tech technologyname;
    
    
    public Department getDeptname() {
		return deptname;
	}

	public void setDeptname(Department deptname) {
		this.deptname = deptname;
	}

	public Duties getDutiesname() {
		return dutiesname;
	}

	public void setDutiesname(Duties dutiesname) {
		this.dutiesname = dutiesname;
	}

	public User getUsername() {
		return username;
	}

	public void setUsername(User username) {
		this.username = username;
	}

	public Tech getTechnologyname() {
		return technologyname;
	}

	public void setTechnologyname(Tech technologyname) {
		this.technologyname = technologyname;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	

	public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid == null ? null : areaid.trim();
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname == null ? null : areaname.trim();
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