package dev.patika.librarymanagmentsystemwithrestapi.dto.request.book;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateRequest {
    @Positive(message = "Id değeri pozitif olmalıdır")
    private int id;
    @NotNull(message = "Kitap adı boş veya null olamaz")
    private String name;
    @NotNull(message = "Yayın Tarihi boş veya null olamaz")
    private int publicationYear;
    @NotNull(message = "Stock boş veya null olamaz")
    private int stock;
    @NotNull(message = "Lütfen Yazar Id Giriniz")
    private int authorId;
    @NotNull(message = "Lütfen Yayıncı Id Giriniz")
    private int publisherId;
}
