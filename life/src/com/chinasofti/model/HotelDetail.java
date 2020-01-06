package com.chinasofti.model;

/**美食特色菜列表*/
public class HotelDetail {

	private int pk_id;
	private int fk_id;
	private String name;
	private String imagename;
	private int oldprice;
	private int nowprice;
	
	public int getPk_id() {
		return pk_id;
	}
	public void setPk_id(int pk_id) {
		this.pk_id = pk_id;
	}
	public int getFk_id() {
		return fk_id;
	}
	public void setFk_id(int fk_id) {
		this.fk_id = fk_id;
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
	public int getOldprice() {
		return oldprice;
	}
	public void setOldprice(int oldprice) {
		this.oldprice = oldprice;
	}
	public int getNowproce() {
		return nowprice;
	}
	public void setNowproce(int nowproce) {
		this.nowprice = nowproce;
	}
	
	
}
