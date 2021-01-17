package com.codingdojo.Lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.Lookify.models.Song;
import com.codingdojo.Lookify.services.SongService;



@Controller
public class SongsControllers {
    private final SongService songService;
    
    public SongsControllers(SongService songService) {
        this.songService = songService;
    }
    
    @RequestMapping("/")
    public String home() {
    	return "/songs/home.jsp";
    }
    
    @RequestMapping("/dashboard")
    public String index(Model model) {
        List<Song> songs = songService.allSongs();
        model.addAttribute("songs", songs);
        return "/songs/dashboard.jsp";
    }
    
    @RequestMapping("/songs/new")
    public String newBook(@ModelAttribute("song") Song song) {
        return "/songs/new.jsp";
    }
    
    
    @RequestMapping("/songs/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "/songs/show.jsp";
    }
    
    @RequestMapping("/search/topTen")
	public String topten(Model model) {
		List<Song> songs = songService.getTopTen();
		model.addAttribute("songs", songs);
		return "songs/topten.jsp";
	}
    
    @RequestMapping(value="/search", method=RequestMethod.POST)
	public String search(@RequestParam("artist") String artist, Model model) {
    	if(!artist.equals("")) {
    		List<Song> songs = songService.SearchSongs(artist);
		    model.addAttribute("artist", artist);
		    model.addAttribute("songs", songs);
		    return "songs/search.jsp";
    	}
    	else {
    		return "redirect:/dashboard";
    	}
		
	}
	
//	@PostMapping("/search")
//	public String search(@RequestParam("artist") String artist) {
//		return "redirect:/search/"+artist;
//	}
	
	
//    process
    @RequestMapping(value="/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return "redirect:/dashboard";
    }
    
    @RequestMapping(value="/songs", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "/songs/new.jsp";
        } else {
        	songService.createSong(song);
            return "redirect:/dashboard";
        }
    }
    
//    @RequestMapping("/books/{id}/edit")
//    public String edit(@PathVariable("id") Long id, Model model) {
//        Book book = bookService.findBook(id);
//        model.addAttribute("book", book);
//        return "/books/edit.jsp";
//    }
    
//    @RequestMapping(value="/songs/{id}", method=RequestMethod.PUT)
//    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
//        if (result.hasErrors()) {
//            return "/books/edit.jsp";
//        } else {
//            bookService.updateBook(book);
//            return "redirect:/books";
//        }
//    }

}
