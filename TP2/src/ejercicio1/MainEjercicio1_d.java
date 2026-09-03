package ejercicio1;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;

public class MainEjercicio1_d {

	public static void main(String[] args) {
		Persona p1 = new Persona("11111111", "Carlos", "Lopez", 30, LocalDate.of(1994, 5, 10), "Masculino", "Av. San Martin 123", "11223344", "carlos@mail.com");
		Persona p2 = new Persona("22222222", "Laura", "Diaz", 28, LocalDate.of(1996, 8, 15), "Femenino", "Belgrano 456", "22334455", "laura@mail.com");
		Persona p3 = new Persona("33333333", "Martin", "Gomez", 35, LocalDate.of(1989, 2, 20), "Masculino", "Mitre 789", "33445566", "martin@mail.com");
		Persona p4 = new Persona("44444444", "Sofia", "Rodriguez", 26, LocalDate.of(1998, 11, 5), "Femenino", "Rivadavia 1011", "44556677", "sofia@mail.com");
		Persona p5 = new Persona("55555555", "Lucas", "Fernandez", 40, LocalDate.of(1984, 4, 25), "Masculino", "Lavalle 1213", "55667788", "lucas@mail.com");

		HashSet<Persona> listaPersonas = new HashSet<Persona>();
		listaPersonas.add(p1);
		listaPersonas.add(p2);
		listaPersonas.add(p3);
		listaPersonas.add(p4);
		listaPersonas.add(p5);

		Iterator<Persona> it = listaPersonas.iterator();

		while (it.hasNext()) {
			Persona p = it.next();
			System.out.println(p.toString());
		}
	}
}
