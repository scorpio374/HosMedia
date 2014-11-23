package com.zhsj.hosmedia.bean;

import java.util.List;

/**
 * EPG回看
 * @author tangqi
 *
 */
public class ScheduleBean {
	private int eventId;
	private String eventName;
	private String eventIdx;
	private String eventTotal;
	private PosterListBean posterListBean;
	// the value don't contain?
	private List<String> demandUrlList;
	private int contentGrade;
	private int isOrder;
	private int status;
	private String label;
	private String labelName;
	private int startTime;
	private int endTime;
	private int score;
	private int times;
	private String desc;
	
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
	public int getEventId() {
		return eventId;
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public String getEventName() {
		return eventName;
	}
	
	public void setEventIdx(String eventIdx) {
		this.eventIdx = eventIdx;
	}
	
	public String getEventIdx() {
		return eventIdx;
	}
	
	public void setEventTotal(String eventTotal) {
		this.eventTotal = eventTotal;
	}
	
	public String getEventTotal() {
		return eventTotal;
	}
	
	public void setPosterListBean(PosterListBean posterListBean) {
		this.posterListBean = posterListBean;
	}
	
	public PosterListBean getPosterListBean() {
		return posterListBean;
	}

	public void setDemandUrlList(List<String> demandUrlList) {
		this.demandUrlList = demandUrlList;
	}

	public List<String> getDemandUrlList() {
		return demandUrlList;
	}

	public void setContentGrade(int contentGrade) {
		this.contentGrade = contentGrade;
	}

	public int getContentGrade() {
		return contentGrade;
	}

	public void setIsOrder(int isOrder) {
		this.isOrder = isOrder;
	}

	public int getIsOrder() {
		return isOrder;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getLabelName() {
		return labelName;
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

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public int getTimes() {
		return times;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	
}
