package com.infinity.bytes.WhatsappApiService.controller;


import com.infinity.bytes.WhatsappApiService.model.Constants.ResponseDtoEnum;
import com.infinity.bytes.WhatsappApiService.model.dto.ResponseDto;
import com.infinity.bytes.WhatsappApiService.model.dto.response.MessageTypeDTOResp;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping
    public ResponseEntity<?> testService (HttpServletRequest req){
        log.debug("GET: Test Sevice desde la ip: " + req.getRemoteAddr());
        return new ResponseEntity<>(
                ResponseDto.builder()
                        .message(ResponseDtoEnum.PROCESO_OK.toString())
                        .success(true)
                        .errors(null)
                        .data(null)
                        .build()
                , HttpStatusCode.valueOf(200));

    }
}
