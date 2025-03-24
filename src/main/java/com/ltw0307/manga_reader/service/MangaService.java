package com.ltw0307.manga_reader.service;

import com.ltw0307.manga_reader.model.Manga;

import java.util.List;

public interface MangaService {
    List<Manga> findAll();
    Manga findById(int id);
    Manga save(Manga manga);
    void delete(int id);
}
