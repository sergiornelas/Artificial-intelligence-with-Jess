package gov.sandia.jess.example.pricing.demo;

import gov.sandia.jess.example.pricing.model.CatalogItem;
import gov.sandia.jess.example.pricing.model.Customer;
import gov.sandia.jess.example.pricing.model.Order;
import gov.sandia.jess.example.pricing.model.OrderItem;

//sergio
import gov.sandia.jess.example.pricing.model.Smartphone;
import gov.sandia.jess.example.pricing.model.Computer;
import gov.sandia.jess.example.pricing.model.CreditCard;

import gov.sandia.jess.example.pricing.Database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * A toy implementation of the Database interface with some
 * hard-coded order data.
 */

public class DemoDatabase implements Database {

	private ArrayList items;
	private Map orders;

	public DemoDatabase() {
		createCatalogItems();
		createOrders();
	}
	
	// aqui es donde se crean los nuevos 3 clientes en el hands-on 11
	private void createOrders() {
		orders = new HashMap();
		
		Customer customer = new Customer(6);
		ArrayList orderItems = new ArrayList();

		//AGREGAR LAS TARJETAS EN engine.add EN PRICINGENGINE.JAVA, NOS OBLIGA A INSERTAR TARJETAS EN TODAS LAS COMPRAS.

												// ID, PRICE, QUANTITY
		orderItems.add(new OrderItem("CD Writer", 1234, 199.99f, 1));
		orderItems.add(new OrderItem("AA Batteries", 4323, 4.99f, 2));
		//orders.put(new Integer(123), new Order(orderItems, customer));
		orders.put(new Integer(123), new Order(orderItems, customer, new CreditCard("BANCO AZTECA", "BANK ISSUED")));


		customer = new Customer(1);
		orderItems = new ArrayList();
		orderItems.add(new OrderItem("Gold-tipped cable", 9876, 19.99f, 4));
		orders.put(new Integer(567), new Order(orderItems, customer, new CreditCard("BANCO AZTECA", "BANK ISSUED")));


		customer = new Customer(1);
		orderItems = new ArrayList();
		orderItems.add(new OrderItem("Incredibles DVD", 222123, 29.99f, 1));
		orders.put(new Integer(666), new Order(orderItems, customer, new CreditCard("BANCO AZTECA", "BANK ISSUED")));

		///////////////////////////////////////////////////////////////////////////////////sergio
		customer = new Customer(1);
		orderItems = new ArrayList();									// ID, PRICE, QUANTITY
		orderItems.add(new OrderItem(new Smartphone("IFON 11 PRO", "APPLE"), 77777, 14200f, 1));
		orders.put(new Integer(777), new Order(orderItems, customer, new CreditCard("BANAMEX", "BANK ISSUED")));
		
		customer = new Customer(1);
		orderItems = new ArrayList();
		orderItems.add(new OrderItem(new Smartphone("NOTE 11", "SAMSUNG"), 88888, 8600f, 1));
                orders.put(new Integer(888), new Order(orderItems, customer, new CreditCard("LIVERPOOL VISA", "BANK ISSUED")));
		
		customer = new Customer(1);
		orderItems = new ArrayList();
		//orderItems.add(new OrderItem(new Computer("MCBOOK AIR", "APPLE"), 99999, 10000f, 1));
		orderItems.add(new OrderItem(new Computer("MCBOOK AIR", "APPLE"), 99999, 10000f, 1));
		orderItems.add(new OrderItem(new Smartphone("CARGADOR IFON", "APPLE"), 22222, 500f, 2));
		orders.put(new Integer(999), new Order(orderItems, customer, new CreditCard("BANCO AZTECA", "BANK ISSUED")));

		//sergio hands-on 11 explicacion Aviña
		// customer = new Customer(1);
		// orderItems = new ArrayList();
		// orderItems.add(new OrderItem("Incredibles DVD", 222123, 29.99f, 1));
		// orderItems.add(new OrderItem("iphone 11 pro", 228883, 99.99f, 1));
		// orderItems.add(new OrderItem("samsun...", 228843, 99.99f, 1));
		// orderItems.add(new OrderItem("macbooook...", 228983, 99.99f, 1));
		// orders.put(new Integer(666), new Order(orderItems, customer));
	}

	private void createCatalogItems() {
		items = new ArrayList();
		items.add(new CatalogItem("CD Writer", 1234, 199.99f));
		items.add(new CatalogItem("CD-RW Disks", 782321, 5.99f));
		items.add(new CatalogItem("AA Batteries", 4323, 4.99f));
		items.add(new CatalogItem("Gold-tipped cable", 9876, 19.99f));
		items.add(new CatalogItem("Amplifier", 34526, 399.99f));
		items.add(new CatalogItem("Incredibles DVD", 222123, 29.99f));

		//sergio
		items.add(new CatalogItem(new Smartphone("IFON 11 PRO", "APPLE"), 77777, 14200f));
		items.add(new CatalogItem(new Smartphone("NOTE 11", "SAMSUNG"), 88888, 8600f));
		items.add(new CatalogItem(new Computer("MCBOOK AIR", "APPLE"), 99999, 10000f));
		items.add(new CatalogItem(new Computer("CARGADOR IFON", "APPLE"), 22222, 500f));
	}

	// Aviña min 23;14 //hands -on 12
	// creas la clase nueva que se encarga de conectarte a tu base de datos.
	// esa clase debe contener debe contener los atributos que consideres
	// necesarios para que una vez creada una instancia sqlConnection
	// me pueda conectar con mi sql engine y pueda realizar transacciones
	// las clásicas, pueda recuperar los catalog items o productos.
	// generes la instancia de esa clase aqui:
	
	//public void sqlConnection(String URL)...{}
	

	public Collection getCatalogItems() {
		return items;
	}

	public Order getOrder(int orderNumber) {
		return (Order) orders.get(new Integer(orderNumber));
	}
}
