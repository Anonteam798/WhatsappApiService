package com.infinity.bytes.WhatsappApiService.controller;


import com.infinity.bytes.WhatsappApiService.model.Constants.ResponseDtoEnum;
import com.infinity.bytes.WhatsappApiService.model.dto.ResponseDto;
import com.infinity.bytes.WhatsappApiService.model.dto.request.WhatsappMessageDtoReq;
import com.infinity.bytes.WhatsappApiService.service.WhatsappMessageService;
import jakarta.validation.Valid;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/wspm")
@RestController
@ToString
@Validated
@Slf4j
public class WspMessageController {

    private WhatsappMessageService whatsappMessageService;

    public WspMessageController(WhatsappMessageService whatsappMessageService) {
        this.whatsappMessageService = whatsappMessageService;
    }

    @PostMapping
    public ResponseEntity<?> postMessage(@Valid @RequestBody WhatsappMessageDtoReq req){
        log.debug("Nuevo mensaje detectado para guardar: ");
        log.debug(req.toString());
        boolean isCreated = whatsappMessageService.saveMessageChats(req);


        return new ResponseEntity<>(
                ResponseDto.builder()
                        .message(ResponseDtoEnum.PROCESO_OK.toString())
                        .success(isCreated)
                        .errors(null)
                        .data(null)
                        .build()
                , HttpStatusCode.valueOf(200)
        );

    }




}
