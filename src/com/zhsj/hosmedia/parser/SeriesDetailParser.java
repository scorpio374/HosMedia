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
import com.zhsj.hosmedia.bean.SeriesDetailBean;
import com.zhsj.hosmedia.bean.SeriesDetailBean.VideoList;

public class SeriesDetailParser {
	
	public static SeriesDetailBean parse(String data){
		if(TextUtils.isEmpty(data)){
			Log.e("Debug","SeriesDetailParser data is null");
			return null;
		}
		
		try {
			// 判断返回状态
			JSONObject rootObject = new JSONObject(data);
			if(!CommonParser.isMsgSuccess(rootObject)){
				return null;
			}
			
			// 剧集详情
			SeriesDetailBean seriesDetailBean = new SeriesDetailBean();
			seriesDetailBean.setSeriesName(rootObject.getString("series_name"));
			seriesDetailBean.setSeriesNum(rootObject.getInt("series_num"));
			seriesDetailBean.setActors(rootObject.getString("actors"));
//			seriesDetailBean.setDirector(rootObject.getString("director"));
			seriesDetailBean.setCountry(rootObject.getString("country"));
			seriesDetailBean.setLanguages(rootObject.getString("languages"));
			seriesDetailBean.setLabel(rootObject.getString("label"));
			seriesDetailBean.setLabelName(rootObject.getString("label_name"));
			seriesDetailBean.setSeriesDesc(rootObject.getString("series_desc"));
			
			// 海报描述
			if(rootObject.has("series_poster_list")){
				JSONObject posterListObject = rootObject.getJSONObject("series_poster_list");
				PosterListBean posterListBean = CommonParser.parsePoster(posterListObject);
				seriesDetailBean.setPosterListBean(posterListBean);
			}
			
			// 视频列表
			JSONArray videoArray = rootObject.getJSONArray("video_list");
			List<VideoList> videoLists = new ArrayList<SeriesDetailBean.VideoList>();
			for (int i = 0; i < videoArray.length(); i++) {
				JSONObject videoListObject = videoArray.getJSONObject(i);
				VideoList videoList = seriesDetailBean.new VideoList();
				videoList.setVideoId(videoListObject.getInt("video_id"));
				videoList.setVideoName(videoListObject.getString("video_name"));
				videoList.setSeriesIdx(videoListObject.getInt("series_idx"));
				videoList.setFormat(videoListObject.getString("format"));
				videoList.setDuration(videoListObject.getInt("duration"));
				videoList.setSize(videoListObject.getInt("size"));
//				videoList.setDefinition(videoListObject.getInt("definition"));
				videoList.setTranscodeFlag(videoListObject.getInt("transcode_flag"));
				videoList.setIsView(videoListObject.getInt("is_view"));
				videoList.setOffTime(videoListObject.getInt("off_time"));
//				videoList.setVolumeCompensation(videoListObject.getInt("volume_compensation"));
				videoList.setVideoDesc(videoListObject.getString("video_desc"));
				
				// 播放地址
				if(videoListObject.has("video_url")){
					JSONArray urlArray = videoListObject.getJSONArray("video_url");
					List<String> urlList = CommonParser.parseUrlList(urlArray);
					videoList.setVideoUrl(urlList);
				}
				
				// video_list 海报描述
				if(videoListObject.has("series_poster_list")){
					JSONObject posterListObject = videoListObject.getJSONObject("series_poster_list");
					PosterListBean posterListBean = CommonParser.parsePoster(posterListObject);
					videoList.setPosterListBean(posterListBean);
				}
				
				// Mark Info
				if(rootObject.has("mark_info")){
					String markInfo = rootObject.getString("mark_info");
					ArrayList<MarkInfoBean> markInfoBeans = CommonParser.parseMarkInfo(markInfo);
					videoList.setMarkInfoBeans(markInfoBeans);
				}
				videoLists.add(videoList);
			}
			
			Log.d("Debug","SeriesDetailParser finish");
			return seriesDetailBean;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("Debug","SeriesDetailParser goto exception");
			return null;
		}
	}
}
