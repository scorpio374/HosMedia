package com.zhsj.hosmedia.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.text.TextUtils;
import android.util.Log;

import com.zhsj.hosmedia.bean.PosterListBean;
import com.zhsj.hosmedia.bean.ScheduleBean;

public class ScheduleParser {
	
	public static List<ScheduleBean> parse(String data){
		if(TextUtils.isEmpty(data)){
			Log.e("Debug","ScheduleParser data is null");
			return null;
		}
		
		try {
			//判断返回状态
			JSONObject rootObject = new JSONObject(data);
			if(!CommonParser.isMsgSuccess(rootObject)){
				return null;
			}
			
			// 回看节目列表
			List<ScheduleBean> mScheduleBeanList = new ArrayList<ScheduleBean>();
			if(rootObject.has("event_list")){
				JSONArray eventArray = rootObject.getJSONArray("event_list");
				for (int i = 0; i < eventArray.length(); i++) {
					JSONObject scheduleObject = eventArray.getJSONObject(i);
					ScheduleBean scheduleBean = new ScheduleBean();
					
					// 节目描述
					scheduleBean.setEventId(scheduleObject.getInt("event_id"));
					scheduleBean.setEventName(scheduleObject.getString("event_name"));
					scheduleBean.setEventIdx(scheduleObject.getString("event_idx"));
					scheduleBean.setEventTotal(scheduleObject.getString("event_total"));
					scheduleBean.setContentGrade(scheduleObject.getInt("content_grade"));
					scheduleBean.setIsOrder(scheduleObject.getInt("is_order"));
					scheduleBean.setStatus(scheduleObject.getInt("status"));
					scheduleBean.setLabel(scheduleObject.getString("label"));
					scheduleBean.setLabelName(scheduleObject.getString("label_name"));
					scheduleBean.setStartTime(scheduleObject.getInt("start_time"));
					scheduleBean.setEndTime(scheduleObject.getInt("end_time"));
					scheduleBean.setScore(scheduleObject.getInt("score"));
					scheduleBean.setTimes(scheduleObject.getInt("times"));
					scheduleBean.setDesc(scheduleObject.getString("desc"));
					Log.d("Debug","ScheduleParser event_name:"+scheduleObject.getString("event_name"));
					
					// 海报描述
					if(scheduleObject.has("poster_list")){
						JSONObject posterListObject = scheduleObject.getJSONObject("poster_list");
						PosterListBean posterListBean = CommonParser.parsePoster(posterListObject);
						scheduleBean.setPosterListBean(posterListBean);
					}
					
					// 播放地址  测试数据没有该描述
//					if(scheduleObject.has("demand_url")){
//						// TODO here may be error
//						JSONArray urlArray = scheduleObject.getJSONArray("demand_url");
//						for (int j = 0; j < urlArray.length(); j++) {
//							scheduleBean.getDemandUrlList().add(urlArray.getString(j));
//						}
//					}
					mScheduleBeanList.add(scheduleBean);
				}
			}
			
			Log.d("Debug","ScheduleParser finish");
			return mScheduleBeanList;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("Debug","ScheduleParser goto exception");
			return null;
		}
	}
}
