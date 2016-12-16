package com.zhangyin.pet;

import java.util.List;

import com.github.davidmoten.geo.GeoHash;
import com.github.davidmoten.geo.LatLong;

public class GeoHashTest {
	
	public static void main(String[] args) {
		LatLong decodeHash = GeoHash.decodeHash("ws100zp33wgn");
		
		double lat = decodeHash.getLat();
		System.out.println("lat  "+lat);
		double lon = decodeHash.getLon();
		System.out.println("lon  "+lon);
		List<String> neighbours = GeoHash.neighbours("ws100zp33wgn");
		System.out.println(neighbours);
	}

}
