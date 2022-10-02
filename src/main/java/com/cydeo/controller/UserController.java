package com.cydeo.controller;

import com.cydeo.config.bootstrap.DataGenerator;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
private final RoleService roleService;
private final UserService userService;
    public UserController(RoleService roleService,UserService userService) {
        this.roleService = roleService;
        this.userService=userService;
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        //model.addAttribute("user",new User());
        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles",roleService.findAll());
        model.addAttribute("userList",userService.findAll());
        return "/user/create";
    }

    @PostMapping("/create")
    // postmapping refers to the same end point we have to place method=post to the form
    public String addUser(@ModelAttribute("user") UserDTO userDTO) {

      //  model.addAttribute("user", new UserDTO());
        //     model.addAttribute("roles",roleService.findAll());
             userService.save(userDTO);
      //        model.addAttribute("userList",userService.findAll());
        return "redirect:/user/create";
        // somewhat like recursion
        // When we use redirect we don't have to create user DTO or
        // whenever I put a new user I want to see the same page with the updated list
    }

//    @PostMapping("/create")
    // my page is looking for user, roles and userList
//    public String insertUser(Model model){
//        model.addAttribute("user", new UserDTO());
    // model.addAttribute("roles",roleService.findAll();
    // userService.save(userDTO);
   //  model.addAttribute("userList",userService.findAll());
//        return "/user/create";
//    }

    @GetMapping("/update/{username}") // we are not posting anything we are retrieving
 public String editUser(@PathVariable("username") String username,Model model){

        // user object ${user}

     // roles ${roles}

     model.addAttribute("user",userService.findById(username));
     model.addAttribute("role",roleService.findAll()); // display all the roles
     model.addAttribute("users",userService.findAll()); // display all the users

        return "/user/update";
 }
 @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") UserDTO user){
        // update the user -do we have a service
     userService.update(user);
        return "redirect:/user/create";
 }

 @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username")String username,@ModelAttribute("user") UserDTO user){
        userService.deleteById(username);
        return "redirect:/user/create";
 }
}
