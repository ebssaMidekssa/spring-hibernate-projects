package service;

import generated.customer.Customer;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CustomerServiceController {
	private ICustomerService customerService;

	public ICustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value = "/customer/{customerNumber}", method = RequestMethod.POST)
	public RedirectView addCustomer(Customer customer) {

		customerService.addCustomer(customer);
		return new RedirectView(customer.getCustomerNumber());
	}

	@RequestMapping(value = "/customer/{customerNumber}", method = RequestMethod.DELETE)
	public RedirectView deleteCustomer(String customerNumber) {

		customerService.deleteCustomer(customerNumber);
		return new RedirectView("");
	}

	@RequestMapping(value="customer/{customerNumber}",method=RequestMethod.GET)
	public ModelAndView	 getCustomer(String customerNumber) {
		ModelAndView mv = new ModelAndView();
		customerService.getCustomer(customerNumber);
		mv.setViewName("customer");
		
		return mv;
	}

	@RequestMapping(value="/customers",method=RequestMethod.GET)
	public ModelAndView getCustomers() {
		ModelAndView mv = new ModelAndView();
		
		 customerService.getCustomers();
		 mv.setViewName("customers");
		return mv;
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public RedirectView updateCustomer(Customer customer) {

		customerService.updateCustomer(customer);
		return new RedirectView(customer.getCustomerNumber());
	}

}
