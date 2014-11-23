package com.zhsj.hosmedia.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.text.TextUtils;
import android.util.Log;

import com.zhsj.hosmedia.bean.ProgramBean;

public class ProgramTypeParser {
	
	public static List<ProgramBean> parse(String data){
		if(TextUtils.isEmpty(data)){
			Log.e("Debug","ProgramTypeParser data is null");
			return null;
		}
		
		try {
			// 判断返回状态
			JSONObject rootObject = new JSONObject(data);
			if(!CommonParser.isMsgSuccess(rootObject)){
				return null;
			}
			
			List<ProgramBean> programBeans = new ArrayList<ProgramBean>();
			JSONArray programArray = rootObject.getJSONArray("type_list");
			for (int i = 0; i < programArray.length(); i++) {
				//节目类型描述
				JSONObject programObject = programArray.getJSONObject(i);
				ProgramBean programBean = parseProgram(programObject);
				programBeans.add(programBean);
			}
			Log.d("Debug","ProgramTypeParser finish");
			return programBeans;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("Debug","ProgramTypeParser goto exception");
			return null;
		}
	}
	
	private static ProgramBean parseProgram(JSONObject programObject){
		try {
			Log.d("Debug","parseProgram in");
			ProgramBean programBean = new ProgramBean();
			programBean.setId(programObject.getInt("id"));
			programBean.setName(programObject.getString("name"));
			programBean.setMergeIds(programObject.getString("merge_ids"));
			programBean.setDesc(programObject.getString("desc"));
			programBean.setIsHide(programObject.getInt("is_hide"));
			programBean.setOriginalName(programObject.getString("original_name"));
			programBean.setType(programObject.getString("type"));
			Log.d("Debug","parseProgram name:"+programObject.getString("name"));
			
			// 递归解析
			if(programObject.has("children")){
				Log.d("Debug","parseProgram children");
				JSONArray childrenArray = programObject.getJSONArray("children");
				List<ProgramBean> childrenList = new ArrayList<ProgramBean>();
				for (int i = 0; i < childrenArray.length(); i++) {
					ProgramBean children = parseProgram(childrenArray.getJSONObject(i));
					childrenList.add(children);
				}
				programBean.setChildrenList(childrenList);
			}
			Log.d("Debug","parseProgram out");
			return programBean;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
}
