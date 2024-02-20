package dev.patika.librarymanagmentsystemwithrestapi.dto.response.author;

import dev.patika.librarymanagmentsystemwithrestapi.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponse {
    private int id;
    private String name;
    private LocalDate birthDate;
    private String country;
}
