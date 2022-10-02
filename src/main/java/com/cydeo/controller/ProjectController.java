package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project")

public class ProjectController {
    private final UserService userServiceImpl;
    private final ProjectService projectService;

    public ProjectController(UserService userServiceImpl, ProjectService projectService) {
        this.userServiceImpl = userServiceImpl;
        this.projectService = projectService;
    }

    @RequestMapping("/create")
    public String createProject(Model model){
        model.addAttribute("project",new ProjectDTO());
      model.addAttribute("managers",userServiceImpl.findAll());
      model.addAttribute("projects",projectService.findAll());
        return "/project/create";
    }
    @PostMapping ("/create")
    public String insertProject(@ModelAttribute("project") ProjectDTO project){

        projectService.save(project);
        return "redirect:/project/create";
    }
@GetMapping("/delete/{projectCode}")
    public String deleteProject(@PathVariable("projectCode") String projectCode){
        projectService.deleteById(projectCode);
        return "redirect: project/create";
}

}
