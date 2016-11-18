package autohaus.controller;

import autohaus.entity.Transmission;
import autohaus.service.TransmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransmissionController {

    @Autowired
    private TransmissionService transmissionService;

    @RequestMapping(value = "/newTransmission", method = RequestMethod.GET)
    public String newTransmission(Model model) {
        model.addAttribute("transmissions", transmissionService.findAll());
        return "newTransmission";
    }

    @RequestMapping(value = "/saveTransmission", method = RequestMethod.POST)
    public String saveTransmission(@RequestParam String name) {
        Transmission transmission = new Transmission(name);
        transmissionService.save(transmission);
        return "redirect:/newTransmission";
    }

    @RequestMapping(value = "/deleteTransmission", method = RequestMethod.POST)
    public String deleteTransmission(@RequestParam String id) {
        transmissionService.delete(Integer.parseInt(id));
        return "redirect:/newTransmission";
    }

}
