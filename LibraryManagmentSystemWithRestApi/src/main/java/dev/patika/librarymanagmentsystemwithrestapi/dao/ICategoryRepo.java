package dev.patika.librarymanagmentsystemwithrestapi.dao;

import dev.patika.librarymanagmentsystemwithrestapi.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepo extends JpaRepository<Category,Integer> {
}
