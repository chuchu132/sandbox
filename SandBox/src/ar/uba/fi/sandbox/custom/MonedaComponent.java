package ar.uba.fi.sandbox.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RadioButton;
import ar.uba.fi.sandbox.R;
import ar.uba.fi.sandbox.models.FormField;

public class MonedaComponent extends CustomFormComponentBase {

	RadioButton peso = null;
	RadioButton dolar = null;
	
	public MonedaComponent(Context context, AttributeSet attrs) {
		super(context,attrs);
		if(!isInEditMode())
			initComponents(context);
	}
	public MonedaComponent(Context context){
		this(context,null);
	}
	
	@Override
	public void onEnabledChange(boolean enabled) {
		peso.setEnabled(enabled);
		dolar.setEnabled(enabled);
	}

	@Override
	public Object getValue() {
		return (peso.isChecked())?"ARS":"USD";
	}
	
	
	private void initComponents(Context context){
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.monedas_layout,getContainer(),true);
		setName(FormField.MONEDA);
		setLabel(getContext().getString(R.string.moneda));
		peso = (RadioButton) getContainer().findViewById(R.id.peso);
		dolar = (RadioButton) getContainer().findViewById(R.id.dolar);
	}

	
}
