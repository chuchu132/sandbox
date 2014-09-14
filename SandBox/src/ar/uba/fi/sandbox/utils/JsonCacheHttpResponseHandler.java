package ar.uba.fi.sandbox.utils;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;

public class JsonCacheHttpResponseHandler extends JsonHttpResponseHandler {
	
	public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
		if(statusCode != 0){
			Log.e("JsonCache", "requestURI " +getRequestURI().toString());
			Cache.saveTo(getRequestURI().toString(), response.toString());
		}
	}
	
	public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
		if(statusCode != 0){
			Log.e("JsonCache", "requestURI " +getRequestURI().toString());
			Cache.saveTo(getRequestURI().toString(), response.toString());
		}
	}

}
