package com.codegym.service.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService {
    @Autowired
    IMusicRepository iMusicRepository;

    @Override
    public void save(Music music) {
            iMusicRepository.save(music);
    }

    @Override
    public List<Music> getList() {
        return iMusicRepository.getList();
    }
}
