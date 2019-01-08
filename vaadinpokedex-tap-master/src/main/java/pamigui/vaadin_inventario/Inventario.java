package pamigui.vaadin_inventario;

import java.util.ArrayList;
import java.util.List;


public class Inventario {
	private static Inventario singleton;
	private List<Producto> inventario;

	private Inventario() {
		super();
		inventario = new ArrayList<>();
	}
	
	public static Inventario getInstance() {
		
		if(singleton == null)
			singleton = new Inventario();
		
		return singleton;
	}
	
	public void addProducto(Producto p) {
		inventario.add(p);
		p.setPrecio_total(p.getUnidades(), p.getPrecio());
	}
	
	public void deleteProducto(Producto p, int prod)
	{
		inventario.remove(p);
	}
	
	public void deleteProductoUno(Producto p)
	{
		int contadorUni=p.getUnidades();
		if(contadorUni==1) {
			inventario.remove(p);
		}
		else if(contadorUni>1){
			contadorUni--;
			p.setUnidades(contadorUni);
			p.setPrecio_total(p.getUnidades(), p.getPrecio());
		}
	}
	
	public void aniadirUno(Producto p)
	{
		int contadorUni=p.getUnidades();
		contadorUni++;
		p.setUnidades(contadorUni);
		p.setPrecio_total(p.getUnidades(), p.getPrecio());
	}
	
	public List<Producto> getProducto() {
		return inventario;
	}
	public void modificarProducto(Producto p, String number, String name, double precio) 
	{
		p.setNumber(number);
		p.setName(name);
		p.setPrecio(precio);
		p.setPrecio_total(p.getUnidades(), precio);
	}
}
