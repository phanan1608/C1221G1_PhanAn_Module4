package com.codegym.demo.controller;

import com.codegym.demo.dto.SongDto;
import com.codegym.demo.model.Song;
import com.codegym.demo.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute @Validated SongDto songDto, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,Model model) {
        new SongDto().validate(songDto,bindingResult);

        if (bindingResult.hasFieldErrors()){
            return "create";
        }
        else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto,song);
            this.songService.save(song);
            redirectAttributes.addFlashAttribute("msg","Create Successfully");
            return "redirect:/song/list";
        }
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
