package com.zhangyin.pet.stationforprop;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.github.davidmoten.geo.GeoHash;
import com.zhangyin.pet.App;
import com.zhangyin.pet.Config;

import net.sf.json.JSONObject;

public class Station {
	private static int success=0;

	public static void main(String[] args) {
//		String geohash="ws100zp1zxk9";
//		for (int i = 0; i <1000; i++) {
//			Station(geohash);
//		}
		String geohash="ws100zp6065k";
		userbuff(geohash);
		
		Set<String> set=new HashSet();
		Queue<String> q=new LinkedList<>();
		
		 q.offer(geohash);
		 String temp;
		 while(!q.isEmpty()){
			 temp=q.poll();
			 Station(temp);
			 List<String> neighbours = GeoHash.neighbours(temp);
			 for (Iterator iterator = neighbours.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				if(!set.contains(string)){
					set.add(string);
					q.offer(string);
				}
			}
		 }
		
		

	}
	//{"user_id":"9c73a5dc6673a132e3a51c424de648fb","geohash":"ws100zp33wgn","request_token":"xuCMAWzCMrTwSGs6UCfbeWuKoZWWN1Fe","device":1}
	public static void Station(String geohash){
		String url="https://mc.game.supernanogame.com/station/supply-station/station-for-props";
		Map<String, Object> map=new LinkedHashMap<String, Object>();
		map.put("user_id", Config.getUser_id());
		map.put("request_token", Config.getRequest_token());
		map.put("device", Config.getDevice());
		map.put("geohash", geohash);
		JSONObject jsonObject = JSONObject.fromObject(map);
		String content=jsonObject.toString();
		String result = App.sendHttpRequest(content, url);	
		JSONObject resultObject = JSONObject.fromObject(result);
		System.out.println(geohash);
		if(resultObject.getInt("code")==0){
			success++;
			if(success==90){
				System.out.println("end");
				throw new IllegalAccessError();
			}
			System.out.println("   "+geohash+   "     "+success+"     "+result);
		}
	}
	//https://mc.game.supernanogame.com/member/member/user-buff
	//{"user_id":"9c73a5dc6673a132e3a51c424de648fb","prop_id":800001,"request_token":"sMq1fkjWNiXJaIabaqertMSLNmk4JUfP","device":1,"geohash":"ws100zp6065k"}
	public static void userbuff(String geohash){
		String url="https://mc.game.supernanogame.com/member/member/user-buff";
		Map<String, Object> map=new LinkedHashMap<String, Object>();
		map.put("user_id", Config.getUser_id());
		map.put("prop_id", 800001);
		map.put("request_token", Config.getRequest_token());
		map.put("device", Config.getDevice());
		map.put("geohash", geohash);
		JSONObject jsonObject = JSONObject.fromObject(map);
		String content=jsonObject.toString();
		String result = App.sendHttpRequest(content, url);	
		
	}
}
