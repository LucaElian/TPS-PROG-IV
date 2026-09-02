package ejercicio1;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.TreeSet;

public class MainEjercicio1_c {

	public static void main(String[] args) {
		Empleado e1 = new Empleado();
		
		Empleado e2 = new Empleado();
		e2.setDni("40123896");
		
		Empleado e3 = new Empleado("48749654", "Jose", "Correa",50,LocalDate.of(2008, 12, 8), "Masculino", "Vega 232", "11568922","jose@hisf","Carpintero");
		
		Empleado e4 = new Empleado();
		e4.setDni("25563802");

		Empleado e5 = new Empleado("10123896","Carla","Colombo",78,LocalDate.of(1952, 8, 22),"femenino","Recoleta 1520","11897488","carla@jkdkl","Profesora");
				
		TreeSet<Empleado> listaEmpleados = new TreeSet<Empleado>();
		
		listaEmpleados.add(e1);
		listaEmpleados.add(e2);
		listaEmpleados.add(e3);
		listaEmpleados.add(e4);
		listaEmpleados.add(e5);
		listaEmpleados.add(e5);
		
		Iterator<Empleado> it = listaEmpleados.iterator();
		
		while(it.hasNext()) {
			Empleado em = (Empleado) it.next();
			System.out.println(em.toString());
		}

	}

}
