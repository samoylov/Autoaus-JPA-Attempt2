package autohaus.controller;

import autohaus.entity.CarModel;
import autohaus.service.CarModelService;
import autohaus.service.MakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarModelController {

    @Autowired
    private CarModelService carModelService;
    @Autowired
    private MakeService makeService;

    @RequestMapping(value = "/newCarModel", method = RequestMethod.GET)
    public String newCarModel(Model model) {
        model.addAttribute("carmodels", carModelService.findAll());
        model.addAttribute("makes", makeService.findAll());
        return "newCarModel";
    }

    @RequestMapping(value = "/saveCarModel", method = RequestMethod.POST)
    public String saveCarModel(@RequestParam String name, String makeID) {
        CarModel carModel = new CarModel(name, makeService.findOne(Integer.parseInt(makeID)));
        carModelService.save(carModel);
        return "redirect:/newCarModel";
    }

    @RequestMapping(value = "/deleteCarModel", method = RequestMethod.POST)
    public String deleteCarModel(@RequestParam String id) {
        carModelService.delete(Integer.parseInt(id));
        return "redirect:/newCarModel";
    }

}
