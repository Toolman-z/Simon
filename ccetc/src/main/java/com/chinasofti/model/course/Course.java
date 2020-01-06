package com.chinasofti.model.course;

import java.util.Date;

import com.chinasofti.model.region.Department;
import com.chinasofti.model.region.Duties;
import com.chinasofti.model.region.Tech;
import com.chinasofti.model.system.Role;
import com.chinasofti.model.user.User;

public class Course {
    private Integer courseid;

    private String coursename;

    private String technologyid;

    private String fileurl;

    private String createid;

    private Date createdate;

    private String editid;

    private Date editdate;
    
    private String remark;
    
    //-----自定义属性-----
    private int row;
    
    private int page;
    
    private Role role;
  
    private Department deptname;
    
    private Duties dutiesname;
    
    private User username;
    
    private Tech technologyname;
    
    

    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public String getTechnologyid() {
        return technologyid;
    }

    public void setTechnologyid(String technologyid) {
        this.technologyid = technologyid == null ? null : technologyid.trim();
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl == null ? null : fileurl.trim();
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