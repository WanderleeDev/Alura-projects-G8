package com.xam.literalura.mappers;

import com.xam.literalura.dtos.BookDto;
import com.xam.literalura.repository.Author;
import com.xam.literalura.repository.Book;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

public class BookMapper {
    public static Book toEntity(@Valid BookDto dto) {
        Book book = new Book();

        book.setTitle(dto.title());
        book.setLanguages(dto.languages());
        book.setDownloads(dto.downloads());

        return book;
    }
}
