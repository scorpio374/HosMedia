package com.zhsj.hosmedia.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.text.TextUtils;
import android.util.Log;

import com.zhsj.hosmedia.bean.MarkInfoBean;
import com.zhsj.hosmedia.bean.PosterListBean;
import com.zhsj.hosmedia.bean.ScheduleDetailBean;

public class ScheduleDetailParser {
	
	public static ScheduleDetailBean parse(String data){
		if(TextUtils.isEmpty(data)){
			Log.e("Debug","ScheduleDetailParser data is null");
			return null;
		}
		
		try {
			// 判断返回状态
			JSONObject rootObject = new JSONObject(data);
			if(!CommonParser.isMsgSuccess(rootObject)){
				return null;
			}
			
			// 回看节目列表
			ScheduleDetailBean scheduleDetailBean = new ScheduleDetailBean();
			scheduleDetailBean.setEventName(rootObject.getString("event_name"));
			scheduleDetailBean.setEventIdx(rootObject.getString("event_idx"));
			scheduleDetailBean.setActors(rootObject.getString("actors"));
			scheduleDetailBean.setDirector(rootObject.getString("director"));
			scheduleDetailBean.setLabel(rootObject.getString("label"));
			scheduleDetailBean.setLabelName(rootObject.getString("label_name"));
			scheduleDetailBean.setStartTime(rootObject.getInt("start_time"));
			scheduleDetailBean.setEndTime(rootObject.getInt("end_time"));
			scheduleDetailBean.setDefinition(rootObject.getInt("definition"));
			scheduleDetailBean.setContentGrade(rootObject.getInt("content_grade"));
			scheduleDetailBean.setIsOrder(rootObject.getInt("is_order"));
			scheduleDetailBean.setScore(rootObject.getInt("score"));
			scheduleDetailBean.setTimes(rootObject.getInt("times"));
			scheduleDetailBean.setOffTime(rootObject.getInt("off_time"));
			scheduleDetailBean.setPlayTime(rootObject.getInt("play_time"));
			scheduleDetailBean.setLastId(rootObject.getInt("last_id"));
			scheduleDetailBean.setNextId(rootObject.getInt("next_id"));
			scheduleDetailBean.setIsFavourite(rootObject.getInt("is_favourite"));
			scheduleDetailBean.setDesc(rootObject.getString("desc"));
			scheduleDetailBean.setIframeUrl(rootObject.getString("iframe_url"));
			scheduleDetailBean.setPraiseNum(rootObject.getInt("praise_num"));
//			scheduleDetailBean.setDegradeNum(rootObject.getInt("degrade_num"));
			scheduleDetailBean.setScoreNum(rootObject.getString("score_num"));
			
			// PlayToken
			
			// 海报描述
			if(rootObject.has("poster_list")){
				JSONObject posterListObject = rootObject.getJSONObject("poster_list");
				PosterListBean posterListBean = CommonParser.parsePoster(posterListObject);
				scheduleDetailBean.setPosterListBean(posterListBean);
			}
			
			// 播放地址 
			if(rootObject.has("demand_url")){
				// TODO here may be error
				JSONArray urlArray = rootObject.getJSONArray("demand_url");
				List<String> urlList = CommonParser.parseUrlList(urlArray);
				scheduleDetailBean.setDemandUrlList(urlList);
			}
			
			// Mark Info
			if(rootObject.has("mark_info")){
				String markInfo = rootObject.getString("mark_info");
				ArrayList<MarkInfoBean> markInfoBeans = CommonParser.parseMarkInfo(markInfo);
				scheduleDetailBean.setMarkInfoBeans(markInfoBeans);
			}
			
			Log.d("Debug","ScheduleParser finish");
			return scheduleDetailBean;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("Debug","ScheduleParser goto exception");
			return null;
		}
	}
}
