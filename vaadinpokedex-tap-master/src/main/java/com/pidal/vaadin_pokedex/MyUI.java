package com.pidal.vaadin_pokedex;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	private Producto selectedProducto; 
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
       
    	Grid<Producto> grid = new Grid<Producto>();
    	
    	HorizontalLayout horizontalLayout = new HorizontalLayout();
    	
    	 //VENTANA DETALLE 
    	
    	Window subWindow = new Window("Producto details");
        VerticalLayout subContent = new VerticalLayout();
        
        Label labelNumber = new Label();
        Label labelName = new Label();
        Label labelType = new Label();
        Label labelUnidades = new Label();
        Button buttonDelete = new Button("Delete Producto");
        Button buttonDeleteUno = new Button("Borrar una unidad");
        Button buttonModificar = new Button("Modificar Producto");
        
        buttonDelete.addClickListener(e -> {
        	Inventario.getInstance().deleteProducto(selectedProducto, 1);
        	grid.setItems(Inventario.getInstance().getProducto());
        	removeWindow(subWindow);
        	
        });
        //OJO
        buttonDeleteUno.addClickListener(e -> {
        	Inventario.getInstance().deleteProductoUno(selectedProducto);
        	grid.setItems(Inventario.getInstance().getProducto());
        	removeWindow(subWindow);
        	
        });
        //OJO
        buttonDelete.addClickListener(e -> {
        	Inventario.getInstance().deleteProducto(selectedProducto, 1);
        	grid.setItems(Inventario.getInstance().getProducto());
        	removeWindow(subWindow);
        	
        });
        
      
        subContent.addComponents(labelNumber, labelName, labelType, labelUnidades, buttonDelete, buttonDeleteUno);
        
        
        subWindow.center();
        subWindow.setContent(subContent);
        
        
        
        // addWindow(subWindow);
    	
    	// TABLE 
    	
    	
    	grid.addColumn(Producto::getNumber).setCaption("Number");
    	grid.addColumn(Producto::getName).setCaption("Name");
    	grid.addColumn(Producto::getType).setCaption("Type");
    	grid.addColumn(Producto::getUnidades).setCaption("Unidades");

    	grid.setSelectionMode(SelectionMode.SINGLE);
    	
    	grid.addItemClickListener(event -> {
    		
    		selectedProducto = event.getItem();
    		
        	// Notification.show("Value: " + event.getItem());
        	labelNumber.setValue(selectedProducto.getNumber());
        	labelName.setValue(selectedProducto.getName());
        	labelType.setValue(selectedProducto.getType());
        	labelUnidades.setValue(String.valueOf(selectedProducto.getUnidades()));
        	
        	removeWindow(subWindow);
        	addWindow(subWindow);
        	
    	});
    	
    	
    	// FORM 
    	
    	
    	FormLayout formLayout = new FormLayout();
    	
    	TextField textFieldNumber = new TextField("Number");
    	TextField textFieldName = new TextField("Name");
    	TextField textFieldType = new TextField("Type");
    	TextField textFieldUnidades = new TextField("Unidades");
    	Button buttonAddProducto = new Button("Añadir");
    	

    	buttonAddProducto.addClickListener(e -> {
    		
    		Producto p = new Producto(
    				textFieldNumber.getValue(),
    				textFieldName.getValue(),
    				textFieldType.getValue(),
    				Integer.parseInt(textFieldUnidades.getValue())
    				);
    		
    		Inventario.getInstance().addProducto(p);
    		
    		textFieldNumber.clear();
    		textFieldName.clear();
    		textFieldType.clear();
    		textFieldUnidades.clear();
    		
    		grid.setItems(Inventario.getInstance().getProducto());
    		
    		
    		Notification.show("Producto capturado! Ya tenemos " + 
    				Inventario.getInstance().getProducto().size() + "!!",
    				Notification.TYPE_TRAY_NOTIFICATION);
    		
    	});
    	
    	
    	
    	
    	formLayout.addComponents(
    			textFieldNumber, 
    			textFieldName, 
    			textFieldType,
    			textFieldUnidades,
    			buttonAddProducto
    	);
    	
    
    	horizontalLayout.addComponents(grid, formLayout);
    	
    	
    	
    	setContent(horizontalLayout);
    	
    	
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
    
}
