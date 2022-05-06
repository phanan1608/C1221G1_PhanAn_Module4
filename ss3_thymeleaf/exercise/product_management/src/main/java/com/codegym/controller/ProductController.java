package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("")
    public String goToProductList(Model model){
        model.addAttribute("products",this.productService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        product.setId(String.valueOf(Math.round(Math.random() * 10000)));
        this.productService.save(product);
        redirectAttributes.addFlashAttribute("success","Create Successfully!!!");
        return "redirect:/product/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", this.productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        this.productService.update(Integer.parseInt(product.getId()), product);
        return "redirect:/product/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", this.productService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        this.productService.remove(Integer.parseInt(product.getId()));
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/product/";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", this.productService.findById(id));
        return "/view";
    }

}
