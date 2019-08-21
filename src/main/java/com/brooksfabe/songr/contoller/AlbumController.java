package com.brooksfabe.songr.contoller;

import com.brooksfabe.songr.model.Album;
import com.brooksfabe.songr.model.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

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
}
