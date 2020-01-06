package com.chinasofti.model.region;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.chinasofti.model.system.Role;
public class Department {
    private String deptid;

    private String deptname;

    private String areaid;

    private String createid;
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date createdate;

    private String editid;
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date edirtdate;
  //-----自定义属性-----
    private int row;
    private int page;
    
    private Role role;
    private Region areaname;
    
    public Region getAreaname() {
		return areaname;
	}

	public void setAreaname(Region areaname) {
		this.areaname = areaname;
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

	

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
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

    public Date getEdirtdate() {
        return edirtdate;
    }

    public void setEdirtdate(Date edirtdate) {
        this.edirtdate = edirtdate;
    }
}