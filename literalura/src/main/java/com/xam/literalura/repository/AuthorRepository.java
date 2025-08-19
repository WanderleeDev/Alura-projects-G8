package com.xam.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {

    @Query("""
        SELECT a
        FROM Author a
        WHERE a.yearOfDeath IS NULL OR a.yearOfDeath > :year
    """)
    List<Author> findAliveInYear(@Param("year") int year);

    Optional<Author> findByName(String name);
}
