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
import com.zhsj.hosmedia.bean.SeriesDetailBean.VideoList;
import com.zhsj.hosmedia.bean.VodDetailBean;

public class VodDetailParser {
	
	public static VodDetailBean parse(String data){
		if(TextUtils.isEmpty(data)){
			Log.e("Debug","VodDetailParser data is null");
			return null;
		}
		
		try {
			// 判断返回状态
			JSONObject rootObject = new JSONObject(data);
			if(!CommonParser.isMsgSuccess(rootObject)){
				return null;
			}
			
			// 点播详情
			VodDetailBean vodDetailBean = new VodDetailBean();
			vodDetailBean.setVideoName(rootObject.getString("video_name"));
			vodDetailBean.setVideoNum(rootObject.getInt("video_num"));
			vodDetailBean.setVideoIdx(rootObject.getString("video_idx"));
			vodDetailBean.setSeriesId(rootObject.getInt("series_id"));
			vodDetailBean.setActors(rootObject.getString("actors"));
			vodDetailBean.setDirector(rootObject.getString("director"));
			vodDetailBean.setDuration(rootObject.getString("duration"));
			vodDetailBean.setCountry(rootObject.getString("country"));
			vodDetailBean.setLanguages(rootObject.getString("languages"));
			vodDetailBean.setSize(rootObject.getInt("size"));
			vodDetailBean.setLabel(rootObject.getString("label"));
			vodDetailBean.setLabelName(rootObject.getString("label_name"));
			vodDetailBean.setFormat(rootObject.getString("format"));
			vodDetailBean.setDefinition(rootObject.getInt("definition"));
//			vodDetailBean.setScroe(rootObject.getInt("scroe"));
			vodDetailBean.setTimes(rootObject.getInt("times"));
			vodDetailBean.setOffTime(rootObject.getInt("off_time"));
			vodDetailBean.setPlayTime(rootObject.getInt("play_time"));
			vodDetailBean.setLastId(rootObject.getInt("last_id"));
			vodDetailBean.setNextId(rootObject.getInt("next_id"));
			vodDetailBean.setIsFavourite(rootObject.getInt("is_favourite"));
			vodDetailBean.setIframeUrl(rootObject.getString("iframe_url"));
			vodDetailBean.setVolumeCompensation(rootObject.getInt("volume_compensation"));
			vodDetailBean.setPraiseNum(rootObject.getInt("praise_num"));
			vodDetailBean.setDegradeNum(rootObject.getInt("degrade_num"));
			vodDetailBean.setScoreNum(rootObject.getInt("score_num"));
			vodDetailBean.setScreenTime(rootObject.getString("screen_time"));
			vodDetailBean.setDesc(rootObject.getString("desc"));
			vodDetailBean.setPrice(rootObject.getInt("price"));
			
			// 海报描述
			if(rootObject.has("poster_list")){
				JSONObject posterListObject = rootObject.getJSONObject("poster_list");
				PosterListBean posterListBean = CommonParser.parsePoster(posterListObject);
				vodDetailBean.setPosterListBean(posterListBean);
			}
	
			// 点播地址
			if(rootObject.has("demand_url")){
				JSONArray urlArray = rootObject.getJSONArray("demand_url");
				List<String> urlList = CommonParser.parseUrlList(urlArray);
				vodDetailBean.setDemandUrlList(urlList);
			}
			
			// Mark Info
			if(rootObject.has("mark_info")){
				String markInfo = rootObject.getString("mark_info");
				ArrayList<MarkInfoBean> markInfoBeans = CommonParser.parseMarkInfo(markInfo);
				vodDetailBean.setMarkInfoBeans(markInfoBeans);
			}
			
			Log.d("Debug","VodDetailParser finish");
			return vodDetailBean;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("Debug","VodDetailParser goto exception");
			return null;
		}
	}
}
