package autohaus.controller;

import autohaus.entity.Color;
import autohaus.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class ColorController {

    @Autowired
    private ColorService colorService;

    @RequestMapping(value = "/newColor", method = RequestMethod.GET)
    public String newColor(Model model) {
        model.addAttribute("colors", colorService.findAll());
        return "newColor";
    }

    @RequestMapping(value = "/saveColor", method = RequestMethod.POST)
    public String saveColor(@RequestParam String name) {
        Color color = new Color(name);
        colorService.save(color);
        return "redirect:/newColor";
    }

    @RequestMapping(value = "/deleteColor", method = RequestMethod.POST)
    public String deleteColor(@RequestParam String id){
        colorService.delete(Integer.parseInt(id));
        return "redirect:/newColor";
    }


}



