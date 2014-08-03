package service;

import java.util.Collection;

import generated.customer.Customer;
import generated.shoppingList.Item;
import generated.shoppingList.ShoppingList;

import org.springframework.web.client.RestTemplate;

public class CustomerServiceProxy {
	private static final String listURL = "http://localhost:8080/Exercise10.1-Service/rest/customers";
	private static final String itemURL = "http://localhost:8080/Exercise10.1-Service/rest/customer/{product}";

	private RestTemplate restTemplate;

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public void addCustomer(Customer customer) {
		
		
	}

	public void deleteCustomer(String customerNumber) {
	}

	public void updateCustomer(Customer customer) {
	}

	public Collection<Customer> getCustomers() {
		return null;
	}

	public Customer getCustomer(String customerNumber) {
		return new Customer();
	}
}
