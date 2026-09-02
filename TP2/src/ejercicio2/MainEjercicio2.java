package ejercicio2;

import java.util.ArrayList;

public class MainEjercicio2 {
	
	public static void main(String[] args) {
		
		Polideportivo p1 = new Polideportivo(300.5, "Lionel Messi", 1);
		Polideportivo p2 = new Polideportivo(103.8, "River", 2);
		Polideportivo p3 = new Polideportivo(650, "Bombonera", 2);
		
		ArrayList<Edificio> listaEdificios = new ArrayList<Edificio>();
		
		listaEdificios.add(p1);
		listaEdificios.add(p2);
		listaEdificios.add(p3);
		
		
	}

}
