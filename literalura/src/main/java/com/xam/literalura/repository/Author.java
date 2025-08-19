package com.xam.literalura.repository;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "authors")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column(nullable = false, unique = true)
    String name;

    @Column(nullable = false, name = "year_of_birth")
    int yearOfBirth;

    @Column(nullable = true, name = "year_of_death")
    int yearOfDeath;
}
