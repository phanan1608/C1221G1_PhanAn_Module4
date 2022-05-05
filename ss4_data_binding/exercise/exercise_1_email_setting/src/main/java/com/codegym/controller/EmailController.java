package com.codegym.controller;

import com.codegym.model.Email;
import com.codegym.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {
    @Autowired
    IEmailService emailService;
    @GetMapping(value = "/")
    public String goToHome(Model model){
        model.addAttribute("email",this.emailService.getEmail());
        return "index";
    }

    @PostMapping(value = "/")
    public String saveEmail(@ModelAttribute Email email, RedirectAttributes redirectAttributes){
        this.emailService.save(email);
        redirectAttributes.addFlashAttribute("msg", "update successfully");
        return "redirect:/";
    }
}
