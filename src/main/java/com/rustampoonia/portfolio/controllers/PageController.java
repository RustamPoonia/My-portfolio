package com.rustampoonia.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PageController {

    @GetMapping({"/","","/home"})
    public String openIndexPage(Model model){
         model.addAttribute("title", "home");
        return "basetemplate";
    }
    @GetMapping("/projects")
    public String openProjectsPage(Model model){
        model.addAttribute("title", "projects");
        return "basetemplate";
    }

     @GetMapping("/resume")
    public String openResumePage(Model model){
         model.addAttribute("title", "resume");
        return "basetemplate";
    }

     @GetMapping("/contact")
    public String openContactsPage(Model model){
         model.addAttribute("title", "contact");
        return "basetemplate";
    }
}
