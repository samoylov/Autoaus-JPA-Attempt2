package autohaus.controller;

import autohaus.entity.Customer;
import autohaus.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/newCustomer", method = RequestMethod.GET)
    public String newCustomer(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "newCustomer";
    }

    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
    public String saveCustomer(@RequestParam String firstName, String lastName, String address, String email) {
        Customer customer = new Customer(firstName, lastName, address, email);
        customerService.save(customer);
        return "redirect:/newCustomer";
    }

    @RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST)
    public String deleteCustomer(@RequestParam String id) {
        customerService.delete(Integer.parseInt(id));
        return "redirect:/newCustomer";
    }


}



