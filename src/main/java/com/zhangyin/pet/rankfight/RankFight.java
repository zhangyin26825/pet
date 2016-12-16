package com.zhangyin.pet.rankfight;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.zhangyin.pet.App;
import com.zhangyin.pet.Config;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RankFight {
	
//	https://mc.game.supernanogame.com/station/dojo/dojo-opponent
//  {"user_id":"9c73a5dc6673a132e3a51c424de648fb","geohash":"ws100zrw1jch","request_token":"s1OPL0VsMTcOZvipyZRknLhOY9V3xu3s","device":1}	
	
	public static class DojoOpponent{
		
		private int user_id;
		private int fight;
		private int rank;
		private int state;
		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		public int getFight() {
			return fight;
		}
		public void setFight(int fight) {
			this.fight = fight;
		}
		public int getRank() {
			return rank;
		}
		public void setRank(int rank) {
			this.rank = rank;
		}
		public int getState() {
			return state;
		}
		public void setState(int state) {
			this.state = state;
		}
		
		
		
	}
	
	public  static String  dojoOpponent(){
		String url="https://mc.game.supernanogame.com/station/dojo/dojo-opponent";
		Map<String, Object> map=new LinkedHashMap<String, Object>();
		map.put("user_id", Config.getUser_id());
		map.put("geohash", Config.getGeohash());
		map.put("request_token", Config.getRequest_token());
		map.put("device", Config.getDevice());
		JSONObject jsonObject = JSONObject.fromObject(map);
		String content=jsonObject.toString();
		String result = App.sendHttpRequest(content, url);	
		return result;
	}
	
	@SuppressWarnings("deprecation")
	public static List<DojoOpponent>  parsedojoOpponent(){
		 String str=dojoOpponent();
		 JSONObject jsonObject = JSONObject.fromObject(str);
		 if(jsonObject.getInt("code")==0){
			 JSONArray jsonArray = jsonObject.getJSONArray("data");
			 List<DojoOpponent> list = JSONArray.toList(jsonArray, DojoOpponent.class); 
			 return list;
		 }
		 return null;
	}
	
	// https://mc.game.supernanogame.com/station/dojo/dojo-user-rank
	public  static String  dojoUserRank(){
		String url="https://mc.game.supernanogame.com/station/dojo/dojo-user-rank";
		Map<String, Object> map=new LinkedHashMap<String, Object>();
		map.put("user_id", Config.getUser_id());
		map.put("geohash", Config.getGeohash());
		map.put("request_token", Config.getRequest_token());
		map.put("device", Config.getDevice());
		JSONObject jsonObject = JSONObject.fromObject(map);
		String content=jsonObject.toString();
		String result = App.sendHttpRequest(content, url);	
		return result;
	}
	
	public static String parseDojoUserRank(){
		 String str=dojoUserRank();
		 JSONObject jsonObject = JSONObject.fromObject(str);
		 if(jsonObject.getInt("code")==0){
			  JSONObject challenger = jsonObject.getJSONObject("data").getJSONObject("challenger");
			  int fight = challenger.getInt("fight");
			  JSONObject base = challenger.getJSONObject("base");
		 }
		 return null;	
	}

	public static void main(String[] args) throws Exception {
//		List<DojoOpponent> parsedojoOpponent = RankFight.parsedojoOpponent();
		String df="{\"user_id\":\"9c73a5dc6673a132e3a51c424de648fb\",\"user_id_b\":\"1004\",\"geohash\":\"ws100zrw1jch\",\"fight\":39450,\"pet_info\":{\"704BBBCE89948F96E04D6F01601481C6\":2064,\"63B0119F397AA23C915008A48C823B48\":0,\"206AB50E4A61C6FB626FEB4B1E6CBF45\":0,\"336D05EFF29AE49DFC1D5869D96D654C\":0,\"F6800B68808142F6593271011E47B919\":0},\"request_token\":\"WuKfxlNzKhVrvOZv19fgIZIHm6JrZwf1\",\"device\":1}";
		   
//		String df="{\"user_id\":\"9c73a5dc6673a132e3a51c424de648fb\",\"user_id_b\":\"1007\",\"geohash\":\"ws100zrw1jch\",\"fight\":3779,\"pet_info\":{\"704BBBCE89948F96E04D6F01601481C6\":177,\"63B0119F397AA23C915008A48C823B48\":84,\"206AB50E4A61C6FB626FEB4B1E6CBF45\":0,\"336D05EFF29AE49DFC1D5869D96D654C\":0,\"F6800B68808142F6593271011E47B919\":0},\"request_token\":\"s1OPL0VsMTcOZvipyZRknLhOY9V3xu3s\",\"device\":1}";  
		for (int i = 0; i < 3000; i++) {
			RankFight.battleWin(df);
//			Thread.sleep(100);
		}
		
	}
	
	//https://mc.game.supernanogame.com/battle/battle/win
	
	public  static String  battleWin(String content) throws Exception{
		String url="https://mc.game.supernanogame.com/battle/battle/win";
		Map<String, Object> map=new LinkedHashMap<String, Object>();
		map.put("user_id", Config.getUser_id());
		map.put("geohash", Config.getGeohash());
		map.put("request_token", Config.getRequest_token());
		map.put("device", Config.getDevice());
//		JSONObject jsonObject = JSONObject.fromObject(map);
//		String content=jsonObject.toString();
		String result = App.sendHttpRequest(content, url);
		JSONObject jsonObject = JSONObject.fromObject(result);
		 if(jsonObject.getInt("code")==0){
			 
		 }else{
			 throw new Exception();
		 }
		return result;
	}
	
}
