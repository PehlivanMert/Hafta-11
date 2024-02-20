package dev.patika.librarymanagmentsystemwithrestapi.dto.request.category;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategorySaveRequest {

    @NotNull(message = "Kategori adı boş veya null olamaz")
    private String name;
    @NotNull(message = "Açıklama kısmı boş veya null olamaz")
    private String description;
}
