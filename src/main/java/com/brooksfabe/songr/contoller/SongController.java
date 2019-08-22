package com.brooksfabe.songr.contoller;

import com.brooksfabe.songr.model.AlbumRepository;
import com.brooksfabe.songr.model.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SongController {
    @Autowired
    SongRepository songRepository;
    @Autowired
    AlbumRepository albumRepository;

}
