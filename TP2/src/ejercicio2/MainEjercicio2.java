package ejercicio2;

import java.util.ArrayList;
import java.util.Iterator;
public class MainEjercicio2 {
	
	public static void main(String[] args) {
		
		ArrayList<Edificio> listaEdificios = new ArrayList<Edificio>();
		
		Polideportivo p1 = new Polideportivo(300.5, "Lionel Messi", 1);
		Polideportivo p2 = new Polideportivo(103.8, "River", 2);
		Polideportivo p3 = new Polideportivo(650, "Bombonera", 2);
		EdificioDeOficinas edO1 = new EdificioDeOficinas();
		EdificioDeOficinas edO2 = new EdificioDeOficinas(254.6, 15);
		
		
		listaEdificios.add(p1);
		listaEdificios.add(p2);
		listaEdificios.add(p3);
		listaEdificios.add(edO1);
		listaEdificios.add(edO2);
		Iterator<Edificio> it = listaEdificios.iterator();
		while (it.hasNext()) {
			Edificio edificio = it.next();
			System.out.println(edificio);
			System.out.println("Superficie obtenida: " + edificio.getSuperficieEdificio());
			System.out.println("------------------------------------------------------------");
		}
		
		
	}

}
