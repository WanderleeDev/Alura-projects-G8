package com.xam.literalura.services;

import com.xam.literalura.dtos.BookDto;
import com.xam.literalura.dtos.DataDto;
import com.xam.literalura.mappers.AuthorMapper;
import com.xam.literalura.mappers.BookMapper;
import com.xam.literalura.repository.AuthorRepository;
import com.xam.literalura.repository.Book;
import com.xam.literalura.repository.BookRepository;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BooksDataSource {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private JsonParser jsonParser;

    private final String BASE_URL = "https://gutendex.com";

    private final HttpClient client = HttpClient.newHttpClient();

    public void searchBook(String bookSearched) {
        try {
            var uri = new URIBuilder(this.BASE_URL)
                    .setPath("/books/")
                    .addParameter("search", bookSearched)
                    .build();
            var cleanUrl = uri.toString().replace("+", "%20");
            var request = HttpRequest.newBuilder(URI.create(cleanUrl))
                    .GET()
                    .build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            DataDto data = jsonParser.parse(response.body(), DataDto.class);

            if (data.results().isEmpty()) {
                System.out.println("No book found");
                return;
            }

             data.results()
                     .stream()
                     .findFirst()
                     .map(dto -> {
                         var existsBookInDb = bookRepository.findByTitle(dto.title());

                         if (existsBookInDb.isPresent()) {
                             return existsBookInDb.get();
                         }

                         var authorDto = dto.authors().getFirst();
                         var author = authorRepository.findByName(authorDto.name())
                                 .orElseGet(() -> authorRepository.save(AuthorMapper.toEntity(authorDto)));

                         var book = BookMapper.toEntity(dto);
                         book.setAuthor(author);
                         return bookRepository.save(book);
                     })
                     .ifPresentOrElse(
                             book -> System.out.println("Book found: " + book.getTitle()),
                             () -> System.out.println("Book not found")
                     );
        } catch (
                URISyntaxException |
                RuntimeException |
                InterruptedException |
                IOException e
        ) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void listBooks() {
        System.out.println("--------------------------");
        var books = bookRepository.findAll();

        for (int i = 0; i < books.size(); i++) {
            System.out.printf("%d -->  %s\n", i+1, books.get(i).getTitle());

        }
        System.out.println("--------------------------");
    }

    public void listBooksByAuthorLive() {
        System.out.println("--------------------------");

        var books = bookRepository.findBooksByAuthorLive();

        for (int i = 0; i < books.size(); i++) {
            System.out.printf("%d -->  %s\n", i+1, books.get(i).getTitle());

        }

        System.out.println("--------------------------");
    }
}
