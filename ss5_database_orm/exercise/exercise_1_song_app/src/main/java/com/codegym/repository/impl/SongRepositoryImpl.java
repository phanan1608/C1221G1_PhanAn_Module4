package com.codegym.repository.impl;

import com.codegym.model.Song;
import com.codegym.repository.BaseRepository;
import com.codegym.repository.ISongRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SongRepositoryImpl implements ISongRepository {
    @Override
    public List<Song> findAll() {
        TypedQuery<Song> typedQuery = BaseRepository.entityManager.createQuery("select s from Song s",Song.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(song);
        entityTransaction.commit();
    }

    @Override
    public Song findById(Integer id) {
        String queryStr = "SELECT s FROM Song AS s WHERE s.id = :id";
        TypedQuery<Song> query =BaseRepository.entityManager.createQuery(queryStr, Song.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void update(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(song);
        entityTransaction.commit();
    }

    @Override
    public void remove(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(song);
        entityTransaction.commit();
    }
}
