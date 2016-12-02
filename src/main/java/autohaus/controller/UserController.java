package autohaus.controller;

import java.security.Principal;

import autohaus.dto.DTOUtilMapper;
import autohaus.entity.User;
import autohaus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String newUser(Model model) {
        model.addAttribute("userDTOs", DTOUtilMapper.usersToUsersDTO(userService.findAll()));
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user, Model model) {

        userService.save(user);

        return "redirect:/registration";
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public String newUser(@PathVariable int id) {

        userService.delete(id);

        return "redirect:/registration";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Principal principal, Model model) {

        System.out.println(principal);

        User user = userService.findOne(Integer.parseInt(principal.getName()));

        model.addAttribute("user", user);

        return "profile";
    }

}