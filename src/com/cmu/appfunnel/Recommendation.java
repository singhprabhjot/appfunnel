package com.cmu.appfunnel;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

public class Recommendation extends Activity{
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		try {
			getAppRecommendation();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
//		setContentView(R.layout.recommendation);
	}
	
	 public void getAppRecommendation() throws ClientProtocolException, IOException{
		 	Log.d("Called", "I was called");
			DefaultHttpClient httpClient=new DefaultHttpClient();
			HttpGet httpGet=new HttpGet();
			HttpResponse httpResponse= (HttpResponse) httpClient.execute(httpGet);
			System.out.print(httpResponse.toString());

  }

}
