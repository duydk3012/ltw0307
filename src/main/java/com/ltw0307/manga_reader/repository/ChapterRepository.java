package com.ltw0307.manga_reader.repository;

import com.ltw0307.manga_reader.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter, Integer> {
    @Query("SELECT c FROM Chapter c WHERE c.id = :chapterId AND c.manga.id = :mangaId")
    Chapter findByIdAndMangaId(
            @Param("chapterId") Integer chapterId,
            @Param("mangaId") Integer mangaId
    );

//    List<Chapter> findByMangaIdOrderByNumberDesc(Integer mangaId);
}
