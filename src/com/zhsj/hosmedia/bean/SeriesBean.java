package com.zhsj.hosmedia.bean;

/**
 * 剧集
 * @author tangqi
 *
 */
public class SeriesBean {
	private int seriesId;
	private String seriesName;
	private int seriesNum;
	private PosterListBean posterListBean;
	private String seriesDesc;
	private String actors;
	private String director;
	private String country;
	private String languages;
	private String label;
	private String labelName;
	
	public void setSeriesId(int seriesId) {
		this.seriesId = seriesId;
	}
	
	public int getSeriesId() {
		return seriesId;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesNum(int seriesNum) {
		this.seriesNum = seriesNum;
	}

	public int getSeriesNum() {
		return seriesNum;
	}

	public void setPosterListBean(PosterListBean posterListBean) {
		this.posterListBean = posterListBean;
	}

	public PosterListBean getPosterListBean() {
		return posterListBean;
	}

	public void setSeriesDesc(String seriesDesc) {
		this.seriesDesc = seriesDesc;
	}

	public String getSeriesDesc() {
		return seriesDesc;
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

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getLanguages() {
		return languages;
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
	
}
