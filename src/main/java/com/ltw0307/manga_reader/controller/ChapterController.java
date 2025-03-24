package com.ltw0307.manga_reader.controller;

import com.ltw0307.manga_reader.model.Chapter;
import com.ltw0307.manga_reader.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mangas/{mangaTitle}-{mangaId}/chapters")
public class ChapterController {
    private ChapterService chapterService;

    @Autowired
    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping("/chapter-{chapterId}")
    public String showChapter(
            @PathVariable String mangaTitle,
            @PathVariable Integer mangaId,
            @PathVariable Integer chapterId,
            Model model
    ) {
        Chapter chapter = chapterService.findByIdAndMangaId(chapterId, mangaId);
        model.addAttribute("chapter", chapter);
        return "reading";
    }
}
