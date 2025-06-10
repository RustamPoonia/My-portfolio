package com.rustampoonia.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rustampoonia.portfolio.dto.ContactRequest;
import com.rustampoonia.portfolio.services.EmailService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class PageController {

    private final EmailService emailService;

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
         model.addAttribute("contactRequest", new ContactRequest());
        return "basetemplate";
    }

    @PostMapping("/contact")
    public String handelContactForm(@ModelAttribute ContactRequest contactRequest , BindingResult result, Model model){
        
         model.addAttribute("title", "contact");
        if(result.hasErrors()){
            return "basetemplate";
        }
        
        try {
            emailService.sendMail(contactRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
       model.addAttribute("contactRequest", new ContactRequest()); // reset form
       return "basetemplate";

    }
}
