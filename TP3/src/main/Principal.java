package main;

import java.util.ArrayList;

import dao.DaoCategoria;
import dao.DaoProducto;
import entidad.Categoria;
import entidad.Producto;

public class Principal {

	public static void main(String[] args) {
		
		DaoCategoria daoC = new DaoCategoria();
/*		
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
		
	
		categoria3.setIdCategoria(3);
		// BAJA CATEGORIA
			
		int ok =  daoC.bajaCategoria(3);
		
		if (ok != 0) {
			System.out.println("Categoria dada de baja");
			System.out.println(categoria3.toString());
		} else
			System.out.println("No se pudo dar de baja");
		
		System.out.println("\n==============\n");
		
		// MODIFICACION CATEGORIA
		categoria3.setEstado(true);
		ok = daoC.modificarCategoria(categoria3);
		if ( ok == 1) 
			System.out.println(" Se modifico la categoria");
		else
			System.out.println(" No se pudo modificar la categoria");
		
		//LISTAR
		ArrayList<Categoria> listaDesdeBD = daoC.listaCategorias();
		for (Categoria c : listaDesdeBD) {
		    System.out.println(c);
		}
 */		
	
		System.out.println("===== ABML PRODUCTOS =====");
		
		DaoProducto daoP = new DaoProducto();
		
		ArrayList<Producto> listProductos = new ArrayList<>();
		
		Producto p1 = new Producto("aa11","Juego de mesa", 35000, 5, 1);
		Producto p2 = new Producto("ab12", "Libro", 25000, 20, 2);
		Producto p3 = new Producto("ac13", "Almanaque", 15000, 8, 3);
		Producto p4 = new Producto("ad14", "Novela", 45000, 10, 1);
		Producto p5 = new Producto("ae15", "Cuento", 30000, 12, 3);
		Producto p6 = new Producto("af16", "Almanaque", 30000, 12, 3);
				

		listProductos.add(p1);
		listProductos.add(p2);
		listProductos.add(p3);
		listProductos.add(p4);
		listProductos.add(p5);
		listProductos.add(p6);
		
		for( Producto producto : listProductos) {
			
			int filas = daoP.sp_AgregarProducto(producto);
			
			if ( filas > 0 ) {
				
				System.out.println("Se agregó correctamente el producto: " + producto.getNombre());
			}else {
				System.out.println("No se pudo agregar el producto: " + producto.getNombre());
			}
		
		}
		
		System.out.println("-----------------------");
		
		System.out.println("Baja del producto con codigo af16");
		
		// Baja de un Producto
		
		int bajaOk = daoP.bajaProducto("af16");
		
		if (bajaOk != 0) {
			System.out.println("Producto dado de baja.");
		} else
			System.out.println("No se pudo dar de baja el producto.");
	
	
	}
}