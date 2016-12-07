package autohaus.controller;

import autohaus.dto.DTOUtilMapper;
import autohaus.entity.User;
import autohaus.service.MailSenderService;
import autohaus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailSenderService mailSenderService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String newUser(Model model) {
        model.addAttribute("userDTOs", DTOUtilMapper.usersToUsersDTO(userService.findAll()));
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user, Model model) {

        String uuid = UUID.randomUUID().toString();
        user.setUuid(uuid);

        try {
            userService.save(user);
        } catch (Exception e) {
            model.addAttribute("exception", e.getMessage());
            return "registration";
        }

        String theme = "Thanks for registration!";
        String message = "gl & hf http://localhost:8080/confirm/" + uuid;
        mailSenderService.sendMail(theme, message, user.getEmail());
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

    @RequestMapping(value = "/saveImage", method = RequestMethod.POST)
    public String saveImage(Principal principal,
                            @RequestParam MultipartFile image) {
        userService.saveImage(principal, image);
        return "redirect:/profile";
    }

    @RequestMapping(value = "/confirm/{uuid}", method = RequestMethod.GET)
    public String confirm(@PathVariable String uuid) {
        User user = userService.findByUuid(uuid);
        user.setEnabled(true);
        userService.update(user);
        return "redirect:/";
    }

}