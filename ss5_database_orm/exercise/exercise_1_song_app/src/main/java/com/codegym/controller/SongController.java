package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/song")
public class SongController {
    @Autowired
    ISongService songService;

    @GetMapping(value = "/list")
    public String goToHome(Model model){
        List<Song> songList = songService.findAll();
        model.addAttribute("songList", songList);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("songList", new Song());
        return "create";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Song song, RedirectAttributes redirectAttributes) {
        this.songService.save(song);
        redirectAttributes.addFlashAttribute("msg","Create Successfully");
        return "redirect:/song/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Song song) {
        this.songService.update(song);
        return "redirect:/song/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id){
        this.songService.remove(this.songService.findById(id));
        return "redirect:/song/list";
    }

}
