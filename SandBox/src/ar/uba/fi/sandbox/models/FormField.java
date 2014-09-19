package ar.uba.fi.sandbox.models;

import java.util.HashMap;
import java.util.Map;

public enum FormField {
    TIPO_OPERACION("operacion"),
    TIPO_INMUEBLE("inmueble"),
    BARRIO("barrio"),
    ZONAS_ALEDANAS("con_zonas"),
    PRECIO("precio"),
    MONEDA("moneda"),
    SUP_TOTAL("sup_total"),
    SUP_CUBIERTA("sup_cubierta"),
    AMBIENTES("ambientes"),
    EXPENSAS("expensas"),
    ANTIGUEDAD("antiguedad"),
    A_ESTRENAR("a_estrenar")
    
    ;
    

    private final String text;

    private static final Map<String, FormField> STRING_TO_ENUM = new HashMap<String, FormField>();

    static {
        for (FormField field : FormField.values()) {
            STRING_TO_ENUM.put(field.text, field);
        }
    }
    
    private FormField(final String text) {
        this.text = text;
    }
   
    public String toString() {
    	
        return text;
    }
    
    public static FormField getByName(String name){
    	  return STRING_TO_ENUM.get(name);
    }
    
}