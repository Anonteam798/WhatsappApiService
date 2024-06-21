package com.infinity.bytes.WhatsappApiService.util;


import com.infinity.bytes.WhatsappApiService.model.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@Slf4j
public class QuickResponseUtil {

    /**
     * Encargado de generar rapidamente un objeto responseEntity
     * @param respDto
     * @return
     */
    public static
        ResponseEntity<? > returnResponse(ResponseDto respDto){
        return new ResponseEntity<>(
                respDto,
                HttpStatusCode.valueOf(respDto.getResponseCode())
        );
    }




}
