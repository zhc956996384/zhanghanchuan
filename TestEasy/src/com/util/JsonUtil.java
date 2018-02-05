package com.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
//该类用于将结果集转换成JSON格式.
public class JsonUtil {
	
	
	
	public static JSONArray formatRsToJsonArray(ResultSet rs) throws Exception {
		//得到结果集(rs)的结构，比如字段数、字段名等
		ResultSetMetaData md = rs.getMetaData();
		//取得列数
		int num = md.getColumnCount();
		JSONArray array = new JSONArray();
		while (rs.next()) {
			//JSONObject和JSONArray区别:
			//http://blog.csdn.net/u014260748/article/details/41521123
			JSONObject mapOfColValues = new JSONObject();
			for (int i = 1; i <= num; i++) {
				mapOfColValues.put(md.getColumnName(i), rs.getObject(i));
			}
			array.add(mapOfColValues);
		}
		return array;
	}
}
