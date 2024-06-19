package com.infinity.bytes.WhatsappApiService.controller.adviceController;


import com.infinity.bytes.WhatsappApiService.exception.DataNotFoundException;
import com.infinity.bytes.WhatsappApiService.exception.DataRepeatedException;
import com.infinity.bytes.WhatsappApiService.model.Constants.ResponseDtoEnum;
import com.infinity.bytes.WhatsappApiService.model.dto.ResponseDto;
import org.modelmapper.MappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
public class MainControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return  new ResponseEntity<>(
                ResponseDto.builder()
                        .message(ResponseDtoEnum.ERROR_EN_EL_PROCESO.toString())
                        .success(false)
                        .errors(errors)
                        .data(null)
                        .build()
                , HttpStatusCode.valueOf(400));
    }


    @ExceptionHandler(DataRepeatedException.class)
    public ResponseEntity<?> repeatedHandler(DataRepeatedException dniex) {
        /*
        ErrorResponseDTO dto = ErrorResponseDTO.builQuickResponse(HttpStatus.BAD_REQUEST,
                Collections.singletonList(dniex.getMessage()));
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
*/
       return  new ResponseEntity<>(
                ResponseDto.builder()
                        .message(ResponseDtoEnum.ERROR_EN_EL_PROCESO.toString())
                        .success(false)
                        .errors(Collections.singletonList(dniex.getMessage()))
                        .data(null)
                        .build()
                , HttpStatusCode.valueOf(400));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<?> dataNotFoundHandler(DataNotFoundException dniex) {
        /*
        ErrorResponseDTO dto = ErrorResponseDTO.builQuickResponse(HttpStatus.BAD_REQUEST,
                Collections.singletonList(dniex.getMessage()));
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
*/
        return  new ResponseEntity<>(
                ResponseDto.builder()
                        .message(ResponseDtoEnum.ERROR_EN_EL_PROCESO.toString())
                        .success(false)
                        .errors(Collections.singletonList(dniex.getMessage()))
                        .data(null)
                        .build()
                , HttpStatusCode.valueOf(400));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MappingException.class)
    public ResponseEntity<?> mappingExceptionHandler(MappingException dniex) {
        /*
        ErrorResponseDTO dto = ErrorResponseDTO.builQuickResponse(HttpStatus.BAD_REQUEST,
                Collections.singletonList(dniex.getMessage()));
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
*/
        return  new ResponseEntity<>(
                ResponseDto.builder()
                        .message(ResponseDtoEnum.ERROR_EN_EL_PROCESO.toString())
                        .success(false)
                        .errors(Collections.singletonList(dniex.getMessage()))
                        .data(null)
                        .build()
                , HttpStatusCode.valueOf(400));
    }

}
