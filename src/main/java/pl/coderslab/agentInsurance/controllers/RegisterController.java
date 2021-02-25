package pl.coderslab.agentInsurance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.agentInsurance.model.User;
import pl.coderslab.agentInsurance.services.UserService;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showEditForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String saveEditForm(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        }
        User userExists = userService.findByUserName(user.getUsername());
        if (userExists != null) {
            return "registration";
        }
            userService.saveUser(user);
            return "redirect:/login";

    }
}
