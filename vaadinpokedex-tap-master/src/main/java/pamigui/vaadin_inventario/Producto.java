package pamigui.vaadin_inventario;

public class Producto {

	private String name;
	private String number;
	private int precio;
	private int unidades;
	
	public Producto(String name, String number) {
		super();
		this.name = name;
		this.number = number;
	}
	public Producto(String number, String name, int precio, int unidades) {
		super();
		this.name = name;
		this.number = number;
		this.precio = precio;
		this.unidades=unidades;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
	
}
