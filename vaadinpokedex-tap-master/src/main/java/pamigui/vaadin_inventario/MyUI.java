package pamigui.vaadin_inventario;

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
    	Grid<Producto> grid2 = new Grid<Producto>();
    	
    	HorizontalLayout horizontalLayout = new HorizontalLayout();
    	VerticalLayout verticalLayout = new VerticalLayout();
    	VerticalLayout verticalLayout1 = new VerticalLayout();
    	 //VENTANA DETALLE 
    	
    	Window subWindow = new Window("Producto details");
        VerticalLayout subContent = new VerticalLayout();
        
        Label labelNumber = new Label();
        Label labelName = new Label();
        Label labelprecio = new Label();
        Label labelUnidades = new Label();
        Button buttonDelete = new Button("Borrar Producto");
        Button buttonDeleteUno = new Button("Borrar una unidad");
        Button buttonAniadirUno = new Button("Añadir una unidad");
        Button buttonModificar = new Button("Modificar producto");
        TextField textFieldNumber2 = new TextField("Number");
    	TextField textFieldName2 = new TextField("Name");
    	TextField textFieldprecio2 = new TextField("Precio en €");
    	Button buttonPrecio = new Button("Ver distintos precios");
        
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
        buttonAniadirUno.addClickListener(e -> {
        	Inventario.getInstance().aniadirUno(selectedProducto);
        	grid.setItems(Inventario.getInstance().getProducto());
        	removeWindow(subWindow);
        	
        });
        //OJO
        buttonModificar.addClickListener(e -> {
	        Inventario.getInstance().modificarProducto(selectedProducto, 
	        		textFieldNumber2.getValue(), textFieldName2.getValue(), 
	        		Double.parseDouble(textFieldprecio2.getValue()));
	        grid.setItems(Inventario.getInstance().getProducto());
	        removeWindow(subWindow);
        
        	
        });
        
        buttonPrecio.addClickListener(e -> {
	        /*Inventario.getInstance().modificarProducto(selectedProducto, 
	        		textFieldNumber2.getValue(), textFieldName2.getValue(), 
	        		Double.parseDouble(textFieldprecio2.getValue()));
	        grid.setItems(Inventario.getInstance().getProducto());*/
	        //a = labelprecio.getValue();
	        //Window subWindow2 = new Window("Precio");
	        //HorizontalLayout subContent2 = new HorizontalLayout();
	        
	        Label labelLibras = new Label();
	        Label labelDolares = new Label();
	        Label labelEuros = new Label();
	        labelLibras.setValue(String.valueOf(selectedProducto.getPrecio()*1.3) + "£");
	        labelDolares.setValue(String.valueOf(selectedProducto.getPrecio()*1.12) + "$");
	        labelEuros.setValue(String.valueOf(selectedProducto.getPrecio()) + "€");
	        //removeWindow(subWindow);
	        subContent.addComponents(labelLibras, labelDolares, labelEuros);
	        //addWindow(subWindow2);
        });
      
        subContent.addComponents(labelNumber, labelName, labelprecio, 
        		labelUnidades, buttonDelete, buttonDeleteUno, buttonAniadirUno, 
        		textFieldNumber2, textFieldName2, textFieldprecio2, buttonModificar,
        		buttonPrecio);
        
        
        subWindow.center();
        subWindow.setContent(subContent);
        
        
        
        // addWindow(subWindow);
    	
    	// TABLE 
    	
    	
    	grid.addColumn(Producto::getNumber).setCaption("Number");
    	grid.addColumn(Producto::getName).setCaption("Name");
    	grid.addColumn(Producto::getPrecio).setCaption("Precio en €");
    	//grid.addColumn(Producto::getPrecio).setCaption("Precio en $");
    	//grid.addColumn(Producto::getPrecio).setCaption("Precio en £");
    	grid.addColumn(Producto::getUnidades).setCaption("Unidades");
    	grid.addColumn(Producto::getPrecio_total).setCaption("Precio total en €");
    	grid.setSelectionMode(SelectionMode.SINGLE);
    	
    	grid.addItemClickListener(event -> {
    		
    		selectedProducto = event.getItem();
    		
        	// Notification.show("Value: " + event.getItem());
        	labelNumber.setValue(selectedProducto.getNumber());
        	labelName.setValue(selectedProducto.getName());
        	labelprecio.setValue(String.valueOf(selectedProducto.getPrecio()));
        	//labelprecio.setValue(String.valueOf(selectedProducto.getPrecio()*1.12));
        	labelUnidades.setValue(String.valueOf(selectedProducto.getUnidades()));
        	
        	removeWindow(subWindow);
        	addWindow(subWindow);
        	
    	});
    	
    	
    	// FORM 
    	
    	
    	FormLayout formLayout = new FormLayout();
    	
    	TextField textFieldNumber = new TextField("Number");
    	TextField textFieldName = new TextField("Name");
    	TextField textFieldprecio = new TextField("Precio");
    	TextField textFieldUnidades = new TextField("Unidades");
    	Button buttonAddProducto = new Button("Añadir");
    	

    	buttonAddProducto.addClickListener(e -> {
    		
    		Producto p = new Producto(
    				textFieldNumber.getValue(),
    				textFieldName.getValue(),
    				Double.parseDouble(textFieldprecio.getValue()),
    				Integer.parseInt(textFieldUnidades.getValue())
    				);
    		
    		Inventario.getInstance().addProducto(p);
    		
    		textFieldNumber.clear();
    		textFieldName.clear();
    		textFieldprecio.clear();
    		textFieldUnidades.clear();
    		
    		grid.setItems(Inventario.getInstance().getProducto());
    		grid2.setItems(Inventario.getInstance().getProducto());

    		
    		Notification.show("Producto capturado! Ya tenemos " + 
    				Inventario.getInstance().getProducto().size() + "!!",
    				Notification.TYPE_TRAY_NOTIFICATION);
    		
    	});
    	
    	
    	
    	
    	formLayout.addComponents(
    			textFieldNumber, 
    			textFieldName, 
    			textFieldprecio,
    			textFieldUnidades,
    			buttonAddProducto
    	);
    	
    	Window subWindow1 = new Window("Producto details");
        VerticalLayout subContent1 = new VerticalLayout();
        
    	Button comprar = new Button("Comprar");
    	Button vender = new Button("Vender");
    	Button fabricar = new Button();
    	
    	comprar.addClickListener(e -> {
        	Inventario.getInstance().deleteProductoUno(selectedProducto);
        	//(selectedProducto.getPrecio());
        	grid.setItems(Inventario.getInstance().getProducto());
        	grid2.setItems(Inventario.getInstance().getProducto());
        	removeWindow(subWindow1);
        	removeWindow(subWindow);
        	//removeWindow(subWindow2);
        });
    	vender.addClickListener(e -> {
        	Inventario.getInstance().aniadirUno(selectedProducto);
        	grid.setItems(Inventario.getInstance().getProducto());
        	grid2.setItems(Inventario.getInstance().getProducto());
        	//(selectedProducto.getPrecio());
        	removeWindow(subWindow1);
        	removeWindow(subWindow);
        	
        });
    	
    	grid2.addColumn(Producto::getNumber).setCaption("Number");
    	grid2.addColumn(Producto::getName).setCaption("Name");
    	grid2.addColumn(Producto::getPrecio).setCaption("Precio en €");
    	//gr2id.addColumn(Producto::getPrecio).setCaption("Precio en $");
    	//gr2id.addColumn(Producto::getPrecio).setCaption("Precio en £");
    	grid2.addColumn(Producto::getUnidades).setCaption("Unidades");
    	//grid2.addColumn(Producto::getPrecio_total).setCaption("Precio total en €");
    	
    	grid2.setSelectionMode(SelectionMode.SINGLE);
    	
    	
    	grid2.addItemClickListener(even -> {
    		
    		selectedProducto = even.getItem();
    		//Window subWindow1 = new Window("Producto details");
            //VerticalLayout subContent1 = new VerticalLayout();
            removeWindow(subWindow);
            //addWindow(subWindow2);
        	// Notification.show("Value: " + event.getItem());
        	labelNumber.setValue(selectedProducto.getNumber());
        	labelName.setValue(selectedProducto.getName());
        	labelprecio.setValue(String.valueOf(selectedProducto.getPrecio()));
        	labelUnidades.setValue(String.valueOf(selectedProducto.getUnidades()));
        	
        	subContent1.addComponents(comprar, vender);
        	subWindow1.center();
            subWindow1.setContent(subContent1);
        	removeWindow(subWindow1);
        	addWindow(subWindow1);
        	
    	});
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    
    	//horizontalLayout.addComponents(grid, formLayout);
    	
    	verticalLayout.addComponents(grid, grid2);
    	verticalLayout1.addComponents(formLayout);
    	horizontalLayout.addComponents(verticalLayout, verticalLayout1);
    	
    	setContent(horizontalLayout);
    	
    	
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
    
}
