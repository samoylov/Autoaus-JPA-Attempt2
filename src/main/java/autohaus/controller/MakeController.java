package autohaus.controller;

import autohaus.entity.Make;
import autohaus.service.CountryService;
import autohaus.service.MakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MakeController {

    @Autowired
    private MakeService makeService;
    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/newMake", method = RequestMethod.GET)
    public String newMake(Model model) {
        model.addAttribute("makes", makeService.findAll());
        model.addAttribute("countries", countryService.findAll());
        return "newMake";
    }

    @RequestMapping(value = "/saveMake", method = RequestMethod.POST)
    public String saveMake(@RequestParam String name, String countryID) {
        Make make = new Make(name, countryService.findOne(Integer.parseInt(countryID)));
        makeService.save(make);
        return "redirect:/newMake";
    }

    @RequestMapping(value = "/deleteMake", method = RequestMethod.POST)
    public String deleteMake(@RequestParam String id) {
        makeService.delete(Integer.parseInt(id));
        return "redirect:/newMake";
    }

}
