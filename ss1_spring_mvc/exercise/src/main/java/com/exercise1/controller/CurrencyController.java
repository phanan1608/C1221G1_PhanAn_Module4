package com.exercise1.controller;

import com.exercise1.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @Autowired
    private ICurrencyService iCurrencyService;

    @GetMapping(value = "/home-page")
    public String goHomePage(){
        return "home";
    }
    @GetMapping(value = "/result")
    public String convertCurrency(@RequestParam Integer vnd,
                                  @RequestParam Integer usd,
                                  Model model){
        if (vnd!=null){
            model.addAttribute("result1",this.iCurrencyService.convertVNDToUSD(vnd));
        }
        if (usd!=null){
            model.addAttribute("result2",this.iCurrencyService.convertUSDToVND(usd));
        }
        return "home";
    }
}
