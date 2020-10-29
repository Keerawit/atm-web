package th.ac.kmitl.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.kmitl.atm.model.Customer;
import th.ac.kmitl.atm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getCustomerPage(Model model){

        model.addAttribute("allCustomers", customerService.getCustomers());

        return  "customer";

    }

    @PostMapping
    public String registerCustomer(@ModelAttribute Customer customer, Model model){

        customerService.createCustomer(customer);

        model.addAttribute("allCustomer", customerService.getCustomers());
        return "redirect:customer";


    }
}
