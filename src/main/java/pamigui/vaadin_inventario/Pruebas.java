/*package pamigui.vaadin_inventario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

//import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class Pruebas {

	@Test
	public void aniadirProducto() {
		Inventario inventario= Inventario.getInstance();
		inventario.vaciar();
		inventario.addProducto(new Producto("a","a"));		
		Assert.assertEquals(inventario.getProducto().size(), 1);
	}
	@Test
	public void eliminarProducto() {
		Inventario inventario= Inventario.getInstance();
		inventario.vaciar();
		Producto producto=new Producto("1","Panizza2");
		inventario.addProducto(producto);
		inventario.deleteProducto(producto);
		Assert.assertEquals(inventario.getProducto().size(),0);
	}
	@Test
	public void eliminarProductoUno() {
		Inventario inventario= Inventario.getInstance();
		inventario.vaciar();
		Producto producto=new Producto("1","Panizza2",1,2);
		inventario.addProducto(producto);
		inventario.deleteProductoUno(producto);
		
		Assert.assertEquals(producto.getUnidades(),1);
		inventario.deleteProductoUno(producto);
		Assert.assertEquals(inventario.getProducto().size(),0);
	}
	@Test
	public void aniadirUnProductoUno() {
		
		Inventario inventario= Inventario.getInstance();
		inventario.vaciar();
		Producto producto=new Producto("1","Panizza2",1,1);
		inventario.addProducto(producto);
		inventario.aniadirUno(producto);
		Assert.assertEquals(producto.getUnidades(),2);
		
	}
	/*
	@Test
	public void modificarProducto() {
		Inventario inventario= Inventario.getInstance();
		Producto producto=new Producto("1","Panizza2",1,1);
		inventario.addProducto(producto);
		ArrayList<Producto> auxiliar = inventario.buscarProducto("Pepe2");
		inventario.modificarProducto(auxiliar, "Juan", "Panizza2", 1.0);
		int busc= inventario.buscarProducto("Eustaquio").size();

		Assert.assertEquals(a, 1);
		
	}
	*//*
}
*/