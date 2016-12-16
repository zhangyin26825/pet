package com.zhangyin.pet;

public class Config {
//	{"user_id":"9c73a5dc6673a132e3a51c424de648fb","user_id_b":"1007","geohash":"ws100zrw1jch","fight":4348,"pet_info":{"704BBBCE89948F96E04D6F01601481C6":167,"63B0119F397AA23C915008A48C823B48":90,"BE76406A5DF1CE9A3D59695B56EFEFF3":0,"206AB50E4A61C6FB626FEB4B1E6CBF45":0,"078A13808B3C49E9587F979C77B1DC71":0},"request_token":"FIwNySo5ULveMoMv2AdLoyl4ZYmEXLSU","device":1}
	private static String user_id="9c73a5dc6673a132e3a51c424de648fb";
	private static String user_id_b="user_id_b";
	private static String geohash="ws100zp1zxk9";
	private static String request_token="sMq1fkjWNiXJaIabaqertMSLNmk4JUfP";
	private static int device=1;
	public static String getUser_id() {
		return user_id;
	}
	public static void setUser_id(String user_id) {
		Config.user_id = user_id;
	}
	public static String getUser_id_b() {
		return user_id_b;
	}
	public static void setUser_id_b(String user_id_b) {
		Config.user_id_b = user_id_b;
	}
	public static String getGeohash() {
		return geohash;
	}
	public static void setGeohash(String geohash) {
		Config.geohash = geohash;
	}
	public static String getRequest_token() {
		return request_token;
	}
	public static void setRequest_token(String request_token) {
		Config.request_token = request_token;
	}
	public static int getDevice() {
		return device;
	}
	public static void setDevice(int device) {
		Config.device = device;
	}
	
	
	
}
