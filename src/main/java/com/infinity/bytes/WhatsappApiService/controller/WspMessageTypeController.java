package com.infinity.bytes.WhatsappApiService.controller;


import com.infinity.bytes.WhatsappApiService.config.ClassMapper;
import com.infinity.bytes.WhatsappApiService.model.Constants.ResponseDtoEnum;
import com.infinity.bytes.WhatsappApiService.model.dto.ResponseDto;
import com.infinity.bytes.WhatsappApiService.model.dto.response.MessageTypeDTOResp;
import com.infinity.bytes.WhatsappApiService.model.entity.MessageTypes;
import com.infinity.bytes.WhatsappApiService.service.interfaces.IMainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("wspTypes")
@Slf4j
public class WspMessageTypeController {
    private IMainService<MessageTypes> objMessageTypesIMainService;
    private ClassMapper objObjectMapper;

    public WspMessageTypeController(IMainService<MessageTypes> objMessageTypesIMainService, ClassMapper objObjectMapper) {
        this.objMessageTypesIMainService = objMessageTypesIMainService;
        this.objObjectMapper = objObjectMapper;
    }

    @GetMapping()
    public ResponseEntity<?> getAllWspTypes(){
        log.debug("GET: obteniendo todos los registros de whatsapp tipos mensajes");
        List<MessageTypeDTOResp> messageTypes = this.objMessageTypesIMainService.getAllData()
                .stream().map(x -> this.objObjectMapper.modelMapper().map(x, MessageTypeDTOResp.class))
                .collect(Collectors.toList());

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

    @PostMapping("/register/{name}")
    public ResponseEntity<?> registerNewMessageType(@PathVariable("name") String newMessageType){
        log.debug("Se ha detectado la insercion del nuevo tipo de mensaje: " + newMessageType);
        MessageTypes createdMessageType =  this.objMessageTypesIMainService.createItem(MessageTypes.builder()
                        .type(newMessageType)
                        .dateCreation(new Date())
                        .isActive("S")
                .build());

        return new ResponseEntity<>(
                ResponseDto.builder()
                        .message(ResponseDtoEnum.PROCESO_OK.toString())
                        .success(true)
                        .errors(null)
                        .data(this.objObjectMapper.modelMapper().map(createdMessageType, MessageTypeDTOResp.class))
                        .build()
                , HttpStatusCode.valueOf(200)
        );

    }





}
