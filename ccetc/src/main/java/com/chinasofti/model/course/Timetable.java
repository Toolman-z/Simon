package com.chinasofti.model.course;

public class Timetable {
    private Integer timetableid;

    private Integer clazzid;

    private Integer daysum;

    private String content;
    //自定义
    private Integer oldtechnologyid;
    

    public Integer getOldtechnologyid() {
		return oldtechnologyid;
	}

	public void setOldtechnologyid(Integer oldtechnologyid) {
		this.oldtechnologyid = oldtechnologyid;
	}

	public Integer getTimetableid() {
        return timetableid;
    }

    public void setTimetableid(Integer timetableid) {
        this.timetableid = timetableid;
    }

    public Integer getClazzid() {
        return clazzid;
    }

    public void setClazzid(Integer clazzid) {
        this.clazzid = clazzid;
    }

    public Integer getDaysum() {
        return daysum;
    }

    public void setDaysum(Integer daysum) {
        this.daysum = daysum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}