package com.zhsj.hosmedia.bean;

import java.util.List;

/**
 * 节目类型
 * @author tangqi
 *
 */
public class ProgramBean {
	private int id;
	private String name;
	private String originalName;
	private int isHide;
	private String mergeIds;
	private String type;
	private String desc;
	private List<ProgramBean> childrenList;
	
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

	public void setMergeIds(String mergeIds) {
		this.mergeIds = mergeIds;
	}

	public String getMergeIds() {
		return mergeIds;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setChildrenList(List<ProgramBean> childrenList) {
		this.childrenList = childrenList;
	}

	public List<ProgramBean> getChildrenList() {
		return childrenList;
	}

	public void setIsHide(int isHide) {
		this.isHide = isHide;
	}

	public int getIsHide() {
		return isHide;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
