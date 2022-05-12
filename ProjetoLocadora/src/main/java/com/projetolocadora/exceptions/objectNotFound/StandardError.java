package com.projetolocadora.exceptions.objectNotFound;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StandardError {

    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
