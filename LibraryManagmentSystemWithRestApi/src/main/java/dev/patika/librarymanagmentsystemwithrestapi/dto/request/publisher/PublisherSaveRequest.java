package dev.patika.librarymanagmentsystemwithrestapi.dto.request.publisher;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PublisherSaveRequest {

    @NotNull(message = "İsim kısmı boş veya null olamaz")
    private String name;
    @NotNull(message = "Yıl boş veya null olamaz")
    private String establishmentYear;
    @NotNull(message = "Adres boş veya null olamaz")
    private String address;
}
