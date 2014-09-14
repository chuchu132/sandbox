package ar.uba.fi.sandbox.utils;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import ar.uba.fi.sandbox.R;

public class SpinnerAdapter extends ArrayAdapter<String>{
	
    public SpinnerAdapter(Context context, int textViewResourceId,   ArrayList<String> options) {
        super(context, textViewResourceId,  options);
    }

    public View getDropDownView(int position, View convertView,ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {
    	if(convertView == null){
      	  	LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        convertView = inflater.inflate(R.layout.row, parent, false);
    	}
        TextView label=(TextView)convertView.findViewById(R.id.opcion);
        label.setText(getItem(position));
        return convertView;
    }
    
}