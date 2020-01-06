package com.chinasofti.model;

/**评论*/
public class Recommend {

	private int recid;
	private String username;
	private String time;
	private String content;
	private int type; //类型：1为电影 2为演唱会  3为美食 4为展览 5为音乐会 6为即将播放电影 
	private int tid;  //对某个id的XX的评论
	
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getRecid() {
		return recid;
	}
	public void setRecid(int recid) {
		this.recid = recid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
