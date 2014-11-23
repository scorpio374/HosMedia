package com.zhsj.hosmedia.bean;

import java.util.List;

/**
 * 剧集详情
 */
public class SeriesDetailBean {
	private String seriesName;
	private int seriesNum;
	private PosterListBean posterListBean;
	private String actors;
	private String director;
	private String country;
	private String languages;
	private String label;
	private String labelName;
	private String seriesDesc;
	private VideoList videoList;

	/**
	 * 内部类--视频列表
	 */
	public class VideoList {
		private int videoId;
		private String videoName;
		private int seriesIdx;
		private List<String> videoUrl;
		private String format;
		private PosterListBean posterListBean;
		private int duration;
		private int size;
		private int definition;
		private int transcodeFlag;
		private int isView;
		private int offTime;
		private int volumeCompensation;
		private List<MarkInfoBean> markInfoBeans;
		private String videoDesc;

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

		public void setSeriesIdx(int seriesIdx) {
			this.seriesIdx = seriesIdx;
		}

		public int getSeriesIdx() {
			return seriesIdx;
		}

		public void setVideoUrl(List<String> videoUrl) {
			this.videoUrl = videoUrl;
		}

		public List<String> getVideoUrl() {
			return videoUrl;
		}

		public void setFormat(String format) {
			this.format = format;
		}

		public String getFormat() {
			return format;
		}

		public void setPosterListBean(PosterListBean posterListBean) {
			this.posterListBean = posterListBean;
		}

		public PosterListBean getPosterListBean() {
			return posterListBean;
		}

		public void setDuration(int duration) {
			this.duration = duration;
		}

		public int getDuration() {
			return duration;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public int getSize() {
			return size;
		}

		public void setDefinition(int definition) {
			this.definition = definition;
		}

		public int getDefinition() {
			return definition;
		}

		public void setTranscodeFlag(int transcodeFlag) {
			this.transcodeFlag = transcodeFlag;
		}

		public int getTranscodeFlag() {
			return transcodeFlag;
		}

		public void setIsView(int isView) {
			this.isView = isView;
		}

		public int getIsView() {
			return isView;
		}

		public void setOffTime(int offTime) {
			this.offTime = offTime;
		}

		public int getOffTime() {
			return offTime;
		}

		public void setVolumeCompensation(int volumeCompensation) {
			this.volumeCompensation = volumeCompensation;
		}

		public int getVolumeCompensation() {
			return volumeCompensation;
		}

		public void setMarkInfoBeans(List<MarkInfoBean> markInfoBeans) {
			this.markInfoBeans = markInfoBeans;
		}

		public List<MarkInfoBean> getMarkInfoBeans() {
			return markInfoBeans;
		}

		public void setVideoDesc(String videoDesc) {
			this.videoDesc = videoDesc;
		}

		public String getVideoDesc() {
			return videoDesc;
		}
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

	public void setSeriesDesc(String seriesDesc) {
		this.seriesDesc = seriesDesc;
	}

	public String getSeriesDesc() {
		return seriesDesc;
	}

	public void setVideoList(VideoList videoList) {
		this.videoList = videoList;
	}

	public VideoList getVideoList() {
		return videoList;
	}
}
