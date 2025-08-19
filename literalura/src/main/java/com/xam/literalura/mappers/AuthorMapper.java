package com.xam.literalura.mappers;

import com.xam.literalura.dtos.AuthorDto;
import com.xam.literalura.repository.Author;
import jakarta.validation.Valid;

public class AuthorMapper {
    public static Author toEntity(@Valid AuthorDto dto) {
        Author author = new Author();
        author.setName(dto.name());
        author.setYearOfBirth(dto.yearOfBirth());
        author.setYearOfDeath(dto.yearOfDeath());

        return author;
    }
}
