package com.zhsj.hosmedia.parser;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.text.TextUtils;
import android.util.Log;

import com.zhsj.hosmedia.bean.ChannelBean;
import com.zhsj.hosmedia.bean.PosterListBean;

public class ChannelDetailParser {
	
	public static ChannelBean parse(String data){
		if(TextUtils.isEmpty(data)){
			Log.e("Debug","ChannelDetailParser data is null");
			return null;
		}
		
		try {
			// 频道描述
			JSONObject rootObject = new JSONObject(data);
			if(!CommonParser.isMsgSuccess(rootObject)){
				return null;
			}
			
			ChannelBean channelBean = new ChannelBean();
			channelBean.setChannelName(rootObject.getString("chnl_name"));
			channelBean.setChannelNum(rootObject.getInt("chnl_num"));
			channelBean.setIsFavorite(rootObject.getInt("is_favorite"));
			channelBean.setIsHide(rootObject.getInt("is_hide"));
			channelBean.setIsFree(rootObject.getInt("is_free"));
			channelBean.setDefinition(rootObject.getInt("definition"));
			channelBean.setIsTsTv(rootObject.getInt("is_tstv"));
			channelBean.setIsLock(rootObject.getInt("is_lock"));
			channelBean.setIsPurchased(rootObject.getInt("is_purchased"));
			channelBean.setLable(rootObject.getString("label"));
			channelBean.setLableName(rootObject.getString("label_name"));
			channelBean.setLableName(rootObject.getString("desc"));
			Log.d("Debug","channel name:"+rootObject.getString("chnl_name"));
			Log.d("Debug","channel desc:"+rootObject.getString("desc"));
			
			// 海报描述
			if(rootObject.has("poster_list")){
				JSONObject posterListObject = rootObject.getJSONObject("poster_list");
				PosterListBean posterListBean = CommonParser.parsePoster(posterListObject);
				channelBean.setPosterListBean(posterListBean);
			}
			
			// urls
			if(rootObject.has("url")){
				JSONArray urlArray = rootObject.getJSONArray("url");
				List<String> urlList = CommonParser.parseUrlList(urlArray);
				channelBean.setUrls(urlList);
			}
			Log.d("Debug","ChannelDetailParser finish");
			return channelBean;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("Debug","ChannelDetailParser goto exception");
			return null;
		}
	}
}
