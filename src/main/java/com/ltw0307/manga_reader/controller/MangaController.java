package com.ltw0307.manga_reader.controller;

import com.ltw0307.manga_reader.model.Manga;
import com.ltw0307.manga_reader.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/mangas")
public class MangaController {

    private MangaService mangaService;

    @Autowired
    public MangaController(MangaService mangaService) {
        this.mangaService = mangaService;
    }

    @GetMapping("/showDetail")
    public RedirectView redirectToUrl(@RequestParam Integer mangaId) {
        Manga manga = mangaService.findById(mangaId);
        String mangaTitle = manga.getTitle();
        return new RedirectView("/mangas/" + mangaTitle + "-" + mangaId);
    }

    // Xử lý URL mới
    @GetMapping("/{mangaTitle}-{mangaId}")
    public String showDetail(@PathVariable Integer mangaId, Model model) {
        Manga manga = mangaService.findById(mangaId);
        model.addAttribute("manga", manga);
        return "detail";
    }
}
