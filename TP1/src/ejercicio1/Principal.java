package ejercicio1;

import java.time.LocalDate;

public class Principal {

	public static void main(String[] args) {

		Empleado e1 = new Empleado("12345678", "Juan", "Perez", 32, LocalDate.of(1994, 8, 20), "Masculino",
				"Calle pública 123", "4881383", "juanperez@mail.com", "Operario");
		Empleado e2 = new Empleado("87654321", "Maria", "Lopez", 50, LocalDate.of(1976, 3, 12), "Femenino",
				"Pueyrredon 35", "654983", "lopez.maria@mail.com", "Gerente");
		Empleado e3 = new Empleado("32145687", "Pablo", "Diaz", 18, LocalDate.of(2004, 1, 24), "Masculino",
				"Av. Libertador 1500", "3654123", "paulitodiaz@mail.com", "Pasante");
	}

}
