package autohaus.controller;

import autohaus.dto.ColorDTO;
import autohaus.dto.DTOUtilMapper;
import autohaus.entity.Color;
import autohaus.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ColorController {

    @Autowired
    private ColorService colorService;


    @RequestMapping(value = "/newColor", method = RequestMethod.GET)
    public String newColor(Model model) {
        return "newColor";
    }

    @RequestMapping(value = "/loadColors", method = RequestMethod.POST)
    public
    @ResponseBody
    List<ColorDTO> loadColors() {
        return DTOUtilMapper.colorsToColorsDTO(colorService.findAll());
    }

    @RequestMapping(value = "/saveColor", method = RequestMethod.POST)
    public
    @ResponseBody
    List<ColorDTO> saveColor(@RequestBody Color color) {
        colorService.save(color);
        return DTOUtilMapper.colorsToColorsDTO(colorService.findAll());
    }

    @RequestMapping(value = "/deleteColor", method = RequestMethod.POST)
    public
    @ResponseBody
    List<ColorDTO> deleteColor(@RequestBody String id) {
        System.out.println(id);
        colorService.delete(Integer.parseInt(id));
        return DTOUtilMapper.colorsToColorsDTO(colorService.findAll());
    }


}