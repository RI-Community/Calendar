package com.github.ricommunity.calendar.config;

public class ConfigService {

	public static String getVariable(String key) {
		String value = "";
		try {
			value = System.getenv(key);
		} catch (Exception e) {
		}
		return value;
	}

	public static String getVariable(String key, String fallback) {
		if(getVariable(key) == null || getVariable(key).isEmpty()) {
			return fallback;
		}
		return getVariable(key);
	}
}
