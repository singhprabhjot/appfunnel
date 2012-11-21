package com.cmu.appfunnel;


import java.io.IOException;
import java.net.URI;
import java.util.List;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showRecommendation();
        getListOfInstalledApps();

        
        Button btn=(Button) findViewById(R.id.downloadButton);
        btn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
			showDownloadLink("com.fitnesskeeper.runkeeper.pro");
		        
			}
        	
        });
        
    }



	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
    public void showRecommendation(){
    	showAppName("Bikers Choice");
      	showImage("https://lh5.ggpht.com/4Qu50eFEA0BYFVqNM0PT2gNywkRAaWy8YZTSMwkjlvAhDI1lWVcrZ56TQTUXgiH8Qg=h230");
    	showDescription("DESIGN YOUR DREAM HOME!<br>Become a superstar designer as you decorate your house.<p>DESIGN YOUR DREAM HOME!<br>Design, decorate, and personalize the home of your dreams with the #1 FREE home design game! You decide, you design!<p>Become a superstar designer as you decorate and expand your house! <br>Customize every element of your home: arrange furniture, put up cabinets, paint the walls, renovate the floors and more - anything is possible in Design My Home?! <p>Features:<br>1. PERSONALIZE, nearly 600 items to customize your house with! No other game in the Google Play has this much variety!<br>2. BEAUTIFY, your home with stunning victorian wallpaper, bamboo floors, and modern art!<br>3. DECORATE, to raise your home value and unlock new room and design pieces!<br>4. Task, finish tasks to get more coins and cash!<br>5. Sharp, stunning graphics, animations, and sounds make your dream home a REALITY!<br>6. FREE, weekly updates introduce new items, styles, and tasks!<p>Design My Home is the BEST looking, most customizable, FREE home design game for your Android Phone.<p>NOTICE<br>you could put coffeemakers toasters, lamps, plants  on tables or counters.<p>METHOD:<br>1. put a table in the room<br>2. click &quot;Design&quot; button<br>3. click categoary &quot;Applications&quot;<br>4. click sub-categoary &quot;coffeemaker&quot;<br>5. choose a coffeemaker by click <br>6. click the table which you want to put on it");
    	showRating("2.5");
//    	parseJSON();
        
    }
    
    public void showAppName(String app_name){
    	TextView appName= (TextView) findViewById(R.id.appName);
    	appName.setText(app_name);	
    }
    
    public void showImage(String url){
        String HTML_FORMAT = "<html><body style=\"text-align: center; background-color: black; vertical-align: center;\"><img src = \"%s\" /></body></html>";	
        WebView   mWebView = (WebView) findViewById(R.id.webView);
        String html = String.format(HTML_FORMAT, url);
        mWebView.loadDataWithBaseURL("", html, "text/html", "UTF-8", "");
    	
    }
    
    public void showDescription(String description){
    	WebView appDescription=(WebView)findViewById(R.id.appDescription);
    	appDescription.loadData(description, "text/html; charset=UTF-8", null);
    }
    
    public void showRating(String rating){
    	float rt=Float.parseFloat(rating);
    	RatingBar appRating=(RatingBar) findViewById(R.id.ratingBar1);
    	appRating.setRating(rt);
//    	PushService.subscribe(this, "", MainActivity.class);
    }
    
    public void showDownloadLink(String appID){
    	Intent intent = new Intent(Intent.ACTION_VIEW);
    	intent.setData(Uri.parse("http://market.android.com/details?id="+appID));
    	startActivity(intent);
    }
    public void getListOfInstalledApps(){
        final PackageManager pm = getPackageManager();      
      Intent intent = new Intent(Intent.ACTION_MAIN, null);
      intent.addCategory(Intent.CATEGORY_LAUNCHER);       
              List<ApplicationInfo> packages = pm
                      .getInstalledApplications(PackageManager.GET_META_DATA);              
              for (ApplicationInfo packageInfo : packages) {
            	  String packageName=packageInfo.packageName;
                  Log.d("CMU Funnel", "Installed package :" + packageInfo.packageName);
//                  Log.d("My","Launch Activity :" + pm.getLaunchIntentForPackage(packageInfo.packageName)); 
              }	
    }

    public void parseJSON(){
    	String jsonStr="{user:{age:21,gender:Female}}";
    	try {
    	JSONObject jsonObj = new JSONObject(jsonStr);  
    	// grabbing the menu object 
    	JSONObject user = jsonObj.getJSONObject("user"); 
    	 
    	// these 2 are strings 
    	String age = user.getString("age"); 
    	String gender = user.getString("gender");
		System.out.print(age);
		Log.d("CMU Funnel", age);
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	 
    	
    }   

    
     
}
