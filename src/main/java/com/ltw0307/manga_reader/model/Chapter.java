package com.ltw0307.manga_reader.model;


import jakarta.persistence.*;

@Entity
@Table(name="chapter")
public class Chapter {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="manga_id")
    private int mangaId;

    public Chapter() {

    }

    public Chapter(int mangaId) {
        this.mangaId = mangaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMangaId() {
        return mangaId;
    }

    public void setMangaId(int mangaId) {
        this.mangaId = mangaId;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", mangaId=" + mangaId +
                '}';
    }
}
