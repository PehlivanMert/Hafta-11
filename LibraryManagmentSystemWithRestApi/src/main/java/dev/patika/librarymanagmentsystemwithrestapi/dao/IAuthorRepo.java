package dev.patika.librarymanagmentsystemwithrestapi.dao;

import dev.patika.librarymanagmentsystemwithrestapi.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepo extends JpaRepository<Author,Integer> {
}
