package service;

import java.util.Collection;

import generated.customer.Customer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.ICustomerService;

public class CustomerApplication {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		ICustomerService remoteService = context.getBean("customerServiceProxy", ICustomerService.class);
		
		// TODO add 3 customers & print customers list

		// TODO update 1 customer & print customers list
		
		// TODO delete 1 customer & print customers list
	}
	
	public static void printCustomers(Collection<Customer> customers) {
		for (Customer customer : customers) {
			System.out.println(customer.getName() + " " + customer.getCustomerNumber());
		}
		System.out.println();
	}
}
