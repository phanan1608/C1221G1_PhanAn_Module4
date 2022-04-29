package com.exercise2.controller;

import com.exercise2.service.IDictionaryService;
import com.exercise2.service.impl.DictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

    @Autowired
    IDictionaryService dictionaryService = new DictionaryServiceImpl();

    @GetMapping(value = "/dictionary")
    public String goToHome(){
        return "home";
    }

    @GetMapping(value = "/result")
    public String translate(@RequestParam String keyword, Model model){
        model.addAttribute("result",this.dictionaryService.search(keyword));

        return "home";
    }
}
