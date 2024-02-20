package dev.patika.librarymanagmentsystemwithrestapi.dto.request.author;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorUpdateRequest {
    @Positive(message = "ID değeri pozitif sayı olmak zorunda")
    private int id;
    @NotNull(message = "Yazar adı boş veya null olamaz")
    private String name;
    @NotNull(message = "Doğum Tarihi boş veya null olamaz")
    private LocalDate birthDate;
    @NotNull(message = "Ülke boş veya null olamaz")
    private String country;
}

