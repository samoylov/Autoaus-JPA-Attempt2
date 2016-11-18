package autohaus.controller;

import autohaus.entity.Country;
import autohaus.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/newCountry", method = RequestMethod.GET)
    public String newCountry(Model model) {
        model.addAttribute("countries", countryService.findAll());
        return "newCountry";
    }

    @RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
    public String saveCountry(@RequestParam String name) {
        Country country = new Country(name);
        countryService.save(country);
        return "redirect:/newCountry";
    }

    @RequestMapping(value = "/deleteCountry", method = RequestMethod.POST)
    public String deleteCountry(@RequestParam String id){
        countryService.delete(Integer.parseInt(id));
        return "redirect:/newCountry";
    }

}
