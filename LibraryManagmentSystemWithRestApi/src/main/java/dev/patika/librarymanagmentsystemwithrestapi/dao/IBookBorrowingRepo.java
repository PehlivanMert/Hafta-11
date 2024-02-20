package dev.patika.librarymanagmentsystemwithrestapi.dao;

import dev.patika.librarymanagmentsystemwithrestapi.entities.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookBorrowingRepo extends JpaRepository<BookBorrowing,Integer> {
}
