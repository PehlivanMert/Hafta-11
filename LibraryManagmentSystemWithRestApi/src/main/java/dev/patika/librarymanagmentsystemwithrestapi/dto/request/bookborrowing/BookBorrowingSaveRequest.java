package dev.patika.librarymanagmentsystemwithrestapi.dto.request.bookborrowing;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookBorrowingSaveRequest {
    @NotNull(message = "İsim boş veya null olamaz")
    private String borrowerName;
    @NotNull(message = "Mail boş veya null olamaz")
    @Email
    private String borrowerEmail;
    @NotNull(message = "Ödünç Alma Tarihi boş veya null olamaz")
    private LocalDate borrowingDate;
    private LocalDate returnDate;
    private int bookId;
}
