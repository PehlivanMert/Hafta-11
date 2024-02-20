package dev.patika.librarymanagmentsystemwithrestapi.dao;

import dev.patika.librarymanagmentsystemwithrestapi.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPublisherRepo extends JpaRepository<Publisher,Integer> {
}
