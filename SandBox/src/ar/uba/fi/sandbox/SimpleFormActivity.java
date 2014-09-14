package ar.uba.fi.sandbox;

import java.util.ArrayList;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import ar.uba.fi.sandbox.utils.ApiHelper;
import ar.uba.fi.sandbox.utils.JsonCacheHttpResponseHandler;
import ar.uba.fi.sandbox.utils.SpinnerAdapter;

public class SimpleFormActivity extends Activity {
	
	Spinner barrios = null; 
	Button btnSearch  = null;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_form);
		barrios = (Spinner) findViewById(R.id.barrios);
		btnSearch =  (Button) findViewById(R.id.simple_search);
		btnSearch.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(SimpleFormActivity.this,SearchActivity.class);
				SimpleFormActivity.this.startActivity(i);
			}
		});
		
	
	}
	
	
	protected void onResume() {
		super.onResume();
		barrios.setEnabled(false);
		btnSearch.setEnabled(false);
		setNeighborhoodsByCity();
	}
	
	private void setNeighborhoodsByCity(){
		
		ApiHelper.getInstance().getBarrios(new JsonCacheHttpResponseHandler(){
			public void onSuccess(int statusCode, Header[] headers,	JSONArray response) {
				super.onSuccess(statusCode, headers, response);
				
				ArrayList<String> options=new ArrayList<String>();
				for (int i = 0; i < response.length(); i++) {
					try {
						options.add(response.getString(i));
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				 ArrayAdapter<String> adapter = new SpinnerAdapter(SimpleFormActivity.this,android.R.layout.simple_spinner_item,options);
				 barrios.setAdapter(adapter);
				 barrios.setEnabled(true);
				 btnSearch.setEnabled(true);
			}
		});
	}


}
