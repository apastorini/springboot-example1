package com.gofore.grandma.utils;

import java.lang.reflect.Type;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class UtilsGrandma {

	public static <T> T copyObject(Object object) {
		Gson gson = new Gson();
		JsonObject jsonObject = gson.toJsonTree(object).getAsJsonObject();
		return gson.fromJson(jsonObject, (Type) object.getClass());
	}

	public static String generateString() {
		String uuid = UUID.randomUUID().toString();
		return "uuid = " + uuid;
	}
	
	public static String sumMinutestoHour(int min1, int min2) {
		//min 1 and min2 are minutes
		int num = min1 + min2;
		double hours = (Double.valueOf(num) / 60d);
	    int rhours = (int) Math.floor(hours);
		int minutes =  (int) Math.round((hours - Double.valueOf(rhours)) * 60);
		return   rhours+ "." + minutes;
	}

	public static int stringHourToInt(String hour) {
		//min 1 and min2 are minutes
		//Pre string is not null and have a number
		int mult=1;
		if (hour.charAt(0)=='-') {
			mult=-1;
			hour=hour.substring(1);
		}
		String nums[]=hour.split("\\.");
		int res=0;
		if(nums.length==2)
			res = mult*(Integer.valueOf(nums[0])*60 + (nums[1].charAt(0)=='0'?Integer.valueOf(nums[1]):Integer.valueOf(nums[1])*10));
		else
			res = mult*(Integer.valueOf(nums[0])*60);
		return res;
	}
	
}
