package com.xam.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    boolean existsByTitle(String title);

    Optional<Book> findByTitle(String title);

    @Query("""
        SELECT b
        FROM Book b
        WHERE b.author IN (
            SELECT a
            FROM Author a
            WHERE a.yearOfDeath IS NULL OR a.yearOfDeath > 2025
        )
    """)
    List<Book> findBooksByAuthorLive();
}
