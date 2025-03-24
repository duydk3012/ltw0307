package com.ltw0307.manga_reader.service;

import com.ltw0307.manga_reader.model.Chapter;

import java.util.List;

public interface ChapterService {
    Chapter findByIdAndMangaId(Integer chapterId, Integer mangaId);
//    List<Chapter> findByMangaId(Integer mangaId);
    void deleteChapter(Integer mangaId, Integer chapterId);
}
