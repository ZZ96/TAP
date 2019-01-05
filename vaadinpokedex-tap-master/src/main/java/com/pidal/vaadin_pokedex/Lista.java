package com.pidal.vaadin_pokedex;

import java.util.ArrayList;
import java.util.List;

public class Lista implements MetodoVisualizar{

	public Lista() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visualizar(List<Producto> inventario) {
		// TODO Auto-generated method stub
		for(int i=0; i<inventario.size();i++) {
			System.out.println("- Producto Número " + i);
			System.out.println("- Nombre: " + inventario.get(i).getName());
			System.out.println("- Numero: " + inventario.get(i).getNumber());
			System.out.println("- Tipo: " + inventario.get(i).getType());
			System.out.println("- Unidades: " + inventario.get(i).getUnidades());
			System.out.println("------------------------");
		}
	}



}
