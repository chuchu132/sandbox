package ar.uba.fi.sandbox.models;

import java.util.HashMap;

import com.loopj.android.http.RequestParams;

public class SearchForm {
	
	private static HashMap<FormField, Object> form =  getDefaults();
	
	public static Object getField(FormField field){
		return form.get(field);
	}
	
	public static void setField(FormField field,Object value){
		form.put(field, value);
	}
	
	public static void setField(FormField field,int value){
		form.put(field,Integer.valueOf(value));
	}
	
	public static RequestParams getAsRequestParams(){
		RequestParams rp = new RequestParams();
		for (FormField key : form.keySet()) {
			rp.put(key.toString(),form.get(key.toString()));
		}
		return rp;
	}
	
	public static void clearForm(){
		form.clear();
	}
	
	private static HashMap<FormField, Object> getDefaults(){
		 HashMap<FormField, Object> tmp = new HashMap<FormField, Object>();
		 tmp.put(FormField.ZONAS_ALEDANAS, false);
		 return tmp;
	}
	
   
	
}
