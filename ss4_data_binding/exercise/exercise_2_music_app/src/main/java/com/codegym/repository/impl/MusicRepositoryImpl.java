package com.codegym.repository.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MusicRepositoryImpl implements IMusicRepository {
    static List<Music> musicList = new ArrayList<>();

    static {
        musicList.add(new Music("Song Gio", "Jack 97", "Nhac Tre", "https://zingmp3.vn/album/Song-Gio-Single-Jack-K-ICM/ZZ70OD0I.html"));
        musicList.add(new Music("Hong Nhan", "Jack 97", "Nhac Tre", "https://zingmp3.vn/album/Hong-Nhan-Single-Jack/ZU8U9866.html"));
        musicList.add(new Music("Bac Phan", "Jack 97", "Nhac Tre", "https://zingmp3.vn/album/Bac-Phan-Single-Jack-K-ICM/ZUAEZ8BO.html"));
    }


    @Override
    public void save(Music music) {
        musicList.add(music);
    }

    @Override
    public List<Music> getList() {
        return musicList;
    }
}
