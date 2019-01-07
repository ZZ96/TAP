package pamigui.vaadin_inventario;

import java.util.ArrayList;
import java.util.Scanner;





public class Menu {

	public Menu() {
		// TODO Auto-generated constructor stub
	}
	public void MenuInventario() {
		
		Inventario inv= Inventario.getInstance();// singleton
		int entradaTeclado = 100;
		System.out.println(" ESTE ES TU INVENTARIO");

		while(entradaTeclado!=6) {
			System.out.println("1. Añadir producto");
			System.out.println("2. Eliminar producto");
			System.out.println("3. Buscar producto");
			System.out.println("4. Modificar producto");
			System.out.println("5. Visualizar inventario");
			System.out.println("6. Salir");
			System.out.print("Elija una opción: ");
			Scanner entradaTec = new Scanner (System.in);
			Scanner entradaTeclado1 = new Scanner (System.in);
			entradaTeclado = entradaTeclado1.nextInt ();
				 switch (entradaTeclado) {
		         case 1:
		        	 System.out.print("Nombre: ");
			     		String nombre=entradaTec.nextLine();
			     		System.out.print("Numero; ");
			     		String numero=entradaTec.nextLine();
			     		System.out.print("Tipo: ");
			     		String tipo=entradaTec.nextLine();
			     		System.out.print("Unidades: ");
			     		int unidades= entradaTeclado1.nextInt();
			        	inv.addProducto(new Producto(nombre,numero,tipo,unidades));
		        	 break;
		        case 2:
		        	System.out.println("¿Qué desea eliminar de su inventario?");
		        	System.out.print("Buscar: ");
			     	String eliminar=entradaTec.nextLine();
			     	//ag.eliminarContacto(eliminar);

					Inventario elim= Inventario.getInstance();// singleton
	        	 	ArrayList <Producto> auxiliar = inv.buscarProducto(eliminar); // auxiliar tiene el contacto buscado al que quieres eliminar
	     			if(auxiliar.size()!=0) {// ponemos una condicion por si no encuentra el contacto
		     			System.out.print("Contacto Numero: ");
		     			Scanner scanner = new Scanner (System.in);
		     			int prod=scanner.nextInt();
		     			inv.deleteProducto(auxiliar.get(prod),prod);// con esto eliminamos el contacto buscado, con el ID buscado
		     			
	     			}
					 break; 
		        case 3:
		        	System.out.println("Introduzca el producto que desea buscar: ");
	        	 	System.out.print("Buscar: ");
			     	String buscar=entradaTec.nextLine();
			     	inv.buscarProducto(buscar);
		        	
		        	break;
		        case 4:
		        	System.out.println("¿Qué desea modificar de su inventario?");
		        	System.out.print("Buscar: ");
				    String modificar=entradaTec.nextLine();
				   // ag.modificar(auxiliar.get(modificar));
				    ArrayList <Producto> auxiliar1 = inv.buscarProducto(modificar);
					System.out.print("Contacto Numero: ");
					Scanner scanner = new Scanner (System.in);
				 	int contacto=scanner.nextInt();
				   // ag.modificarContacto(nombre,apellidos,);
					System.out.print("Nombre nuevo: ");
					Scanner modif = new Scanner (System.in);
			 		String nombre1=modif.nextLine();
					
					System.out.print("Numero nuevo: ");
			 		String numero1=modif.nextLine();
			 		
			 		System.out.print("Tipo nuevo: ");
			 		String tipo1=modif.nextLine();
			 		
			 		System.out.print("Unidades nuevas: ");
			 		int unid1=scanner.nextInt();			 		
			 		
			 		inv.modificarProducto(nombre1, numero1, tipo1, unid1, contacto, auxiliar1);
		        	break;
		        	
		        case 5:
		        	inv.visualizar();
		        	break;
				 }
				 
					 
		}
	}
}
