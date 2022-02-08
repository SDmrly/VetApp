package com.App.Vet.api.controller;

import com.App.Vet.business.abstracts.AnimalTypeService;
import com.App.Vet.business.abstracts.AuthenticationService;
import com.App.Vet.business.abstracts.PetService;
import com.App.Vet.business.abstracts.UserService;
import com.App.Vet.core.entities.User;
import com.App.Vet.entities.concretes.Pet;
import com.App.Vet.entities.dtos.PetUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pet")
public class PetController {
    private final PetService petService;
    private final AnimalTypeService animalTypeService;
    private final AuthenticationService authenticationService;
    private final UserService userService;

    @Autowired
    public PetController(PetService petService, AnimalTypeService animalTypeService, AuthenticationService authenticationService,
                         UserService userService) {

        this.petService = petService;
        this.animalTypeService = animalTypeService;
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @ModelAttribute("pet")
    public Pet pet(){
        return new Pet();
    }

    @GetMapping("/petlist")
    public String petList(Model model) {
        model.addAttribute("petlists", petService.getByUser_UserName(authenticationService.getCurrentUserName()));
        return "/user/petlist";

    }

    @GetMapping("/petadd")
    public String petAddForm(Model model){
        model.addAttribute("animaltypes", this.animalTypeService.getAll());
        return "/user/petadd";
    }

    @PostMapping("/petadd")
    public String petAdd(@ModelAttribute("pet") Pet pet){
        User user = userService.getCurrentUser();
        pet.setUser(user);
        this.petService.addPet(pet);
        return "redirect:/pet/petadd?success";

    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model){
        model.addAttribute("animaltypes", this.animalTypeService.getAll());
        model.addAttribute("petupdate", this.petService.getById(id));
        return "/user/petupdate";
    }

    @PostMapping("/update/{id}")
    public String updatePet(@ModelAttribute("petupdate") PetUpdateDto updateDto){
        this.petService.updatePet(updateDto);
        return "redirect:/pet/update/{id}?success";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") int id){
        this.petService.deletePetById(id);
        return "redirect:/pet/petlist?success";
    }
}
