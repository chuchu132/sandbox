package ar.uba.fi.sandbox.models;

public enum FormField {
    TIPO_OPERACION("operacion"),
    TIPO_INMUEBLE("inmueble"),
    BARRIO("barrio"),
    ZONAS_ALEDANAS("con_zonas")
    ;

    private final String text;

    private FormField(final String text) {
        this.text = text;
    }
   
    public String toString() {
        return text;
    }
}