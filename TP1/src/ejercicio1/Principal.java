package ejercicio1;

import java.time.LocalDate;

public class Principal {

	public static void main(String[] args) {

		Empleado e1 = new Empleado("12345678", "Juan", "Perez", 32, LocalDate.of(1994, 8, 20), "Masculino",
				"Calle pública 123", "4881383", "juanperez@mail.com", "Operario");
		
		Empleado e2 = new Empleado("87654321", "Maria", "Lopez", 50, LocalDate.of(1976, 3, 12), "Femenino",
				"Pueyrredon 35", "654983", "lopez.maria@mail.com", "Gerente");
		
		Empleado e3 = new Empleado();
		e3.setDni("32145687");
		e3.setNombre("Pablo");
		e3.setApellido("Diaz");
		e3.setEdad(22);
		e3.setFechaNacimiento(LocalDate.of(2004, 1, 24));
		e3.setGenero("Masculino");
		e3.setDireccion("Av. Libertador 1500");
		e3.setTelefono("3654123");
		e3.setEmail("paulitodiaz@mail.com");
		e3.setPuesto("Pasante");
		
		Empleado e4 = new Empleado();
		e4.setDni("45678912");
		e4.setNombre("Lucia");
		e4.setApellido("Gomez");
		e4.setEdad(28);
		e4.setFechaNacimiento(LocalDate.of(1998, 5, 10));
		e4.setGenero("Femenino");
		e4.setDireccion("San Martin 450");
		e4.setTelefono("4567890");
		e4.setEmail("lucia@mail.com");
		e4.setPuesto("Administrativa");
		
		Empleado e5 = new Empleado();
		
		System.out.println(e1.toString());
		System.out.println("\n");
		System.out.println(e2.toString());
		System.out.println("\n");
		System.out.println(e3.toString());
		System.out.println("\n");
		System.out.println(e4.toString());
		System.out.println("\n");
		System.out.println(e5.toString());
		System.out.println("\n");
		
		System.out.println("El próximo legajo será " + Empleado.devuelveProximoLegajo());
	}
}
