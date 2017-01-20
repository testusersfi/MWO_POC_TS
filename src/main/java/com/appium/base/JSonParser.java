package com.appium.base;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSonParser {
  public static JSONObject getUserData(int threadID) {
    JSONParser parser = new JSONParser();
    try {
      Object obj =
          parser.parse(new FileReader(System.getProperty("user.dir") + "/" + "credentials.json"));
      JSONObject jsonObject = (JSONObject) obj;
      JSONArray msg = (JSONArray) jsonObject.get("credentials");
      JSONObject a = (JSONObject) msg.get(threadID);
      System.out.println(msg.get(threadID));
      return a;

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static JSONArray getCredentials(String arrayName) throws FileNotFoundException, IOException, ParseException {
	  JSONParser parser = new JSONParser();
	  Object obj = null;
	  try {
		  obj = parser.parse(new FileReader(System.getProperty("user.dir") + "/" + "credentials.json"));
		  JSONObject jsonObj = new JSONObject(obj.toString());
		  //JSONObject credentialObj = jsonObj.getJSONObject("Credentials");
		  Utils.log("Credentials" + jsonObj.toString());
		  JSONArray jsonArray = jsonObj.getJSONArray(arrayName);
		  return jsonArray;
	  }catch (JSONException e) {
		  e.printStackTrace();
	  }
	  return null;
  }
}


