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

public class SeriesParser {
	
	public static List<SeriesBean> parse(String data){
		if(TextUtils.isEmpty(data)){
			Log.e("Debug","SerieslParser data is null");
			return null;
		}
		
		try {
			// 判断返回状态
			JSONObject rootObject = new JSONObject(data);
			if(!CommonParser.isMsgSuccess(rootObject)){
				return null;
			}
			
			// 剧集列表
			List<SeriesBean> seriesBeans = new ArrayList<SeriesBean>();
			if(rootObject.has("series_list")){
				JSONArray seriesArray = rootObject.getJSONArray("series_list");
				for (int i = 0; i < seriesArray.length(); i++) {
					JSONObject seriesObject = seriesArray.getJSONObject(i);
					SeriesBean seriesBean = new SeriesBean();
					seriesBean.setSeriesId(seriesObject.getInt("series_id"));
					seriesBean.setSeriesName(seriesObject.getString("series_name"));
					seriesBean.setSeriesNum(seriesObject.getInt("series_num"));
//					seriesBean.setSeriesDesc(seriesObject.getString("series_desc"));
					seriesBean.setActors(seriesObject.getString("actors"));
					seriesBean.setDirector(seriesObject.getString("director"));
					seriesBean.setCountry(seriesObject.getString("country"));
					seriesBean.setLanguages(seriesObject.getString("languages"));
					seriesBean.setLabel(seriesObject.getString("label"));
					seriesBean.setLabelName(seriesObject.getString("label_name"));
					
					// 海报描述
					if(seriesObject.has("series_poster_list")){
						JSONObject posterListObject = seriesObject.getJSONObject("series_poster_list");
						PosterListBean posterListBean = CommonParser.parsePoster(posterListObject);
						seriesBean.setPosterListBean(posterListBean);
					}
					
					Log.d("Debug","SeriesParser label_name:"+seriesObject.getString("label_name"));
					seriesBeans.add(seriesBean);
				}
			}
			
			Log.d("Debug","SerieslParser finish");
			return seriesBeans;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("Debug","SerieslParser goto exception");
			return null;
		}
	}
}
