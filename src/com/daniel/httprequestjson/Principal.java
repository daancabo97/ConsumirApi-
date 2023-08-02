package com.daniel.httprequestjson;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.*;

public class Principal {

	public static void main(String[] args) throws Exception {
	 
		URL url = new URL("https://jsonplaceholder.typicode.com/comments");
		HttpURLConnection dc=(HttpURLConnection) url.openConnection();
		dc.setRequestMethod("GET");
		
		InputStream stringContenido = dc.getInputStream();
		byte[] arrayStream = stringContenido.readAllBytes();
		
		String cntJson="";
		
		for(byte tmp: arrayStream)
			cntJson+=(char)tmp;
		
		System.out.println(cntJson.length());
		
		JSONArray json = new JSONArray(cntJson);
		
		for(Object obj: json)
			System.out.println(((JSONObject)obj).get("email"));
	
			
	}

}
