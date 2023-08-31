package com.workintech.zoo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KangarooErrorResponse {

    private int status;
    private String message;
    private long timestamp;
}
