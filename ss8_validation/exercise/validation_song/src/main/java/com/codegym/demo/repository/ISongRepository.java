package com.codegym.demo.repository;

import com.codegym.demo.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ISongRepository extends JpaRepository<Song,Integer> {
}
