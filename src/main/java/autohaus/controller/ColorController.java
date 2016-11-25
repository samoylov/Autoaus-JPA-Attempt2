package autohaus.controller;

import autohaus.entity.Color;
import autohaus.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ColorController {

    @Autowired
    private ColorService colorService;

    @RequestMapping(value = "/newColor", method = RequestMethod.GET)
    public String newColor(Model model) {
        model.addAttribute("colors", colorService.findAll());
        model.addAttribute("addColor", new Color(""));
        return "newColor";
    }

    @RequestMapping(value = "/saveColor", method = RequestMethod.POST)
    public String saveColor(/*@RequestParam String name*/
                            @ModelAttribute Color addColor) {
        colorService.save(addColor);
        return "redirect:/newColor";
    }

    @RequestMapping(value = "/deleteColor", method = RequestMethod.POST)
    public String deleteColor(@RequestParam String[] ids) {
        for (String id : ids) {
            System.out.println(id);
            colorService.delete(Integer.parseInt(id));
        }
        return "redirect:/newColor";
    }
}