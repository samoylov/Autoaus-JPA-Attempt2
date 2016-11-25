package autohaus.controller;

import autohaus.editor.CarModelEditor;
import autohaus.editor.MakeEditor;
import autohaus.entity.CarModel;
import autohaus.entity.Make;
import autohaus.service.CarModelService;
import autohaus.service.MakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarModelController {

    @Autowired
    private CarModelService carModelService;
    @Autowired
    private MakeService makeService;

    @InitBinder
    public void InitBinder(WebDataBinder binder){
        binder.registerCustomEditor(CarModel.class, new CarModelEditor(carModelService));
        binder.registerCustomEditor(Make.class, new MakeEditor(makeService));
    }

    @RequestMapping(value = "/newCarModel", method = RequestMethod.GET)
    public String newCarModel(Model model) {
        model.addAttribute("carmodels", carModelService.findAll());
        model.addAttribute("makes", makeService.findAll());
        model.addAttribute("carModel", new CarModel());
        model.addAttribute("modelsToDelete", new ArrayList<CarModel>());
        return "newCarModel";
    }

    @RequestMapping(value = "/saveCarModel", method = RequestMethod.POST)
    public String saveCarModel(/*@RequestParam String name, String makeID*/
                @ModelAttribute CarModel carModel, Make make) {
        // CarModel carModel = new CarModel(name, makeService.findOne(Integer.parseInt(makeID)));

        carModelService.save(carModel);
        return "redirect:/newCarModel";
    }

    @RequestMapping(value = "/deleteCarModel", method = RequestMethod.POST)
    public String deleteCarModel(@RequestParam String id) {
        carModelService.delete(Integer.parseInt(id));
        return "redirect:/newCarModel";
    }

    @RequestMapping(value = "/deleteCarModels", method = RequestMethod.POST)
    public String deleteCarModels(@ModelAttribute ArrayList<CarModel> models) {
        for(CarModel model: models){
            carModelService.delete(model.getId());

        }
        return "redirect:/newCarModel";
    }

}
