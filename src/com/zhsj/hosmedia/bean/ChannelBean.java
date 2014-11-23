package com.zhsj.hosmedia.bean;

import java.util.List;

/**
 * 
 * @author tangqi
 * 频道描述
 */

public class ChannelBean {
	private int channelId;
	private String channelName;
	private int channelNum;
	private PosterListBean posterListBean;
	private int isFavorite;
	private int isHide;
	private int isFree;
	private int definition;
	private int isTsTv;
	private int isLock;
	private int isPurchased;
	private List<String> liveTvUrls;
	private List<String> tsTvUrls;
	private List<String> urls;
	private List<PfInfoBean> pfInfoBeans;
	private String lable;
	private String lableName;
	private String desc;
	
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	
	public int getChannelId() {
		return channelId;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelNum(int channelNum) {
		this.channelNum = channelNum;
	}

	public int getChannelNum() {
		return channelNum;
	}

	public void setPosterListBean(PosterListBean posterListBean) {
		this.posterListBean = posterListBean;
	}

	public PosterListBean getPosterListBean() {
		return posterListBean;
	}

	public void setIsFavorite(int isFavorite) {
		this.isFavorite = isFavorite;
	}

	public int getIsFavorite() {
		return isFavorite;
	}

	public void setIsHide(int isHide) {
		this.isHide = isHide;
	}

	public int getIsHide() {
		return isHide;
	}

	public void setIsFree(int isFree) {
		this.isFree = isFree;
	}

	public int getIsFree() {
		return isFree;
	}

	public void setDefinition(int definition) {
		this.definition = definition;
	}

	public int getDefinition() {
		return definition;
	}

	public void setIsTsTv(int isTsTv) {
		this.isTsTv = isTsTv;
	}

	public int getIsTsTv() {
		return isTsTv;
	}

	public void setIsLock(int isLock) {
		this.isLock = isLock;
	}

	public int getIsLock() {
		return isLock;
	}

	public void setIsPurchased(int isPurchased) {
		this.isPurchased = isPurchased;
	}

	public int getIsPurchased() {
		return isPurchased;
	}

	public void setPfInfoBeans(List<PfInfoBean> pfInfoBeans) {
		this.pfInfoBeans = pfInfoBeans;
	}

	public List<PfInfoBean> getPfInfoBeans() {
		return pfInfoBeans;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	public String getLable() {
		return lable;
	}

	public void setLableName(String lableName) {
		this.lableName = lableName;
	}

	public String getLableName() {
		return lableName;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setLiveTvUrls(List<String> liveTvUrls) {
		this.liveTvUrls = liveTvUrls;
	}

	public List<String> getLiveTvUrls() {
		return liveTvUrls;
	}

	public void setTsTvUrls(List<String> tsTvUrls) {
		this.tsTvUrls = tsTvUrls;
	}

	public List<String> getTsTvUrls() {
		return tsTvUrls;
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}

	public List<String> getUrls() {
		return urls;
	}
	
	
}
