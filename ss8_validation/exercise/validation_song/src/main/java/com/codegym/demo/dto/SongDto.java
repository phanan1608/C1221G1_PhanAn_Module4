package com.codegym.demo.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto implements Validator {
    private Integer id;


    @NotEmpty(message = "Name {empty.error}")
    @Size(max = 800)
    @Pattern(regexp = "^[^;,.=\\-+…]+$",message = "{special.character}")
    private String name;

    @NotEmpty(message = "Artist {empty.error}")
    @Size(max=300)
    @Pattern(regexp = "^[^;,.=\\-+…]+$",message = "{special.character}")
    private String artist;

    @NotEmpty(message = "Genre {empty.error}")
    @Size(max=1000)
    @Pattern(regexp = "^[^;.=\\-+…]+$",message = "{special.character}")
    private String genre;

    @NotEmpty(message = "Link {empty.error}")
    @Size(max=500)
    private String link;

    public SongDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if (songDto.name.matches("^$")){

        }
    }
}
