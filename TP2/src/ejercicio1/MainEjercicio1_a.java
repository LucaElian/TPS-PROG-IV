package ejercicio1;

public class MainEjercicio1_a {

	public static void main(String[] args) {
		
		Persona persona = new Persona(); 
		
		try {
			persona.setDni("AA202020");
			Persona.exVerificarDNI(persona.getDni());
			
		} catch (ExVerificarDNI e) {
			System.out.println(e.getMessage());
		}
	}

}
