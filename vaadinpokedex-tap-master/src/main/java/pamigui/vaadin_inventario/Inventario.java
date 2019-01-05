package pamigui.vaadin_inventario;

import java.util.ArrayList;
import java.util.List;


public class Inventario {
	MetodoVisualizar metodoVisualizar;
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
		}
	}
	
	public void aniadirUno(Producto p)
	{
		int contadorUni=p.getUnidades();
		contadorUni++;
		p.setUnidades(contadorUni);
	}
	
	public List<Producto> getProducto() {
		return inventario;
	}
	public void modificarProducto(Producto p, String number, String name, int precio) 
	{
		p.setNumber(number);
		p.setName(name);
		p.setPrecio(precio);
	}
	/*
	public int buscarProducto(Producto p) {
		p.g
		ArrayList<Producto> productobuscado = new ArrayList<Producto>();
		for(int i=0; i<inventario.size();i++) {
			if((inventario.get(i).getName().contains(buscar))||
					(inventario.get(i).getNumber().contains(buscar))||
					(inventario.get(i).getType().contains(buscar)))
			{
				productobuscado.add(inventario.get(i));
				setMetodoVisualizar(new Lista());
				metodoVisualizar.visualizar(productobuscado);
			}
			
		}
		if(productobuscado.size()==0) {
			System.out.println("Vaya, no tienes este producto en el inventario");
		}
		
		return productobuscado;
	}
	
	
	/*public ArrayList<Producto> buscarProducto(String buscar) {
		ArrayList<Producto> productobuscado = new ArrayList<Producto>();
		for(int i=0; i<inventario.size();i++) {
			if((inventario.get(i).getName().contains(buscar))||
					(inventario.get(i).getNumber().contains(buscar))||
					(inventario.get(i).getType().contains(buscar)))
			{
				productobuscado.add(inventario.get(i));
				setMetodoVisualizar(new Lista());
				metodoVisualizar.visualizar(productobuscado);
			}
			
		}
		if(productobuscado.size()==0) {
			System.out.println("Vaya, no tienes este producto en el inventario");
		}
		
		return productobuscado;
	}*/
	public void setMetodoVisualizar(MetodoVisualizar metodoVisualizar) {
		this.metodoVisualizar = metodoVisualizar;
	}
	public void visualizar() {
		int cont=0;
		if(inventario.size()==0) {
			System.out.println("No hay productos en el inventario");
		}
		else {
			setMetodoVisualizar(new Lista());
			metodoVisualizar.visualizar(inventario);
			for (int i=0;i<inventario.size(); i++) {
				 cont=cont + inventario.get(i).getUnidades();
							

			}
				System.out.println("Número de unidades totales del inventario: "+ cont);
		}
	}
	/*
	public void modificarProducto(String nombre, String numero, String tipo, int unidades,int prod, ArrayList<Producto> auxiliar ) {
		//int a= agenda.indexOf(auxiliar.get(contacto));
 		int ID= inventario.indexOf(auxiliar.get(prod)); // con esto cogemos el indice del contacto del array auxiliar que coincide con el de agenda
 		// con auxiliar.get(contacto) obtenemos el contacto entero de ese índice=contacto del array auxiliar.
 		// con el agenda.indexOf cogemos el índice de ese contacto del array auxiliar que se encuentra en el array agenda.
 		
		if(nombre.length()>0) { // Si escribe algo por teclado, se cambia, si no escribe nada, no se cambia
			inventario.get(ID).setName(nombre);
		}
		if(numero.length()>0) {
			inventario.get(ID).setNumber(numero);
		}
		if(tipo.length()>0) {
			inventario.get(ID).setType(tipo);
		}
		inventario.get(ID).setUnidades(unidades);
		
		
	}*/
	


}
