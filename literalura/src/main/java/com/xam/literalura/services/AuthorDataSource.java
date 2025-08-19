package com.xam.literalura.services;

import com.xam.literalura.repository.AuthorRepository;
import com.xam.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorDataSource {
    @Autowired
    private AuthorRepository authorRepository;

    public void listAuthorsLiving(int year) {
        System.out.println("--------------------------");
        var authors = authorRepository.findAliveInYear(year);

        for (int i = 0; i < authors.size(); i++) {
            System.out.printf("%d -->  %s\n  death year: %d\n", i+1, authors.get(i).getName(), authors.get(i).getYearOfDeath());
        }
        System.out.println("--------------------------");
    }

    public void listAuthors() {
        System.out.println("--------------------------");
        var authors = authorRepository.findAll();

        for (int i = 0; i < authors.size(); i++) {
            System.out.printf("%d -->  %s year of death: %d\n", i+1, authors.get(i).getName(), authors.get(i).getYearOfDeath());

        }
        System.out.println("--------------------------");
    }
}
