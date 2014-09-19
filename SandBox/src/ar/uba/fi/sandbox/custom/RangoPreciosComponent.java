package ar.uba.fi.sandbox.custom;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import ar.uba.fi.sandbox.R;
import ar.uba.fi.sandbox.models.FormField;

public class RangoPreciosComponent extends CustomFormComponentBase {
	EditText desde = null;
	EditText hasta = null;
	
	public RangoPreciosComponent(Context context) {
		this(context,null);
	}

	public RangoPreciosComponent(Context context, AttributeSet attrs) {
		super(context,attrs);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.rango_precios_layout,getContainer(),true);
		if(!isInEditMode())
			initComponents();
	}
	
	
	@Override
	public void onEnabledChange(boolean enabled) {
		desde.setEnabled(enabled);
		hasta.setEnabled(enabled);
	}

	@Override
	public Object getValue() {
		ArrayList<String> precios =  new ArrayList<String>();
		precios.add(desde.getText().toString());
		precios.add(hasta.getText().toString());
		return precios;
	}
	
	
	private void initComponents(){
		setName(FormField.PRECIO);
		setLabel(getContext().getString(R.string.precio));
		desde = (EditText) getContainer().findViewById(R.id.desde);
		hasta = (EditText) getContainer().findViewById(R.id.hasta);
	}
	

}
