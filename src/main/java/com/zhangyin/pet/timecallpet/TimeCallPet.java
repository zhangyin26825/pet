package com.zhangyin.pet.timecallpet;

import java.util.LinkedHashMap;
import java.util.Map;

import com.zhangyin.pet.App;
import com.zhangyin.pet.Config;

import net.sf.json.JSONObject;

public class TimeCallPet {

	public static void main(String[] args) {
//		String geohash="ws100zp1xypc";
//		for (int i = 3; i < 7; i++) {
//			CallPet(i,geohash);
//		}
		
		petCatchBegin(200021,"974C223E83D98A83E3DBD6A971DEDED6","ws100zp1zxk9");

	}
	 //  召唤 计时宠物
	 //   https://mc.game.supernanogame.com/pet/map-pet/call-pet
	 //  请求 {"user_id":"9c73a5dc6673a132e3a51c424de648fb","index":6,"request_token":"Ic1nxfsfgUqwVZsybtvfnvjRlUN7qoL9","device":1,"geohash":"ws100zp1xypc"}
	 //  响应 {"code":0,"data":{"index":6,"pet_mod_id":300091,"serialize_id":"C630270E5215478929E7CA6D850F1E69","error":0}}
	public static void CallPet(int index,String geohash){
		String url="https://mc.game.supernanogame.com/pet/map-pet/call-pet";
		Map<String, Object> map=new LinkedHashMap<String, Object>();
		map.put("user_id", Config.getUser_id());
		map.put("index", index);
		map.put("request_token", Config.getRequest_token());
		map.put("device", Config.getDevice());
		map.put("geohash", geohash);
		JSONObject jsonObject = JSONObject.fromObject(map);
		String content=jsonObject.toString();
		String result = App.sendHttpRequest(content, url);	
		JSONObject resultObject = JSONObject.fromObject(result);
		if(resultObject.getInt("code")==0){
			JSONObject data = resultObject.getJSONObject("data");
			int pet_mod_id = data.getInt("pet_mod_id");
			String serialize_id = data.getString("serialize_id");
			manualEncounter(pet_mod_id,serialize_id,geohash);
			return;
		}
		throw new IllegalStateException();
	}
	
	
	
	
	 //   https://mc.game.supernanogame.com/member/member/manual-encounter
	 //  请求  {"user_id":"9c73a5dc6673a132e3a51c424de648fb","demo_id":300091,
	//        "request_token":"Ic1nxfsfgUqwVZsybtvfnvjRlUN7qoL9","device":1,"geohash":"ws100zp1xypc"}
	 //  {"code":0,"data":{}}
	
	public static void  manualEncounter(int pet_mod_id,String serialize_id,String geohash){
		String url="https://mc.game.supernanogame.com/member/member/manual-encounter";
		Map<String, Object> map=new LinkedHashMap<String, Object>();
		map.put("user_id", Config.getUser_id());
		map.put("demo_id", pet_mod_id);
		map.put("request_token", Config.getRequest_token());
		map.put("device", Config.getDevice());
		map.put("geohash", geohash);
		JSONObject jsonObject = JSONObject.fromObject(map);
		String content=jsonObject.toString();
		String result = App.sendHttpRequest(content, url);	
		JSONObject resultObject = JSONObject.fromObject(result);
		if(resultObject.getInt("code")==0){
			petCatchBegin( pet_mod_id, serialize_id, geohash);
			return;
		}
		throw new IllegalStateException("手动遭遇");
	}
	
	
	//    https://mc.game.supernanogame.com/pet/pet/pet-catch-begin
    //	{"code":0,"data":{"catch_array":[0.729,1],"
	//       catch_pet":{"level":4,
//				"skill_base_id":30001,
//				"skill_energy_id":30005,
//				"sex":2,
//				"height":89,
//				"weight":27.5,
//				"individual_atk":2.02,
//				"individual_def":8.09,
//				"individual_hp":7.83,
//				"potentiality":43,
//				"hp":30,
//				"current_hp":30,
//				"get_time":"2016-12-14 13:27:02",
//				"favorite":0,
//				"name":"",
//				"h_ratio":0.89,
//				"w_ratio":1.1,
//				"user_id":"9c73a5dc6673a132e3a51c424de648fb",
//				"demo_id":300091,
//				"id":"13BF2C9D6361217F9E2AEA35765F3FAB",
//				"status":0,
//				"address":"\u5e7f\u4e1c\u7701-\u6df1\u5733\u5e02",
//				"joy":30,
//				"joy_update_time":1481693222,
//				"joy_ceil":100,
//				"pet_equipment":"[]",
//				"serialize_id":"C630270E5215478929E7CA6D850F1E69"}
//		}}
	
	  //	{"user_id":"9c73a5dc6673a132e3a51c424de648fb",
//				"demo_id":300091,
//				"geo_hash":"ws100z",
//				"serialize_id":"C630270E5215478929E7CA6D850F1E69",
//				"location":"\u5E7F\u4E1C\u7701-\u6DF1\u5733\u5E02",
//				"request_token":"Ic1nxfsfgUqwVZsybtvfnvjRlUN7qoL9",
//				"device":1,
//				"geohash":"ws100zp1xypc"}
	  
	
	public static void petCatchBegin(int pet_mod_id,String serialize_id,String geohash){
		String url="https://mc.game.supernanogame.com/pet/pet/pet-catch-begin";
		Map<String, Object> map=new LinkedHashMap<String, Object>();
		map.put("user_id", Config.getUser_id());
		map.put("demo_id", pet_mod_id);
		map.put("geo_hash", "ws100z");
		map.put("serialize_id", "C630270E5215478929E7CA6D850F1E69");
		map.put("location", "广东省-深圳市");	
		map.put("request_token", Config.getRequest_token());
		map.put("device", Config.getDevice());
		map.put("geohash", geohash);
		JSONObject jsonObject = JSONObject.fromObject(map);
		String content=jsonObject.toString();
		String result = App.sendHttpRequest(content, url);	
		JSONObject resultObject = JSONObject.fromObject(result);
		if(resultObject.getInt("code")==0){
			petCatchEnd(geohash);
		}
	}
	//    https://mc.game.supernanogame.com/pet/pet/pet-catch-end
	// {"user_id":"9c73a5dc6673a132e3a51c424de648fb","geo_hash":"ws100zp33wgn",
	//  "record":[{"sweet_id":100001,"result":1}],"request_token":"Ic1nxfsfgUqwVZsybtvfnvjRlUN7qoL9","device":1,"geohash":"ws100zp1xypc"}
	
	public static void petCatchEnd(String geohash){
		String url="https://mc.game.supernanogame.com/pet/pet/pet-catch-end";
		Map<String, Object> map=new LinkedHashMap<String, Object>();
		map.put("user_id", Config.getUser_id());
		map.put("geo_hash", "ws100zp33wgn");	
		map.put("record", "[{\"sweet_id\":100001,\"result\":0}]");
		map.put("request_token", Config.getRequest_token());
		map.put("device", Config.getDevice());
		map.put("geohash", geohash);
		JSONObject jsonObject = JSONObject.fromObject(map);
		String content=jsonObject.toString();
		String result = App.sendHttpRequest(content, url);	
		JSONObject resultObject = JSONObject.fromObject(result);
		if(resultObject.getInt("code")==0){
		
		}
	}
	
}
