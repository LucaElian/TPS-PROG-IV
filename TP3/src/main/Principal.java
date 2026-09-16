package main;

import java.util.ArrayList;

import dao.DaoCategoria;
import entidad.Categoria;

public class Principal {

	public static void main(String[] args) {
		
		DaoCategoria daoC = new DaoCategoria(); 
		
		System.out.println("===== ABML CATEGORIAS =====");
		
		ArrayList<Categoria> listcat = new ArrayList<>();

		// ALTA CATEGORIA
		
		Categoria categoria1 = new Categoria("Terror");
		Categoria categoria2 = new Categoria("Surrealismo"); 
		Categoria categoria3 = new Categoria("Infantil"); 
		
		listcat.add(categoria1); 
		listcat.add(categoria2); 
		listcat.add(categoria3); 
		
		for (Categoria cat : listcat) {

		    int filas = daoC.altaCategoria(cat);

		    if (filas != 0) {
		        System.out.println("Categoría agregada correctamente");
		        System.out.println(cat.toString());
		        System.out.println();
		    } else {
		        System.out.println("No se pudo agregar la categoría");
		    }
		}
		
		System.out.println("\n==============\n");
		
		// BAJA CATEGORIA
		
		int ok =  daoC.bajaCategoria(3);
		
		if (ok != 0) {
			System.out.println("Categoria dada de baja");
			System.out.println(categoria3.toString());
		} else
			System.out.println("No se pudo dar de baja");
		
		System.out.println("\n==============\n");
		
		// MODIFICACION CATEGORIA
	}
}