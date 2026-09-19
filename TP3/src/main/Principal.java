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
		
		int filasP = daoP.vaciarProductos();
		int filasC = daoC.vaciarCategorias();
		
		//Metodos para vaciar las tablas de categorias y productos en la base de datos.
		
		if (filasP > 0) {
		    System.out.println("Se eliminaron los productos");
		} else if (filasP == 0) {
		    System.out.println("No habia productos para eliminar");
		} else {
		    System.out.println("Error al eliminar los productos");
		}
		
		if (filasC > 0) {
		    System.out.println("Se eliminaron las categorias");
		} else if (filasC == 0) {
		    System.out.println("No habia categorias para eliminar");
		} else {
		    System.out.println("Error al eliminar las categorias");
		}
		
		System.out.println("===== ABML CATEGORIAS =====");
		
		ArrayList<Categoria> listcat = new ArrayList<>();

		// ALTA CATEGORIA
		
		listcat.add(new Categoria("Terror")); 
		listcat.add(new Categoria("Surrealista")); 
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
		
		System.out.println("\n==============\n");
		

		// ALTA PRODUCTO 
		
		System.out.println("\n Alta de producto\n");
		
		ArrayList<Producto> listpro = new ArrayList<>();
		
		listpro.add(new Producto("AG01", "Rambo", 25000, 15, 2));
		listpro.add(new Producto("AH02", "Alien", 35000, 25, 1));
		listpro.add(new Producto("AI03", "Cars", 45000, 18, 3));
		listpro.add(new Producto("AJ04", "Bad Boys", 30000, 10, 2));
		listpro.add(new Producto("AK05", "Shrek", 20000, 15, 1));

		for (Producto pro : listpro) {
			if (daoP.altaProducto(pro) > 0)
				System.out.println("Se agrego el producto: " + pro.getNombre());
			else	
				System.out.println("No se pudo agregar el producto: " + pro.getNombre());
		}
		
		for (Producto p : daoP.listarProductos())
		    System.out.println(p);
		

		
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
		
		System.out.println("\n Alta de 10 productos con procedimiento almacenado \n");
		ArrayList<Producto> listproSP = new ArrayList<>();
		
		listproSP.add(new Producto("AA11", "It", 35000, 5, 1));
		listproSP.add(new Producto("AB12", "Duro de matar", 25000, 20, 2));
		listproSP.add(new Producto("AC13", "Toy Story", 15000, 8, 3));
		listproSP.add(new Producto("AD14", "El exorcista", 45000, 10, 1));
		listproSP.add(new Producto("AE15", "El mago de Oz", 30000, 12, 3));
		listproSP.add(new Producto("AF16", "El gigante de hierro", 30000, 12, 3));
		listproSP.add(new Producto("BA16", "Arma mortal 2", 10000, 20, 2));
		listproSP.add(new Producto("FA16", "El legado del diablo", 30000, 18, 1));
		listproSP.add(new Producto("OL16", "Rapunsel", 31000, 12, 3));
		listproSP.add(new Producto("WQ16", "El gato con botas", 11000, 9, 3));
		
		for (Producto pro : listproSP) {
			if (daoP.sp_AgregarProducto(pro) > 0)
				System.out.println("Se agrego el producto: " + pro.getNombre());
			else	
				System.out.println("No se pudo agregar el producto: " + pro.getNombre());
		}

		for (Producto p : daoP.listarProductos())
		    System.out.println(p);
	}
}