package com.infinity.bytes.WhatsappApiService.controller;


import com.infinity.bytes.WhatsappApiService.config.ClassMapper;
import com.infinity.bytes.WhatsappApiService.model.Constants.ResponseDtoEnum;
import com.infinity.bytes.WhatsappApiService.model.dto.ResponseDto;
import com.infinity.bytes.WhatsappApiService.model.dto.response.MessageTypeDTOResp;
import com.infinity.bytes.WhatsappApiService.model.entity.MessageTypes;
import com.infinity.bytes.WhatsappApiService.service.IMainService;
import com.infinity.bytes.WhatsappApiService.service.MessageTypeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("wspTypes")
@Slf4j
public class WhatsappMessageTypeController {
    private IMainService<MessageTypes> objMessageTypesIMainService;
    private ClassMapper objObjectMapper;

    public WhatsappMessageTypeController(IMainService<MessageTypes> objMessageTypesIMainService, ClassMapper objObjectMapper) {
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
}
