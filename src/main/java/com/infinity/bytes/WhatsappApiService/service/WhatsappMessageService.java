package com.infinity.bytes.WhatsappApiService.service;


import com.infinity.bytes.WhatsappApiService.config.ClassMapper;
import com.infinity.bytes.WhatsappApiService.model.dto.request.WhatsappMessageDtoReq;
import com.infinity.bytes.WhatsappApiService.model.entity.WhatsappMensaje;
import com.infinity.bytes.WhatsappApiService.repository.IWhatsappMsgRepository;
import jakarta.transaction.Transactional;
import jdk.jshell.execution.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Transactional
@Service
@Slf4j
public class WhatsappMessageService  {

    private IWhatsappMsgRepository objWspRepository;
    private ClassMapper objMapper;

    public WhatsappMessageService(IWhatsappMsgRepository objWspRepository, ClassMapper objMapper) {
        this.objWspRepository = objWspRepository;
        this.objMapper = objMapper;
    }

    public boolean saveMessage(WhatsappMessageDtoReq request) {

        WhatsappMensaje wsp = objMapper.modelMapper().map(request, WhatsappMensaje.class);


        log.debug("Se mapea el objeto DTO a Entidad: "  + wsp.toString());


        return true;

    }






}
