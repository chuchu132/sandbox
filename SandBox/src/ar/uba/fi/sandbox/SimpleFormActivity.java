package ar.uba.fi.sandbox;

import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Spinner;
import ar.uba.fi.sandbox.models.FormField;
import ar.uba.fi.sandbox.models.SearchForm;
import ar.uba.fi.sandbox.utils.ApiHelper;
import ar.uba.fi.sandbox.utils.JsonCacheHttpResponseHandler;
import ar.uba.fi.sandbox.utils.OperationTypeSpinnerAdapter;
import ar.uba.fi.sandbox.utils.PropertyTypeSpinnerAdapter;
import ar.uba.fi.sandbox.utils.SpinnerAdapter;

public class SimpleFormActivity extends Activity {
	
	Spinner neighborhoodsSpinner = null;
	Spinner operationtypeSpinner = null;
	Spinner propertyTypeSpinner = null;
	CheckBox includeNeighborsCheck = null;
	Button btnSearch  = null;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_form);
		neighborhoodsSpinner = (Spinner) findViewById(R.id.neighborhood);
		operationtypeSpinner = (Spinner) findViewById(R.id.operation_type);
		propertyTypeSpinner = (Spinner) findViewById(R.id.property_type);
		includeNeighborsCheck = (CheckBox) findViewById(R.id.include_neighbors);
		btnSearch =  (Button) findViewById(R.id.simple_search);
		btnSearch.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(SimpleFormActivity.this,SearchActivity.class);
				SimpleFormActivity.this.startActivity(i);
			}
		});
		
		setListeners();
	}
	
	
	protected void onResume() {
		super.onResume();
		neighborhoodsSpinner.setEnabled(false);
		btnSearch.setEnabled(false);
		initForm();
	}
	
	@SuppressWarnings("unchecked")
	private void initForm(){
		
		operationtypeSpinner.setAdapter(new OperationTypeSpinnerAdapter(this));
		propertyTypeSpinner.setAdapter(new PropertyTypeSpinnerAdapter(this));
		
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
				 neighborhoodsSpinner.setAdapter(adapter);
				 neighborhoodsSpinner.setEnabled(true);
				 btnSearch.setEnabled(true);
			}
		});
		
		ArrayAdapter<SimpleEntry<String, String>> adapter = (ArrayAdapter<SimpleEntry<String, String>>)propertyTypeSpinner.getAdapter();
		if(SearchForm.getField(FormField.TIPO_INMUEBLE) != null ){
			int position =adapter.getPosition(new SimpleEntry<String, String>((String)SearchForm.getField(FormField.TIPO_INMUEBLE),null));
			propertyTypeSpinner.setSelection(position);
		}
		
		adapter = (ArrayAdapter<SimpleEntry<String, String>>)operationtypeSpinner.getAdapter();
		if(SearchForm.getField(FormField.TIPO_OPERACION) != null ){
			int position =adapter.getPosition(new SimpleEntry<String, String>((String)SearchForm.getField(FormField.TIPO_OPERACION),null));
			operationtypeSpinner.setSelection(position);
		}
		
		includeNeighborsCheck.setChecked((Boolean)SearchForm.getField(FormField.ZONAS_ALEDANAS));
	}
	
	private void setListeners(){
		
		operationtypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1,
                    int arg2, long arg3) {
            	Object item = operationtypeSpinner.getSelectedItem();
            	if( item instanceof SimpleEntry<?, ?>){
            		Object value = (( SimpleEntry<?, ?>)item).getKey();
            		SearchForm.setField(FormField.TIPO_OPERACION, value);
            	}

            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
		
		propertyTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1,
                    int arg2, long arg3) {
            	Object item = propertyTypeSpinner.getSelectedItem();
            	if( item instanceof SimpleEntry<?, ?>){
            		Object value = (( SimpleEntry<?, ?>)item).getKey();
            		SearchForm.setField(FormField.TIPO_INMUEBLE, value);
            	}

            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
		
		includeNeighborsCheck.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton arg0, boolean checked) {
				SearchForm.setField(FormField.ZONAS_ALEDANAS, checked);		
			}
		});
		
	}


}
