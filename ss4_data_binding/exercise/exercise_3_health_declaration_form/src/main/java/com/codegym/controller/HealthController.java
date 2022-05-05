package com.codegym.controller;

import com.codegym.model.Health;
import com.codegym.service.IHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HealthController {
    @Autowired
    IHealthService healthService;

    @GetMapping(value = "/home")
    public String goToHome(Model model){
        model.addAttribute("health",this.healthService.getHealth());
        return "index";
    }

    @PostMapping(value = "/save")
    public String saveEmail(@ModelAttribute Health health, RedirectAttributes redirectAttributes){
        this.healthService.save(health);
        redirectAttributes.addFlashAttribute("msg", "update successfully");
        return "redirect:/info";
    }

    @GetMapping(value = "/info")
    public String goToInfo(Model model){
        model.addAttribute("health",this.healthService.getHealth());
        return "info";
    }
}
