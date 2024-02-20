package dev.patika.librarymanagmentsystemwithrestapi.dto.request.bookborrowing;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingUpdateRequest {
    @Positive(message = "ID değeri pozitif sayı olmak zorunda")
    private int id;
    @NotNull(message = "İsim boş veya null olamaz")
    private String borrowerName;
    @NotNull(message = "Ödünç Alma Tarihi boş veya null olamaz")
    private LocalDate borrowingDate;
    private LocalDate returnDate;
    private int bookId;
}
