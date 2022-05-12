package com.codegym.demo.service.impl;

import com.codegym.demo.model.Song;
import com.codegym.demo.repository.ISongRepository;
import com.codegym.demo.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(Integer id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Song song) {
        songRepository.save(song);
    }

    @Override
    public void remove(Song song) {
        songRepository.delete(song);
    }
}
