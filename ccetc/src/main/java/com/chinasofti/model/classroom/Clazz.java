package com.chinasofti.model.classroom;

import java.util.Date;

import com.chinasofti.model.region.Department;
import com.chinasofti.model.region.Duties;
import com.chinasofti.model.region.Region;
import com.chinasofti.model.region.Tech;
import com.chinasofti.model.system.Role;
import com.chinasofti.model.user.User;

public class Clazz {
    private Integer clazzid;

    private String areaid;

    private String technologyid;

    private Integer classroomid;

    private Integer timetableid;

    private Integer count;

    private String properties;

    private Date startdate;

    private Date enddate;

    private String teacher;

    private String assistant;

    private String clazzmaster;

    private String remark;

    private String createid;

    private Date createdate;

    private String editid;

    private Date editdate;
    
    //-----自定义属性-----
    private int row;
    
    private int page;
    
    private Role role;
  
    private Department deptname;
    
    private Duties dutiesname;
    
    private User username;
    
    private Tech technologyname;
    
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

	public Integer getClazzid() {
        return clazzid;
    }

    public void setClazzid(Integer clazzid) {
        this.clazzid = clazzid;
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid == null ? null : areaid.trim();
    }

    public String getTechnologyid() {
        return technologyid;
    }

    public void setTechnologyid(String technologyid) {
        this.technologyid = technologyid == null ? null : technologyid.trim();
    }

    public Integer getClassroomid() {
        return classroomid;
    }

    public void setClassroomid(Integer classroomid) {
        this.classroomid = classroomid;
    }

    public Integer getTimetableid() {
        return timetableid;
    }

    public void setTimetableid(Integer timetableid) {
        this.timetableid = timetableid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties == null ? null : properties.trim();
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public String getAssistant() {
        return assistant;
    }

    public void setAssistant(String assistant) {
        this.assistant = assistant == null ? null : assistant.trim();
    }

    public String getClazzmaster() {
        return clazzmaster;
    }

    public void setClazzmaster(String clazzmaster) {
        this.clazzmaster = clazzmaster == null ? null : clazzmaster.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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