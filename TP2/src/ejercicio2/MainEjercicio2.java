package ejercicio2;

import java.util.ArrayList;
import java.util.Iterator;

public class MainEjercicio2 {
	
	public static void main(String[] args) {
		Polideportivo p1 = new Polideportivo(300.5, "Lionel Messi", 1);
		Polideportivo p2 = new Polideportivo(103.8, "River", 2);
		Polideportivo p3 = new Polideportivo(650, "Bombonera", 2);
		
		EdificioDeOficinas edO1 = new EdificioDeOficinas();
		EdificioDeOficinas edO2 = new EdificioDeOficinas(254.6, 15);
		
		
		ArrayList<Edificio> listaE = new ArrayList<Edificio>();
		listaE.add(p1);
		listaE.add(p2);
		listaE.add(p3);
		listaE.add(edO1);
		listaE.add(edO2);
		
		Iterator<Edificio> it = listaE.iterator();
		
		while (it.hasNext()) {
			Edificio e = it.next();
			
			System.out.println(e.toString());
		}
	}
}
