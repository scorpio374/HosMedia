package com.zhsj.hosmedia.bean;

import java.util.List;

/**
 * EPG回看详情
 * @author tangqi
 *
 */
public class ScheduleDetailBean {
	private String eventName;
	private String eventIdx;
	private List<String> demandUrlList;
	private PosterListBean posterListBean;
	private String actors;
	private String director;
	private String label;
	private String labelName;
	private int startTime;
	private int endTime;
	private int definition;
	private int contentGrade;
	private int isOrder;
	private int score;
	private int times;
	private int offTime;
	private int playTime;
	private int lastId;
	private int nextId;
	private int isFavourite;
	private String desc;
	private String iframeUrl;
	private int volumeCompensation;
	private int praiseNum;
	private int degradeNum;
	private String scoreNum;
	private List<MarkInfoBean> markInfoBeans;
	
	// PlayToken 测试数据有描述
	
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

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getActors() {
		return actors;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDirector() {
		return director;
	}

	public void setDefinition(int definition) {
		this.definition = definition;
	}

	public int getDefinition() {
		return definition;
	}

	public void setOffTime(int offTime) {
		this.offTime = offTime;
	}

	public int getOffTime() {
		return offTime;
	}

	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}

	public int getPlayTime() {
		return playTime;
	}

	public void setLastId(int lastId) {
		this.lastId = lastId;
	}

	public int getLastId() {
		return lastId;
	}

	public void setNextId(int nextId) {
		this.nextId = nextId;
	}

	public int getNextId() {
		return nextId;
	}

	public void setIsFavourite(int isFavourite) {
		this.isFavourite = isFavourite;
	}

	public int getIsFavourite() {
		return isFavourite;
	}

	public void setVolumeCompensation(int volumeCompensation) {
		this.volumeCompensation = volumeCompensation;
	}

	public int getVolumeCompensation() {
		return volumeCompensation;
	}

	public void setIframeUrl(String iframeUrl) {
		this.iframeUrl = iframeUrl;
	}

	public String getIframeUrl() {
		return iframeUrl;
	}

	public void setPraiseNum(int praiseNum) {
		this.praiseNum = praiseNum;
	}

	public int getPraiseNum() {
		return praiseNum;
	}

	public void setDegradeNum(int degradeNum) {
		this.degradeNum = degradeNum;
	}

	public int getDegradeNum() {
		return degradeNum;
	}

	public void setScoreNum(String scoreNum) {
		this.scoreNum = scoreNum;
	}

	public String getScoreNum() {
		return scoreNum;
	}

	public void setMarkInfoBeans(List<MarkInfoBean> markInfoBeans) {
		this.markInfoBeans = markInfoBeans;
	}

	public List<MarkInfoBean> getMarkInfoBeans() {
		return markInfoBeans;
	}
	
}
