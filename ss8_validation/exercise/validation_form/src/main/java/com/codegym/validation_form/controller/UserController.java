package com.codegym.validation_form.controller;

import com.codegym.validation_form.dto.UserDto;
import com.codegym.validation_form.model.User;
import com.codegym.validation_form.service.impl.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/list")
    public String goToList(Model model){
        model.addAttribute("userList",this.userService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        new UserDto().validate(userDto,bindingResult);

        if (bindingResult.hasFieldErrors()){
            return "create";
        }
        else {
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            userService.save(user);
            redirectAttributes.addFlashAttribute("success","Create successfully");
            return "redirect:/user/list";
        }
    }
}
