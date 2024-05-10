package com.org.coops.utilities;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonUtils {

	public static JsonObject convertStringToJsonObject(String str) {
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = (JsonObject) jsonParser.parse(str);
		return jsonObject;
	}
}
