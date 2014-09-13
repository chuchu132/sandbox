package ar.uba.fi.sandbox.utils;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import ar.uba.fi.sandbox.R;
import ar.uba.fi.sandbox.models.ResultadoPublicacion;

public class SearchViewAdapter extends ArrayAdapter<ResultadoPublicacion> {
  private final Context context;

  HashMap<ResultadoPublicacion, Integer> mIdMap = new HashMap<ResultadoPublicacion, Integer>();
  int[] images = {R.drawable.demo1,R.drawable.demo2,R.drawable.demo3,R.drawable.demo4,R.drawable.demo5};
  public SearchViewAdapter(Context context,List<ResultadoPublicacion> objects) {
  	super(context, R.layout.search_result_item, objects);
  	this.context = context;
    for (int i = 0; i < objects.size(); ++i) {
        mIdMap.put(objects.get(i), i);
     }
  }

  public View getView(int position, View rowView, ViewGroup parent) {
      LayoutInflater inflater = (LayoutInflater) context
          .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      if (rowView == null) {
      	rowView = inflater.inflate(R.layout.search_result_item, parent, false);
      }
      ImageView preview = (ImageView) rowView.findViewById(R.id.item_preview);
      preview.setImageResource(images[((position%5))]);
      
      TextView titulo = (TextView) rowView.findViewById(R.id.titulo_item);
      TextView subtitulo = (TextView) rowView.findViewById(R.id.subtitulo_item);
      String s = getItem(position).toString();
      
      titulo.setText(s);
      subtitulo.setText(s);
      return rowView;
    }
  

  public long getItemId(int position) {
    ResultadoPublicacion item = getItem(position);
    return mIdMap.get(item);
  }

  public boolean hasStableIds() {
    return true;
  }

} 