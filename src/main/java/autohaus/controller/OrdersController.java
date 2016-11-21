package autohaus.controller;

import autohaus.entity.Orders;
import autohaus.service.CarService;
import autohaus.service.CustomerService;
import autohaus.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private CarService carService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/newOrder", method = RequestMethod.GET)
    public String newOrder(Model model) {
        model.addAttribute("orders", ordersService.findAll());
        model.addAttribute("cars", carService.findAll());
        model.addAttribute("customers", customerService.findAll());
        return "newOrder";
    }

    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    public String saveOrder(@RequestParam String customerID,
                            String carID) {
        Orders orders = new Orders(
                customerService.findOne(Integer.parseInt(customerID)),
                carService.findOne(Integer.parseInt(carID)));
        ordersService.save(orders);
        return "redirect:/newOrder";
    }

    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    public String deleteOrder(@RequestParam String id){
        ordersService.delete(Integer.parseInt(id));
        return "redirect:/newOrder";
    }
}