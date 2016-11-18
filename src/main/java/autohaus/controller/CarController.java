package autohaus.controller;

import autohaus.entity.Car;
import autohaus.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

    @Autowired
    private CarService carService;
    @Autowired
    private CarModelService carModelService;
    @Autowired
    private EngineService engineService;
    @Autowired
    private TransmissionService transmissionService;
    @Autowired
    private ColorService colorService;

    @RequestMapping(value = "/newCar", method = RequestMethod.GET)
    public String newCar(Model model) {
        model.addAttribute("cars", carService.findAll());
        model.addAttribute("carModels", carModelService.findAll());
        model.addAttribute("engines", engineService.findAll());
        model.addAttribute("transmissions", transmissionService.findAll());
        model.addAttribute("colors", colorService.findAll());
        return "newCar";
    }

    @RequestMapping(value = "/saveCar", method = RequestMethod.POST)
    public String saveCar(@RequestParam String carModelID,
                          String engineID,
                          String transmissionID,
                          String colorID,
                          String price) {
        Car car = new Car(carModelService.findOne(Integer.parseInt(carModelID)),
                engineService.findOne(Integer.parseInt(engineID)),
                transmissionService.findOne(Integer.parseInt(transmissionID)),
                colorService.findOne(Integer.parseInt(colorID)),
                Integer.parseInt(price));
        carService.save(car);
        return "redirect:/newCar";
    }

    @RequestMapping(value = "/deleteCar", method = RequestMethod.POST)
    public String deleteCar(@RequestParam String id) {
        carService.delete(Integer.parseInt(id));
        return "redirect:/newCar";
    }

}
