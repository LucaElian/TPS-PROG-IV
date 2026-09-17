package main;

import java.util.ArrayList;

import dao.DaoCategoria;
import dao.DaoProducto;
import entidad.Categoria;
import entidad.Producto;

public class Principal {

	public static void main(String[] args) {
		DaoCategoria daoC = new DaoCategoria();
		DaoProducto daoP = new DaoProducto();

		
		System.out.println("===== ABML CATEGORIAS =====");
		
		ArrayList<Categoria> listcat = new ArrayList<>();

		// ALTA CATEGORIA
		
		listcat.add(new Categoria("Terror")); 
		listcat.add(new Categoria("Surrealismo")); 
		listcat.add(new Categoria("Infantil")); 
		
		for (Categoria cat : listcat) {
		    if (daoC.altaCategoria(cat) != 0)
		    	System.out.println("Se agrego la categoria: " + cat.getNombre());
		    else
		        System.out.println("No se pudo agregar la categoría: " + cat.getNombre());
		}

		
		// BAJA CATEGORIA
		
		if (daoC.bajaCategoria(2) != 0)
			System.out.println("Categoria " + listcat.get(1).getNombre() + " dada de baja");
		else
			System.out.println("No se pudo dar de baja la categoria");
		
		
		System.out.println("\n==============\n");
		
		
		// MODIFICACION CATEGORIA
		
		Categoria catMod = new Categoria(2, "Accion", true);
		
		if (daoC.modificarCategoria(catMod) != 0) 
			System.out.println("Se modifico la categoria " + catMod.getIdCategoria());
		else
			System.out.println("No se pudo modificar la categoria");
		
		
		System.out.println("\n==============\n");
		
		
		// LISTAR CATEGORIA
		
		for (Categoria c : daoC.listaCategorias())
		    System.out.println("[" + c + "]");
 		
	
		System.out.println("\n===== ABML PRODUCTOS =====\n");
		
		ArrayList<Producto> listpro = new ArrayList<>();
		
		// ALTA PRODUCTO
	
		listpro.add(new Producto("AA11", "It", 35000, 5, 1));
		listpro.add(new Producto("AB12", "Duro de matar", 25000, 20, 2));
		listpro.add(new Producto("AC13", "Toy Story", 15000, 8, 3));
		listpro.add(new Producto("AD14", "El exorcista", 45000, 10, 1));
		listpro.add(new Producto("AE15", "El mago de Oz", 30000, 12, 3));
		listpro.add(new Producto("AF16", "El gigante de hierro", 30000, 12, 3));
		
		for (Producto pro : listpro) {
			if (daoP.sp_AgregarProducto(pro) != 0)
				System.out.println("Se agrego el producto: " + pro.getNombre());
			else	
				System.out.println("No se pudo agregar el producto: " + pro.getNombre());
		}

		
		System.out.println("\n==============\n");
		
		
		// BAJA PRODUCTO
		
		if (daoP.bajaProducto("AF16") != 0) {
			System.out.println("Producto " + listpro.get(5).getNombre() + " dado de baja");
		} else
			System.out.println("No se pudo dar de baja el producto");
	
		
		System.out.println("\n==============\n");
		
		
		// MODIFICACION PRODUCTO
		
		Producto proMod = new Producto("AC13", "Toy Story 2", 30000, 12, 2, true);
		
		if (daoP.modificarProducto(proMod) != 0) 
			System.out.println("Se modifico el producto " + proMod.getCodigo());
		else
			System.out.println("No se pudo modificar el producto");
		
		
		System.out.println("\n==============\n");
	
		
		// LISTAR PRODUCTO
		
		for (Producto p : daoP.listarProductos())
		    System.out.println(p);
		
		
		System.out.println("\n==============\n");
		
		
		// ALTA PRODUCTO CON PROCEDIMIENTO ALMACENADO
		
		
	}
}