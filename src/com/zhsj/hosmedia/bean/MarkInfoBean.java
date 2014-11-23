package com.zhsj.hosmedia.bean;

/**
 * 视频打点信息
 * @author tangqi
 *
 */
public class MarkInfoBean {
	private int type;
	private String name;
	private String markId;
	private int flag;
	private String markDesc;
	private String startTime;
	private String endTime;
	
	public void setType(int type) {
		this.type = type;
	}
	
	public int getType() {
		return type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setMarkId(String markId) {
		this.markId = markId;
	}

	public String getMarkId() {
		return markId;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getFlag() {
		return flag;
	}

	public void setMarkDesc(String markDesc) {
		this.markDesc = markDesc;
	}

	public String getMarkDesc() {
		return markDesc;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getEndTime() {
		return endTime;
	}
	
	
}
