package pamigui.vaadin_inventario;

public class Producto {

	private String name;
	private String number;
	private double precio;
	private double precio_total;
	private int unidades;
	
	public Producto(String name, String number) {
		super();
		this.name = name;
		this.number = number;
	}
	public Producto(String number, String name, double precio, int unidades) {
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
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getPrecio_total() {
		return precio_total;
	}
	public void setPrecio_total(int unidades, double precio) {
		this.precio_total = precio * unidades;
	}
	
	
	
}
