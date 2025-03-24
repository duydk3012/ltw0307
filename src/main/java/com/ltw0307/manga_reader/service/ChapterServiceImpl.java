package com.ltw0307.manga_reader.service;

import com.ltw0307.manga_reader.repository.ChapterRepository;
import com.ltw0307.manga_reader.repository.MangaRepository;
import com.ltw0307.manga_reader.model.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService{
    private MangaRepository mangaRepository;
    private ChapterRepository chapterRepository;

    @Autowired
    public ChapterServiceImpl(MangaRepository mangaRepository, ChapterRepository chapterRepository) {
        this.mangaRepository = mangaRepository;
        this.chapterRepository = chapterRepository;
    }

    @Override
    public Chapter findByIdAndMangaId(Integer chapterId, Integer mangaId) {
        return this.chapterRepository.findByIdAndMangaId(chapterId, mangaId);
    }

//    @Override
//    public List<Chapter> findByMangaId(Integer mangaId) {
//        return chapterRepository.findByMangaIdOrderByNumberDesc(mangaId);
//    }

    @Override
    public void deleteChapter(Integer mangaId, Integer chapterId) {
        Chapter chapter = findByIdAndMangaId(chapterId, mangaId);
        chapterRepository.delete(chapter);
    }
}
