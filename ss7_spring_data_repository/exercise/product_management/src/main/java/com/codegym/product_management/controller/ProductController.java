package com.codegym.product_management.controller;

import com.codegym.product_management.model.Product;
import com.codegym.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("/list")
    public String goToProductList(Model model, @PageableDefault(value = 5) Pageable pageable, @RequestParam Optional<String> keyword){
        String name = keyword.orElse("");
        model.addAttribute("name_keyword",name);
        model.addAttribute("products",this.productService.findAll(pageable,name));
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        this.productService.save(product);
        redirectAttributes.addFlashAttribute("success","Create Successfully!!!");
        return "redirect:/product/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", this.productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        this.productService.update(product);
        return "redirect:/product/list";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", this.productService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        this.productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/product/";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", this.productService.findById(id));
        return "/view";
    }

}
