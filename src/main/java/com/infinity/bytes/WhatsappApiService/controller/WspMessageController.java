package com.infinity.bytes.WhatsappApiService.controller;


import com.infinity.bytes.WhatsappApiService.model.Constants.ResponseDtoEnum;
import com.infinity.bytes.WhatsappApiService.model.dto.ResponseDto;
import com.infinity.bytes.WhatsappApiService.model.dto.request.WhatsappMessageDtoReq;
import com.infinity.bytes.WhatsappApiService.service.WhatsappMessageService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/wspm")
@RestController
@Validated
public class WspMessageController {
    private WhatsappMessageService whatsappMessageService;

    public WspMessageController(WhatsappMessageService whatsappMessageService) {
        this.whatsappMessageService = whatsappMessageService;
    }

    @PostMapping
    public ResponseEntity<?> postMessage(@Valid @RequestBody WhatsappMessageDtoReq req){

        boolean isCreated = whatsappMessageService.saveMessage(req);
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
