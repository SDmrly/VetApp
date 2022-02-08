package com.App.Vet.api.controller;

import com.App.Vet.business.abstracts.AnimalTypeService;
import com.App.Vet.business.abstracts.AuthenticationService;
import com.App.Vet.business.abstracts.UserService;
import com.App.Vet.core.entities.User;
import com.App.Vet.entities.dtos.UserUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final AuthenticationService authenticationService;

    @Autowired
    public UserController(UserService userService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;

    }

    @ModelAttribute("user")
    public User user(){
        return new User();
    }

    @GetMapping("/registration")
    public String showRegistrationForm(){
        return "/registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes){
        if(this.userService.existsByUserName(user.getUserName())){
            return "redirect:/user/registration?error";
        }
        userService.saveUser(user);
        return "redirect:/user/registration?success";
    }

    @GetMapping("/information")
    public String information(Model model){
        model.addAttribute("userinformation", userService.getCurrentUser());
        return "/user/information";
    }

   @PostMapping("/information")
    public String updateUser(@ModelAttribute("userinformation") UserUpdateDto userUpdateDto) {
        this.userService.updateUser(userUpdateDto);
        return "redirect:/user/information?success";
    }

}
