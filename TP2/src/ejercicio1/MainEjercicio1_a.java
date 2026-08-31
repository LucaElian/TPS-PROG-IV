package ejercicio1;

public class MainEjercicio1_a {

	public static void main(String[] args) {
			
		Persona persona1 = new Persona(); 
		
		try {
			persona1.setDni("AA202020");
			
			Persona.exVerificarDNI(persona1.getDni());
			
			System.out.println("Persona agregada correctamente.");

		} catch (ExVerificarDNI e) {
			System.out.println(e.getMessage());
		}
		
		Persona persona2 = new Persona();
		
		try {
			persona2.setDni("20202020");
			
			Persona.exVerificarDNI(persona2.getDni());
			
			System.out.println("Persona agregada correctamente.");
			
		} catch (ExVerificarDNI e) {
			System.out.println(e.getMessage());
		}
	}
}