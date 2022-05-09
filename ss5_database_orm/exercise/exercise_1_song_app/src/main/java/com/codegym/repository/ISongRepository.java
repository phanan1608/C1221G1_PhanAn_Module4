package com.codegym.repository;

import com.codegym.model.Song;

import java.util.List;

public interface ISongRepository {
        List<Song> findAll();
        void save(Song song);
        Song findById(Integer id);

        void update(Song song);

        void remove(Song song);
}
