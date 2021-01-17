package com.codingdojo.Lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.Lookify.models.Song;
import com.codingdojo.Lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }
	
	public List<Song> allSongs() {
        return songRepository.findAll();
    }

    public Song createSong(Song s) {
        return songRepository.save(s);
    }

    public Song findSong(Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }
    public Song updateSong(Long id, String title, String artist, Integer rating) {
    	Optional <Song> song = songRepository.findById(id);
    	if(song != null) {
    		Song theSong = song.get();
    		theSong.setTitle(title);
    		theSong.setArtist(artist);
    		theSong.setRating(rating);
    		return songRepository.save(theSong);
    	}
    	return null;        
    }
    public Song updateSong(Song s) {
    	return songRepository.save(s);
    } 
    
    // deletes a book
    public void deleteSong(Long id) {
    	songRepository.deleteById(id);
    }
    
    public List<Song> getTopTen(){
		return songRepository.findTop10ByOrderByRatingDesc();
	}
    
    public List<Song> SearchSongs(String artist){
		return songRepository.findByArtistContaining(artist);
	}

}
