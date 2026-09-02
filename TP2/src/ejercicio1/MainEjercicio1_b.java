package ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;

public class MainEjercicio1_b {

	public static void main(String[] args) {
		Empleado e1 = new Empleado();
		e1.setDni("12345678");

		Empleado e2 = new Empleado();
		e2.setDni("23456789");

		Empleado e3 = new Empleado();
		e3.setDni("34567891");

		Empleado e4 = new Empleado();
		e4.setDni("45678912");

		Empleado e5 = new Empleado();
		e5.setDni("56789123");

		ArrayList<Empleado> listaE = new ArrayList<Empleado>(5);
		listaE.add(e1);
		listaE.add(e2);
		listaE.add(e3);
		listaE.add(e4);
		listaE.add(e5);

		Iterator<Empleado> itE = listaE.iterator();

		while (itE.hasNext()) {
			Empleado e = itE.next();
			
			System.out.println(e.toString());
			System.out.println("\n");
		}
	}
}