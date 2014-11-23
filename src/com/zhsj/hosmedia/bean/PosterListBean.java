package com.zhsj.hosmedia.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author tangqi
 * 海报描述
 */
public class PosterListBean {
	private String dir;
	private Map<String,String> posterMap = new HashMap<String, String>();
	private String iconFont;
	
	public void setDir(String dir) {
		this.dir = dir;
	}
	
	public String getDir() {
		return dir;
	}

	public void setPosterMap(Map<String,String> posterMap) {
		this.posterMap = posterMap;
	}

	public Map<String,String> getPosterMap() {
		return posterMap;
	}

	public void setIconFont(String iconFont) {
		this.iconFont = iconFont;
	}

	public String getIconFont() {
		return iconFont;
	}
	
	
}
