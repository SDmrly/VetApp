package com.App.Vet.api.controller;

import com.App.Vet.business.abstracts.AdminService;
import com.App.Vet.business.abstracts.AnimalTypeService;
import com.App.Vet.business.abstracts.PetService;
import com.App.Vet.business.abstracts.RoleService;
import com.App.Vet.entities.dtos.PetUpdateDto;
import com.App.Vet.entities.dtos.UserDetailUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    private final RoleService roleService;
    private final AnimalTypeService animalTypeService;
    private final PetService petService;

    @Autowired
    public AdminController(AdminService adminService, RoleService roleService, AnimalTypeService animalTypeService, PetService petService) {
        this.adminService = adminService;
        this.roleService = roleService;
        this.animalTypeService = animalTypeService;
        this.petService = petService;
    }

    //User Management
    @GetMapping("/userlist")
    public String userList(Model model, String keyword){
        if (keyword != null){
            model.addAttribute("userlists", this.adminService.findByUserKeyword(keyword));
        }else{
            model.addAttribute("userlists", this.adminService.getAllUser());
        }

        return "/admin/users/userlist";
    }

    @GetMapping("/userdetail/{id}")
    public String userDetail(@PathVariable("id") int id, Model model){
        model.addAttribute("userroles", this.roleService.getAll());
        model.addAttribute("userdata", this.adminService.getByUserId(id));
        return "/admin/users/userdetail";
    }

    @PostMapping("/userdetail/{id}")
    public String userUpdate(@ModelAttribute("userdata") UserDetailUpdateDto updateDto){
        this.adminService.updateUser(updateDto);
        return "redirect:/admin/userdetail/{id}?success";

    }

    @GetMapping("/userdelete/{id}")
    public String deleteUser(@PathVariable(value = "id") int id){
        this.adminService.deleteUserById(id);
        return "redirect:/admin/userlist?success";
    }

    //Pet Management
    @GetMapping("/petlist")
    public String petList(Model model, String keyword){
        if(keyword != null){
            model.addAttribute("petlists", this.adminService.findByPetKeyword(keyword));
        }else{
            model.addAttribute("petlists", this.adminService.getAllPet());
        }
        return "/admin/pets/petlist";
    }

    @GetMapping("/petdetail/{id}")
    public String petDetail(@PathVariable("id") int id, Model model){
        model.addAttribute("animaltypes", this.animalTypeService.getAll());
        model.addAttribute("petdata", this.adminService.getByPetId(id));
        return "/admin/pets/petdetail";
    }

    @PostMapping("/petdetail/{id}")
    public String petUpdate(@ModelAttribute("petdata") PetUpdateDto updateDto){
        this.petService.updatePet(updateDto);
        return "redirect:/admin/petdetail/{id}?success";
    }

    @GetMapping("/petdelete/{id}")
    public String deletePet(@PathVariable(value = "id") int id){
        this.adminService.deletePetById(id);
        return "redirect:/admin/petlist?success";
    }



}
