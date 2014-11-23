package com.zhsj.hosmedia.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.text.TextUtils;
import android.util.Log;

import com.zhsj.hosmedia.bean.ChannelBean;
import com.zhsj.hosmedia.bean.PfInfoBean;
import com.zhsj.hosmedia.bean.PosterListBean;

public class ChannelListParser {
	
	public static List<ChannelBean> parse(String data){
		if(TextUtils.isEmpty(data)){
			Log.e("Debug","ChannelListParser data is null");
			return null;
		}
		
		try {
			// 判断返回状态
			JSONObject rootObject = new JSONObject(data);
			if(!CommonParser.isMsgSuccess(rootObject)){
				return null;
			}
			
			List<ChannelBean> channelBeans = new ArrayList<ChannelBean>();
			JSONArray channelArray = rootObject.getJSONArray("chnl_list");
			for (int i = 0; i < channelArray.length(); i++) {
				// 频道描述
				JSONObject channelObject = channelArray.getJSONObject(i);
				ChannelBean channelBean = new ChannelBean();
				channelBean.setChannelId(channelObject.getInt("chnl_id"));
				channelBean.setChannelName(channelObject.getString("chnl_name"));
				channelBean.setChannelNum(channelObject.getInt("chnl_num"));
				channelBean.setIsFavorite(channelObject.getInt("is_favorite"));
				channelBean.setIsHide(channelObject.getInt("is_hide"));
				channelBean.setIsFree(channelObject.getInt("is_free"));
				channelBean.setDefinition(channelObject.getInt("definition"));
				channelBean.setIsTsTv(channelObject.getInt("is_tstv"));
				channelBean.setIsLock(channelObject.getInt("is_lock"));
				channelBean.setIsPurchased(channelObject.getInt("is_purchased"));
				channelBean.setLable(channelObject.getString("label"));
				channelBean.setLableName(channelObject.getString("label_name"));
				Log.d("Debug","channel name:"+channelObject.getString("chnl_name"));
				
				// 直播地址
				if(channelObject.has("livetv_url")){
					Log.d("Debug","get livetv_url");
					JSONArray urlArray = channelObject.getJSONArray("livetv_url");
					List<String> urlList = CommonParser.parseUrlList(urlArray);
					channelBean.setLiveTvUrls(urlList);
				}
				
				// ts地址
				if(channelObject.has("tstv_url")){
					Log.d("Debug","get tstv_url");
					JSONArray urlArray = channelObject.getJSONArray("tstv_url");
					List<String> urlList = CommonParser.parseUrlList(urlArray);
					channelBean.setLiveTvUrls(urlList);
				}
				
				// 海报描述
				if(channelObject.has("poster_list")){
					JSONObject posterListObject = channelObject.getJSONObject("poster_list");
					PosterListBean posterListBean = CommonParser.parsePoster(posterListObject);
					channelBean.setPosterListBean(posterListBean);
				}
				
				// PF描述
				if(channelObject.has("pf_info")){
					Log.d("Debug","channelListParser has pf_info");
					List<PfInfoBean> pfInfoBeans = CommonParser.parsePfInfo(channelObject);
					channelBean.setPfInfoBeans(pfInfoBeans);
				}
				
				// TODO 节目推荐 popular_program
				
				// TODO 频道配置 chnl_cfg
				
				channelBeans.add(channelBean);
			}
			Log.d("Debug","ChannelListParser finish");
			return channelBeans;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("Debug","ChannelListParser goto exception");
			return null;
		}
	}
}
