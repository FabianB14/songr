package com.brooksfabe.songr.contoller;

import com.brooksfabe.songr.model.Album;
import com.brooksfabe.songr.model.AlbumRepository;
import com.brooksfabe.songr.model.Song;
import com.brooksfabe.songr.model.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    @GetMapping("/albums")
    public String getAllAlbums(Model message){
        List<Album> albums = albumRepository.findAll();
        message.addAttribute("albums",albums);
        return "allAlbums";
    }
    @PostMapping("/albums")
    public RedirectView addAlbum(String title, String artist, int songCount, int length, String imageUrl){

        Album album = new Album(title,artist,songCount,length,imageUrl);
        albumRepository.save(album);
        return new RedirectView("/albums");
    }
    @GetMapping("/album/{id}")
    public String getOneAlbum(@PathVariable long id, Model model){
        System.out.println(id);
        Album album = albumRepository.findById(id).get();
        model.addAttribute("album", album);
        return "album";
    }
    @PostMapping("/album/{id}")
    public RedirectView addSong(String title, int trackNumber, int length,@PathVariable long id){
        Album album = albumRepository.findById(id).get();
        Song newSong = new Song(title,trackNumber,length,album);
        songRepository.save(newSong);
        return new RedirectView("/album/{id}");
        }

}
