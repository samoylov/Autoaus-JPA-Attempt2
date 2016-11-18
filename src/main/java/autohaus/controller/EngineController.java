package autohaus.controller;

import autohaus.entity.Engine;
import autohaus.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EngineController {

    @Autowired
    private EngineService engineService;

    @RequestMapping(value = "/newEngine", method = RequestMethod.GET)
    public String newEngine(Model model) {
        model.addAttribute("engines", engineService.findAll());
        return "newEngine";
    }

    @RequestMapping(value = "/saveEngine", method = RequestMethod.POST)
    public String saveEngine(@RequestParam String name) {
        Engine engine = new Engine(name);
        engineService.save(engine);
        return "redirect:/newEngine";
    }

    @RequestMapping(value = "/deleteEngine", method = RequestMethod.POST)
    public String deleteEngine(@RequestParam String id) {
        engineService.delete(Integer.parseInt(id));
        return "redirect:/newEngine";
    }

}
