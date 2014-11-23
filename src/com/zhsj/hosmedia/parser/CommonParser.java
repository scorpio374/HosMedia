package com.zhsj.hosmedia.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.zhsj.hosmedia.bean.MarkInfoBean;
import com.zhsj.hosmedia.bean.PfInfoBean;
import com.zhsj.hosmedia.bean.PosterListBean;

public class CommonParser {

	/**
	 * 判断返回消息：成功或失败
	 * @param object
	 * @return
	 */
	public static boolean isMsgSuccess(JSONObject object) {
		try {
			if(object == null){
				Log.e("Debug","isMsgSuccess object:"+object);
				return false;
			}
			
			int ret = object.getInt("ret");
			String retMsg = object.getString("ret_msg");
			Log.d("Debug","isMsgSuccess ret:"+ret+" ret_msg:"+retMsg);
			if(ret == 0){
				Log.d("Debug","isMsgSuccess true");
				return true;
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.d("Debug","isMsgSuccess false");
		return false;
	}
	
	/**
	 * 解析海报
	 * @param object
	 * @return
	 */
	public static PosterListBean parsePoster(JSONObject object) {
		try {
			if(object == null){
				Log.e("Debug","parsePoster object:"+object);
				return null;
			}
			PosterListBean posterListBean = new PosterListBean();
			if (object.has("dir")) {
				posterListBean.setDir(object.getString("dir"));
				Log.d("Debug","parsePoster dir:"+object.getString("dir"));
			}
			if (object.has("icon_font")) {
				posterListBean.setIconFont(object.getString("icon_font"));
				Log.d("Debug","parsePoster icon_font:"+object.getString("icon_font"));
			}
			if (object.has("list")) {
				JSONObject posterObject = object.getJSONObject("list");
				getPoster(posterObject,"150x100",posterListBean);
				getPoster(posterObject,"163x198",posterListBean);
				
				// schedule detail
				getPoster(posterObject,"1280x720",posterListBean);
				getPoster(posterObject,"182x102",posterListBean);
				getPoster(posterObject,"232x138",posterListBean);
				getPoster(posterObject,"292x198",posterListBean);
				getPoster(posterObject,"292x406",posterListBean);
				getPoster(posterObject,"300x168",posterListBean);
				getPoster(posterObject,"374x214",posterListBean);
				getPoster(posterObject,"594x198",posterListBean);
				getPoster(posterObject,"594x406",posterListBean);
				getPoster(posterObject,"596x614",posterListBean);
				getPoster(posterObject,"640x338",posterListBean);
				getPoster(posterObject,"896x406",posterListBean);
				getPoster(posterObject,"896x614",posterListBean);
				getPoster(posterObject,"897x198",posterListBean);
				
				// series list
				getPoster(posterObject,"100x126",posterListBean);
				
			}
			return posterListBean;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 判断相应尺寸海报是否存在
	 * @param object
	 * @param size
	 * @param posterListBean
	 */
	private static void getPoster(JSONObject object, String size,PosterListBean posterListBean){
		try {
			if(object == null){
				Log.e("Debug","getPoster object:"+object);
				return;
			}
			if(object.has(size)){
				posterListBean.getPosterMap().put(size, object.getString(size));
				Log.d("Debug","parsePoster posterUrl size"+size+":"+object.getString(size));
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 解析PF信息
	 * @param object
	 * @return
	 */
	public static List<PfInfoBean> parsePfInfo(JSONObject object) {
		try {
			if(object == null){
				Log.e("Debug","parsePfInfo object:"+object);
				return null;
			}
			JSONArray pfInfoArray = object.getJSONArray("pf_info");
			List<PfInfoBean> mPfInfoBeans = new ArrayList<PfInfoBean>();
			for (int j = 0; j < pfInfoArray.length(); j++) {
				JSONObject pfInfoObject = pfInfoArray.getJSONObject(j);
				PfInfoBean pfInfoBean = new PfInfoBean();
				pfInfoBean.setId(pfInfoObject.getInt("id"));
				pfInfoBean.setName(pfInfoObject.getString("name"));
				pfInfoBean.setStartTime(pfInfoObject.getInt("start_time"));
				pfInfoBean.setEndTime(pfInfoObject.getInt("end_time"));
				Log.d("Debug","parsePfInfo name:"+pfInfoObject.getString("name"));
				mPfInfoBeans.add(pfInfoBean);
			}
			return mPfInfoBeans;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取播放列表
	 * @param urlArray
	 * @return
	 */
	public static List<String> parseUrlList(JSONArray urlArray) {
		try {
			if(urlArray == null){
				Log.e("Debug","getUrlList urlArray:"+urlArray);
				return null;
			}
			List<String> urlList = new ArrayList<String>();
			for (int i = 0; i < urlArray.length(); i++) {
				urlList.add(urlArray.getString(i));
				Log.d("Debug","urlList"+"["+i+"]:"+urlArray.getString(i));
			}
			return urlList;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 解析视频打点信息
	 * @param markInfo
	 * @return
	 */
	public static ArrayList<MarkInfoBean> parseMarkInfo(String markInfo) {
		try {
			if(markInfo == null){
				Log.e("Debug","parseMarkInfo markInfo:"+markInfo);
				return null;
			}
			// append json
			Log.d("Debug","markInfo:"+markInfo);
			StringBuffer sb = new StringBuffer();
			sb.append("{");
			sb.append(markInfo);
			sb.append("}");
			
			JSONObject markInfoObject = new JSONObject(sb.toString());
			JSONArray markListArray = markInfoObject.getJSONArray("mark_list");
			ArrayList<MarkInfoBean> markInfoBeans = new ArrayList<MarkInfoBean>();
			for (int j = 0; j < markListArray.length(); j++) {
				JSONObject markObject = markListArray.getJSONObject(j);
				MarkInfoBean markInfoBean = new MarkInfoBean();
				markInfoBean.setType(markObject.getInt("type"));
				markInfoBean.setName(markObject.getString("name"));
				markInfoBean.setMarkId(markObject.getString("mark_id"));
				markInfoBean.setFlag(markObject.getInt("flag"));
				markInfoBean.setMarkDesc(markObject.getString("mark_desc"));
				markInfoBean.setStartTime(markObject.getString("start_time"));
				markInfoBean.setEndTime(markObject.getString("end_time"));
				Log.d("Debug","VodDetailParser markObject type:"+markObject.getInt("type"));
				markInfoBeans.add(markInfoBean);
			}
			return markInfoBeans;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
