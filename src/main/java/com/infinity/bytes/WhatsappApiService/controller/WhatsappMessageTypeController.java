package com.infinity.bytes.WhatsappApiService.controller;


import com.infinity.bytes.WhatsappApiService.model.Constants.ResponseDtoEnum;
import com.infinity.bytes.WhatsappApiService.model.dto.ResponseDto;
import com.infinity.bytes.WhatsappApiService.model.entity.MessageTypes;
import com.infinity.bytes.WhatsappApiService.service.IMainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wspTypes")
@Slf4j
public class WhatsappMessageTypeController {
    private IMainService<MessageTypes> objMessageTypesIMainService;

    public WhatsappMessageTypeController(IMainService<MessageTypes> objMessageTypesIMainService) {
        this.objMessageTypesIMainService = objMessageTypesIMainService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllWspTypes(){
        log.debug("GET: obteniendo todos los registros de whatsapp tipos mensajes");
        List<MessageTypes> messageTypes = this.objMessageTypesIMainService.getAllData();
        log.debug("Total de registros: {}", messageTypes.size());

            return new ResponseEntity<>(
                    ResponseDto.builder()
                            .message(messageTypes.isEmpty()?"No se han encontrado registros": ResponseDtoEnum.PROCESO_OK.toString())
                            .success(true)
                            .errors(null)
                            .data(messageTypes)
                            .build()
                    , HttpStatusCode.valueOf(200)
            );
    }
}
