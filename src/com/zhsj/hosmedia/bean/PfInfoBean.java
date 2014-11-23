package com.zhsj.hosmedia.bean;

/**
 * 节目PF信息
 * @author tangqi
 *
 */
public class PfInfoBean {
	private int id;
	private String name;
	private int startTime;
	private int endTime;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public int getEndTime() {
		return endTime;
	}
	
	
}
