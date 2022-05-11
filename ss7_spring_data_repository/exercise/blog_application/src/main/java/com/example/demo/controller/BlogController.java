package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "/list")
    public String goToHome(Model model, @PageableDefault(value = 3) Pageable pageable,
                           @RequestParam Optional<String> keyword, @RequestParam Optional<String> sort ) {
        String createDate = keyword.orElse("");
        String sortBy = sort.orElse("");

        Page<Blog> blogList = blogService.findAll(createDate, pageable);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("blogList", blogList);
        model.addAttribute("createDate", createDate);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("categoryList", categoryList);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", this.categoryService.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        this.blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "Create Successfully");
        return "redirect:/blog/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id) {
        this.blogService.remove(this.blogService.findById(id));
        return "redirect:/blog/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categoryList", this.categoryService.findAll());
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog) {
        this.blogService.update(blog);
        return "redirect:/blog/list";
    }

//    @GetMapping("/search")
//    public String search(@RequestParam String keyword,Model model) {
//        List<Blog> blogList = this.blogService.search(keyword);
//        List<Category> categoryList = categoryService.findAll();
//        model.addAttribute("blogList", blogList);
//        model.addAttribute("categoryList", categoryList);
//        return "index";
//    }

}
