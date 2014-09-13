package ar.uba.fi.sandbox;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import ar.uba.fi.sandbox.models.ResultadoPublicacion;
import ar.uba.fi.sandbox.utils.SearchViewAdapter;

public class SearchActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_view);
		
		  final ListView listview = (ListView) findViewById(R.id.results_list);
		    final ArrayList<ResultadoPublicacion> list = new ArrayList<ResultadoPublicacion>();
		    for (int i = 0; i < 25; ++i) {
		      list.add(new ResultadoPublicacion());
		    }
		    final SearchViewAdapter adapter = new SearchViewAdapter(this, list);
		    listview.setAdapter(adapter);

		  }

	
}
