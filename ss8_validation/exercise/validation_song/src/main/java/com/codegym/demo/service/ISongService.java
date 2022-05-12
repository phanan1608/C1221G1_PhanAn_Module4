package com.codegym.demo.service;

import com.codegym.demo.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);
    Song findById(Integer id);

    void update(Song song);

    void remove(Song song);
}
