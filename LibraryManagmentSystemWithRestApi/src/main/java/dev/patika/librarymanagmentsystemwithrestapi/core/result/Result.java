package dev.patika.librarymanagmentsystemwithrestapi.core.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Result {
    private boolean status;
    private String message;
    private String httpCode;

}
