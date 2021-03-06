package pamigui.vaadin_inventario;

public class Producto {

	private String name;
	private String number;
	private double precio;
	private double precio_total;
	private int unidades;
	private int fecha;
	
	public int getFecha() {
		return fecha;
	}
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}
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
		setPrecio_total(unidades, this.precio);
		this.unidades = unidades;
	}
	public String getName() {
		return name.toUpperCase();
	}
	public void setName(String name) {
		this.name = name.toUpperCase();
	}
	public String getNumber() {
		return number.toUpperCase();
	}
	public void setNumber(String number) {
		this.number = number.toUpperCase();
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
