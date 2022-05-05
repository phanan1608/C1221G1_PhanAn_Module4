package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class MusicController {
    @Autowired
    IMusicService iMusicService;

    @GetMapping(value = "/")
    public String goToHome(Model model){
        List<Music> musicList = iMusicService.getList();
        model.addAttribute("music", musicList);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("productForm", new Music());
        return "create";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Music music, RedirectAttributes redirectAttributes) {
        this.iMusicService.save(music);
        redirectAttributes.addFlashAttribute("msg","Create Successfully");
        return "redirect:/";
    }
}
