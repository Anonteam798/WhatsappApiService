package com.infinity.bytes.WhatsappApiService.controller;


import com.infinity.bytes.WhatsappApiService.model.Constants.ResponseDtoEnum;
import com.infinity.bytes.WhatsappApiService.model.dto.ResponseDto;
import com.infinity.bytes.WhatsappApiService.model.dto.request.WhatsappMessageDtoReq;
import com.infinity.bytes.WhatsappApiService.model.dto.request.WspMediaFileDtoReq;
import com.infinity.bytes.WhatsappApiService.service.WhatsappMediaServiceImpl;
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

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@RequestMapping("/wspm")
@RestController
@ToString
@Validated
@Slf4j
public class WspMessageController {

    private WhatsappMessageService whatsappMessageService;
    private WhatsappMediaServiceImpl whatsappMediaService;

    public WspMessageController(WhatsappMessageService whatsappMessageService, WhatsappMediaServiceImpl whatsappMediaService) {
        this.whatsappMessageService = whatsappMessageService;
        this.whatsappMediaService = whatsappMediaService;
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

    @PostMapping("/media")
    public ResponseEntity<?> postMediaMessage
            (@Valid @RequestBody WspMediaFileDtoReq req){

        log.debug("POST: /media ");
        log.debug("Data de entrada: {}" , req
                .toString());

       Integer id =  whatsappMediaService.createMedia(req);
        Map<String, Integer> response = Collections
                .singletonMap("idResult", id);

        return new ResponseEntity<>(
                ResponseDto.builder()
                        .message(id == 0 ? ResponseDtoEnum.ERROR_EN_EL_PROCESO.toString(): ResponseDtoEnum.PROCESO_OK.toString())
                        .success(id != 0)
                        .errors(null)
                        .data(response)
                        .build()
                , HttpStatusCode.valueOf(200)
        );
    }




}
