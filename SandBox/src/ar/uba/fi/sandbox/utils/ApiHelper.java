package ar.uba.fi.sandbox.utils;

import com.loopj.android.http.*;
import ar.uba.fi.sandbox.Config;

public class ApiHelper {
	private AsyncHttpClient client;
	private static ApiHelper INSTANCE = null;
	
	private ApiHelper(){
		client = new AsyncHttpClient();
	};
	
	static public ApiHelper getInstance(){
		if(INSTANCE == null){
			INSTANCE =  new ApiHelper();
		}
		return
		INSTANCE;
	}
	
		
	public void search( RequestParams params,JsonHttpResponseHandler responseHandler){
		doPost(Config.BASEURL + Config.PUBLICACIONES_CONTROLLER + "search", responseHandler);
	} 
	
	public void getNeighborhoodsByCity(JsonHttpResponseHandler responseHandler){
		 getNeighborhoodsByCity(Config.CAPITAL_FEDERAL_ID,responseHandler);
	}

	public void getNeighborhoodsByCity(int city_id,JsonHttpResponseHandler responseHandler){
		RequestParams rq =  new RequestParams("city_id", city_id);
		doGet(Config.BASEURL + Config.BARRIOS_CONTROLLER + "get_by_city",rq,responseHandler);
	} 
	
	
	public void getBarrios(JsonHttpResponseHandler responseHandler){
		RequestParams rq =  new RequestParams("city_id", "sadasd");
		String url_prueba = "http://goodshiplollipop.com.ar/barrios.php";
		doGet(url_prueba,rq,responseHandler);
	}
	
	private void doGet(String url, JsonHttpResponseHandler responseHandler){
		doGet(url,null, responseHandler);
	}
	
	private void doPost(String url, JsonHttpResponseHandler responseHandler){
		doPost(url,null, responseHandler);
	}
	
	private void doGet(String url,RequestParams rq, JsonHttpResponseHandler responseHandler){
		String o = (String) Cache.getCachedObject(url);
		if(o != null){
			responseHandler.sendSuccessMessage(0, null,o.getBytes());
		}else{
			if(rq == null)
				client.get(url,responseHandler);
			else
				client.get(url, rq, responseHandler);
		}
	}
	
	private void doPost(String url,RequestParams rq, JsonHttpResponseHandler responseHandler){
		String o = (String) Cache.getCachedObject(url);
		if(o != null){
			responseHandler.sendSuccessMessage(0, null,o.getBytes());
		}else{
			if(rq == null)
				client.post(url,responseHandler);
			else
				client.post(url, rq, responseHandler);
		}
	}
}
