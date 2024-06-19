package com.infinity.bytes.WhatsappApiService.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class ResponseDto {
    private boolean success;
    private String message;
    private List<Object> errors;
    private Object data;

}
