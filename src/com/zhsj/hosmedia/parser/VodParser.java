package com.zhsj.hosmedia.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.text.TextUtils;
import android.util.Log;

import com.zhsj.hosmedia.bean.PosterListBean;
import com.zhsj.hosmedia.bean.SeriesBean;
import com.zhsj.hosmedia.bean.VodBean;

public class VodParser {
	
	public static List<VodBean> parse(String data){
		if(TextUtils.isEmpty(data)){
			Log.e("Debug","VodParser data is null");
			return null;
		}
		
		try {
			// 判断返回状态
			JSONObject rootObject = new JSONObject(data);
			if(!CommonParser.isMsgSuccess(rootObject)){
				return null;
			}
			
			// 点播列表
			List<VodBean> vodBeans = new ArrayList<VodBean>();
			if(rootObject.has("video_list")){
				JSONArray videoArray = rootObject.getJSONArray("video_list");
				for (int i = 0; i < videoArray.length(); i++) {
					JSONObject vodObject = videoArray.getJSONObject(i);
					VodBean vodBean = new VodBean();
					vodBean.setVideoId(vodObject.getInt("video_id"));
					vodBean.setVideoName(vodObject.getString("video_name"));
					vodBean.setSeriesId(vodObject.getInt("series_id"));
					vodBean.setScore(vodObject.getInt("score"));
					vodBean.setTimes(vodObject.getInt("times"));
					Log.d("Debug","VodParservideo_name:"+vodObject.getString("video_name"));
					
					// 点播地址
					if(vodObject.has("demand_url")){
						JSONArray urlArray = vodObject.getJSONArray("demand_url");
						List<String> urlList = CommonParser.parseUrlList(urlArray);
						vodBean.setDemandUrlList(urlList);
					}
					
					// 海报描述
					if(vodObject.has("poster_list")){
						JSONObject posterListObject = vodObject.getJSONObject("poster_list");
						PosterListBean posterListBean = CommonParser.parsePoster(posterListObject);
						vodBean.setPosterListBean(posterListBean);
					}
					vodBeans.add(vodBean);
				}
			}
			
			Log.d("Debug","VodParser finish");
			return vodBeans;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("Debug","VodParser goto exception");
			return null;
		}
	}
}
