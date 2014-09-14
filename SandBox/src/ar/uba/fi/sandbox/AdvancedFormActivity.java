package ar.uba.fi.sandbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AdvancedFormActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_form);
		Button btnSearch =  (Button) findViewById(R.id.simple_search);
		btnSearch.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(AdvancedFormActivity.this,SearchActivity.class);
				AdvancedFormActivity.this.startActivity(i);
			}
		});
	}


}
