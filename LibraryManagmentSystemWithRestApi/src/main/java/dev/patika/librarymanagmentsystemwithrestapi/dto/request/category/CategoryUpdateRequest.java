package dev.patika.librarymanagmentsystemwithrestapi.dto.request.category;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryUpdateRequest {
    @Positive(message = "ID değeri pozitif sayı olmak zorunda")
    private int id;
    @NotNull(message = "Kategori ismi boş veya null olamaz")
    private String name;
    @NotNull(message = "Açıklama kısmı boş veya null olamaz")
    private String description;
}
