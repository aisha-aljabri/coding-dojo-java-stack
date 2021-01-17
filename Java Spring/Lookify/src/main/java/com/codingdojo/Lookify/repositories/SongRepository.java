package com.codingdojo.Lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{

    List<Song> findAll();
    List<Song> findByArtistContaining(String artist);
    List<Song> findTop10ByOrderByRatingDesc();
    Long countByTitleContaining(String search);
    Long deleteByTitleStartingWith(String search);
    

}
