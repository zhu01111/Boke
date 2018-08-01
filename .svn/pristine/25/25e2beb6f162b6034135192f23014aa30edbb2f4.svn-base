package com.zwc.Boke.util;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class BaseResultDto {
	
	/**
	 * 列表数据以及信息提示
	 * @param code 0:成功,-1失败
	 * @param count	总数
	 * @param obj	JSONArray 或者 提示信息
	 * @return
	 * @throws Exception
	 
	public static String result(Integer code,Integer count,Object data){
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("code", code);
			jsonObject.put("count", count);
			jsonObject.put("data", data);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return jsonObject.toString();
	}
	public static String result(Integer code,String msg,Object data){
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("code", code);
			jsonObject.put("msg", msg);
			jsonObject.put("data", data);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return jsonObject.toString();
	}
	*/
	private Map<String, Object> map = new HashMap<String, Object>();

	public Map<String, Object> getMap() {
		return map;
	}
	public void setData(Map<String, Object> map) {
		this.map = map;
	}
	
}
