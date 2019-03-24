package com.bb.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import com.bb.api.BaseAuthenicationHttpClient;

import com.bb.model.Liuyanban;
import com.bb.util.Constants;



public class  LiuyanbanHttpAdapter {

	
	public static ArrayList<Liuyanban> getAllLiuyanbanList(long lastId, int pageNo, String flag) throws Exception{
		String url = Constants.WEB_APP_URL + "liuyanban.do?method=list&type=json";
		if( flag != null && !flag.equals("") ){
			try {
				flag  = URLEncoder.encode(flag, "utf-8") ;
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			url += "&f=" + flag;
		}
		
		System.out.println( " getUpdatesList url ::::::::::" + url );
		String jsonString = BaseAuthenicationHttpClient.doRequest(url, "", "");

		JSONArray jsonArray = new JSONArray(jsonString);		
		ArrayList<Liuyanban> ret = new ArrayList<Liuyanban>();
		for( int i = 0; i != jsonArray.length(); i++){
			JSONObject json = jsonArray.getJSONObject(i);

			Liuyanban object = new Liuyanban();
			object.id =  json.getString("id");

     		object.biaoti = json.getString("biaoti");
     		object.neirong = json.getString("neirong");
     		object.shijian = json.getString("shijian");
     		object.uid = json.getString("uid");
     		object.xingming = json.getString("xingming");
          
           
			ret.add(object);
		}
		return ret;
	}
	
 
	
//	public static ArrayList<Liuyanban> getFollowedByType(long lastId, int pageNo,  String news_type ) throws Exception  {
//	String url = Constants.WEB_APP_URL + "foodList.do?type=json";
//	if( news_type != null ){
//		try {
//			news_type  = URLEncoder.encode(news_type, "utf-8") ;
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		url += "&news_type=" +  news_type  ;
//	}
//	return getUpdatesList(url,lastId,pageNo);
//}
	
	
}



