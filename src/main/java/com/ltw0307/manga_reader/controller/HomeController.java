package com.ltw0307.manga_reader.controller;

import com.ltw0307.manga_reader.model.Manga;
import com.ltw0307.manga_reader.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    private MangaService mangaService;

    @Autowired
    public HomeController(MangaService mangaService) {
        this.mangaService = mangaService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Manga> mangas = mangaService.findAll();
        model.addAttribute("mangas", mangas);
        return "index";
    }

}
