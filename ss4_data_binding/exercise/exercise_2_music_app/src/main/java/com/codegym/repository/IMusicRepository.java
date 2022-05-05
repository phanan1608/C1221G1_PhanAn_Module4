package com.codegym.repository;

import com.codegym.model.Music;

import java.util.List;

public interface IMusicRepository {
    void save(Music music);

    List<Music> getList();

}
