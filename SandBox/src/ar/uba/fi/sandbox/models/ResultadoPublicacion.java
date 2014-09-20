package ar.uba.fi.sandbox.models;

import java.util.Random;

import org.json.JSONException;
import org.json.JSONObject;



public class ResultadoPublicacion {
	
	int altura;
	JSONObject publicacion = null;
	public ResultadoPublicacion(){
		
		Random r=new Random();
		altura = (r.nextInt(1000));
		String json = "{\"id\":\""+altura+"\", \"direccion\":\""+toString()+"\"}";
		try {
			publicacion = new JSONObject(json);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public String toString() {
			return "Calle Falsa " + altura;
	}

}
