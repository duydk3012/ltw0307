package com.ltw0307.manga_reader.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class MangaReaderService {
    @Value("${upload.dir}") // Thêm vào application.properties: upload.dir=src/main/resources/static/assets/images
    private String uploadDir;

    public List<String> getMangaPages(Integer mangaId) {
        List<String> pages = new ArrayList<>();
        Path mangaPath = Paths.get(uploadDir, "sakamoto-day", mangaId.toString());

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(mangaPath, "*.{jpg,png,jpeg}")) {
            stream.forEach(file -> {
                String filename = file.getFileName().toString();
                pages.add("/images/sakamoto-day/" + mangaId + "/" + filename);
            });

            // Sắp xếp theo số thứ tự
            pages.sort((a, b) -> {
                int numA = extractNumber(a);
                int numB = extractNumber(b);
                return Integer.compare(numA, numB);
            });

        } catch (IOException e) {
            throw new RuntimeException("Error reading manga pages", e);
        }

        return pages;
    }

    private int extractNumber(String filename) {
        String num = filename.replaceAll("[^0-9]", "");
        return num.isEmpty() ? 0 : Integer.parseInt(num);
    }
}
