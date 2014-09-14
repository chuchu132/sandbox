package ar.uba.fi.sandbox.utils;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;

public class JsonCacheHttpResponseHandler extends JsonHttpResponseHandler {
	
	public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
		if(statusCode != 0){
			String url = getRequestURI().toString().substring(0, getRequestURI().toString().indexOf('?'));
			Log.e("JsonCache", "requestURI " + url);
			Cache.saveTo(url, response.toString());
		}
	}
	
	public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
		if(statusCode != 0){
			String url = getRequestURI().toString().substring(0, getRequestURI().toString().indexOf('?'));
			Log.e("JsonCache", "requestURI " + url);
			Cache.saveTo(url, response.toString());
		}
	}

}
