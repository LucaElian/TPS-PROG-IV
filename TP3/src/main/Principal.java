package main;

import java.util.ArrayList;

import dao.DaoCategoria;
import entidad.Categoria;

public class Principal {

	public static void main(String[] args) {
		
		DaoCategoria daoCat = new DaoCategoria(); 
		
		ArrayList<Categoria> listCategorias = new ArrayList<>();
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(1);
		categoria.setNombre("Terror");
		categoria.setEstado(true);
		
		Categoria categoria2 = new Categoria(2,"Surrealismo",true); 
		Categoria categoria3 = new Categoria(3,"Infantil",true); 
		
		
		listCategorias.add(categoria); 
		listCategorias.add(categoria2); 
		listCategorias.add(categoria3); 
		
		for (Categoria cat : listCategorias) {

		    int filas = daoCat.altaCategoria(cat);

		    if (filas != 0) {
		        System.out.println("Categoría agregada correctamente");
		        System.out.println(cat.toString());
		        System.out.println(" ");
		    } else {
		        System.out.println("No se pudo agregar la categoría");
		    }
		}
		
		System.out.println("==============");
		
		//baja de objeto 
		
		int ok =  daoCat.bajaCategoria(categoria3.getIdCategoria()) ; 
		if(ok != 0 ) {
			categoria3.setEstado(false); 
			System.out.println("Categoria dada de baja");
			System.out.println(categoria3.toString());
		}else {
			System.out.println("No se pudo dar de baja");
		}
		
	
		

	}

}
