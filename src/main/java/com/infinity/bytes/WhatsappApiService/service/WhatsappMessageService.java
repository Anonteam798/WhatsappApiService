package com.infinity.bytes.WhatsappApiService.service;


import com.infinity.bytes.WhatsappApiService.config.ClassMapper;
import com.infinity.bytes.WhatsappApiService.model.dto.request.WhatsappMessageDtoReq;
import com.infinity.bytes.WhatsappApiService.model.entity.Contact;
import com.infinity.bytes.WhatsappApiService.model.entity.MessageTypes;
import com.infinity.bytes.WhatsappApiService.model.entity.WhatsappMensaje;
import com.infinity.bytes.WhatsappApiService.repository.IWhatsappMsgRepository;
import jakarta.transaction.Transactional;
import jdk.jshell.execution.Util;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;

@Transactional
@Service
@Slf4j
public class WhatsappMessageService  {

    private IWhatsappMsgRepository objWspRepository;
    private ContactServiceImpl contactService;
    private MessageTypeServiceImpl messageTypeService;
    private ClassMapper objMapper;



    public WhatsappMessageService(IWhatsappMsgRepository objWspRepository, ContactServiceImpl contactService, MessageTypeServiceImpl messageTypeService, ClassMapper objMapper) {
        this.objWspRepository = objWspRepository;
        this.contactService = contactService;
        this.messageTypeService = messageTypeService;
        this.objMapper = objMapper;
    }

    public boolean saveMessageChats(WhatsappMessageDtoReq request) {

        //WhatsappMensaje wsp = objMapper.modelMapper().map(request, WhatsappMensaje.class);

        log.debug("Se mapea el objeto DTO a Entidad: "  + request.toString());

        log.debug("Procesando los contactos antes de guardar el mensaje");
        Contact contFrom =  this.contactService.createNewContact(request.getIdContactFrom());
        Contact contTo = this.contactService.createNewContact(request.getIdContactTo());
        MessageTypes findType = this.messageTypeService.findByTypeName(request.getIdTypeMessage()).get();

        WhatsappMensaje newMessage = WhatsappMensaje
                .builder()
                .idTypeMessage(findType)
                .groupId(request.getGroupId())
                .message(request.getMessage())
                .isMediaMessage(request.getIsMediaMessage())
                .uuidMediaMessage(request.getUuidMediaMessage())
                .idWhatsAppFile(request.getIdWhatsAppFile())
                .idContactTo(contTo)
                .idContactFrom(contFrom)
                .build();

        this.objWspRepository.save(newMessage);

        return true;

    }






}
