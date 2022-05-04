package com.codegym.controller;

import com.codegym.service.ICalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    ICalculationService calculationService;

    @GetMapping("/")
    String getIndex() {
        return "index";
    }

    @RequestMapping("/display")
    public String save(@RequestParam(value = "operator", defaultValue = "") String operator, Integer num1, Integer num2, Model model) {
        String result = null;
        try {
            result = String.valueOf(calculationService.doCalculation(num1, num2, operator));
        } catch (Exception e) {
            result = "Nhap cho dung";
            e.printStackTrace();
        }
        model.addAttribute("result", result);
        return "index";
    }
}
