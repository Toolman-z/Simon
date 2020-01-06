package com.chinasofti.model;

/**展览*/
public class Display {

	private String displayid; //展览id
	private String name;//名称
	private String imagename;//图片
	private String address;//地址
	private String time;//时间
	private String call;//电话
	private String  host;//主办方
	private String desc;//描述
	
	

	public String getCall() {
		return call;
	}
	public void setCall(String call) {
		this.call = call;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDisplayid() {
		return displayid;
	}
	public void setDisplayid(String displayid) {
		this.displayid = displayid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
