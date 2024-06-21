package com.infinity.bytes.WhatsappApiService.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class ResponseDto {
    private boolean success;
    private String message;
    private Object errors;
    private Object data;

    @JsonIgnore
    private int responseCode;

}
