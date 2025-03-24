package com.ltw0307.manga_reader.repository;

import com.ltw0307.manga_reader.model.Manga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MangaRepository extends JpaRepository<Manga, Integer> {
}
