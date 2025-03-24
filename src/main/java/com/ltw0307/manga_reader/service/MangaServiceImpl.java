package com.ltw0307.manga_reader.service;

import com.ltw0307.manga_reader.repository.MangaRepository;
import com.ltw0307.manga_reader.model.Manga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MangaServiceImpl implements MangaService {

    private MangaRepository mangaRepository;

    @Autowired
    public MangaServiceImpl(MangaRepository mangaRepository) {
        this.mangaRepository = mangaRepository;
    }

    @Override
    public List<Manga> findAll() {
        return this.mangaRepository.findAll();
    }

    @Override
    public Manga findById(int id) {
        Optional<Manga> result = this.mangaRepository.findById(id);

        Manga manga = null;

        if (result.isPresent()) {
            manga = result.get();
        } else {
            throw new RuntimeException("Manga not found!");
        }

        return manga;
    }

    @Override
    public Manga save(Manga manga) {
        return this.mangaRepository.save(manga);
    }

    @Override
    public void delete(int id) {
        this.mangaRepository.deleteById(id);
    }
}
