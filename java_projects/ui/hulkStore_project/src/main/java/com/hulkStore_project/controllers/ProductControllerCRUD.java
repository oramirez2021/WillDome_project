package com.hulkStore_project.controllers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Button;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

import com.hulkStore_project.model.ObjetoRespProduct;
import com.hulkStore_project.model.*;
public class ProductControllerCRUD extends Controller {
	Button btn_save_product;
	Textbox txt_product_name;
	Textbox txt_category_id;
	Textbox txt_stock;
	String product_name;
	int stock;
	int category_id;
	private HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
	
@Override
public void doAfterCompose(Component comp) throws Exception {
	// TODO Auto-generated method stub
	super.doAfterCompose(comp);
	btn_save_product.setLabel("Salvar");
	btn_save_product.addEventListener("onClick", new guardarListener());
}

@Listen("onSelect = ")

public class guardarListener implements EventListener {
    public void onEvent(Event event) {
    	product_name = txt_product_name.getValue();
    	category_id = Integer.parseInt(txt_category_id.getValue());
    	stock = Integer.parseInt(txt_stock.getValue());
    	insertarProducto(product_name, category_id, stock);
    }
}

private void insertarProducto(String product_name, int category_id, int stock) {
	final HttpRequest requestPost = HttpRequest.newBuilder().GET().uri(URI.create("http://localhost:8888/hulkStore/InsertProduct?product_name="+product_name+"&category_id="+category_id+"&stock="+stock)).build();
	try {
		Listitem item,item1;
		Listcell cell;
		final HttpResponse<String> response = httpClient.send(requestPost, HttpResponse.BodyHandlers.ofString());
		
	} catch (IOException | InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private void eliminarProducto(int product_id) {
	final HttpRequest requestPost = HttpRequest.newBuilder().GET().uri(URI.create("http://localhost:8888/hulkStore/DeleteProduct?product_id="+product_id)).build();
	try {
		Listitem item,item1;
		Listcell cell;
		final HttpResponse<String> response = httpClient.send(requestPost, HttpResponse.BodyHandlers.ofString());
		
	} catch (IOException | InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private void actualizarProducto(String product_name, int category_id, int stock, int product_id) {
	final HttpRequest requestPost = HttpRequest.newBuilder().GET().uri(URI.create("http://localhost:8888/hulkStore/DeleteProduct?product_name="+product_name+"&category_id="+category_id+"&stock="+stock+"&product_id="+product_id)).build();
	try {
		Listitem item,item1;
		Listcell cell;
		final HttpResponse<String> response = httpClient.send(requestPost, HttpResponse.BodyHandlers.ofString());
		
	} catch (IOException | InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
