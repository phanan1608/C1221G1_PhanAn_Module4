package com.codegym.service;

import com.codegym.model.Music;

import java.util.List;

public interface IMusicService {
    void save(Music music);

    List<Music> getList();
}
