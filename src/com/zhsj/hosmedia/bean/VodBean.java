package com.zhsj.hosmedia.bean;

import java.util.List;

/**
 * 点播
 * @author tangqi
 *
 */
public class VodBean {
	private int videoId;
	private String videoName;
	private int seriesId;
	private PosterListBean posterListBean;
	private List<String> demandUrlList;
	private int score;
	private int times;

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setSeriesId(int seriesId) {
		this.seriesId = seriesId;
	}

	public int getSeriesId() {
		return seriesId;
	}

	public void setPosterListBean(PosterListBean posterListBean) {
		this.posterListBean = posterListBean;
	}

	public PosterListBean getPosterListBean() {
		return posterListBean;
	}

	public void setDemandUrlList(List<String> demandUrList) {
		this.demandUrlList = demandUrList;
	}

	public List<String> getDemandUrlList() {
		return demandUrlList;
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
}
