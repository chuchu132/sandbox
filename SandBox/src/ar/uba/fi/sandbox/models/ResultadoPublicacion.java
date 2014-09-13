package ar.uba.fi.sandbox.models;

import java.util.Random;



public class ResultadoPublicacion {
	
	int altura;
	
	public ResultadoPublicacion(){
		Random r=new Random();
		altura = (r.nextInt(1000));
	}
	
	public String toString() {
			return "Calle Falsa " + altura;
	}

}
