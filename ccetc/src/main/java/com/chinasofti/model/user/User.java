package com.chinasofti.model.user;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.chinasofti.model.region.Department;
import com.chinasofti.model.region.Duties;
import com.chinasofti.model.region.Region;
import com.chinasofti.model.system.Role;

public class User {
    private String userid;

    private String password;

    private String username;

    private String sex;

    private String properties;

    private String areaid;

    private String deptid;

    private String dutiesid;

    private String technologyid;

    private String level;

    private String travel;

    private String phone;

    private String qq;

    private String wechat;

    private String email;

    private Integer roleid;

    private Integer status;

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
    
    private Region areaname;
    
    private Department deptname;
    
    private Duties dutiesname;
    
    
    public Duties getDutiesname() {
		return dutiesname;
	}

	public void setDutiesname(Duties dutiesname) {
		this.dutiesname = dutiesname;
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

	

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties == null ? null : properties.trim();
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

    public String getDutiesid() {
        return dutiesid;
    }

    public void setDutiesid(String dutiesid) {
        this.dutiesid = dutiesid == null ? null : dutiesid.trim();
    }

    public String getTechnologyid() {
        return technologyid;
    }

    public void setTechnologyid(String technologyid) {
        this.technologyid = technologyid == null ? null : technologyid.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getTravel() {
        return travel;
    }

    public void setTravel(String travel) {
        this.travel = travel == null ? null : travel.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
    
}