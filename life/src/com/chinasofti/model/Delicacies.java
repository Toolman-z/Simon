package com.chinasofti.model;

import java.util.List;

/**√¿ ≥*/
public class Delicacies {

	private String delicacies_id;
	private String name;
	private String label;
	private String address;
	private int avg;
	private String imagename;
	private String call;
	private String mapx;
	private String mapy;
	private List<HotelDetail> hds;
	
	
	public String getCall() {
		return call;
	}
	public void setCall(String call) {
		this.call = call;
	}
	public List<HotelDetail> getHds() {
		return hds;
	}
	public void setHds(List<HotelDetail> hds) {
		this.hds = hds;
	}
	public String getDelicacies_id() {
		return delicacies_id;
	}
	public void setDelicacies_id(String delicacies_id) {
		this.delicacies_id = delicacies_id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getMapx() {
		return mapx;
	}
	public void setMapx(String mapx) {
		this.mapx = mapx;
	}
	public String getMapy() {
		return mapy;
	}
	public void setMapy(String mapy) {
		this.mapy = mapy;
	}
}
