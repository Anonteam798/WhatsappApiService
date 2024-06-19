package com.infinity.bytes.WhatsappApiService.seeder;

import com.infinity.bytes.WhatsappApiService.model.Constants.MessageTypesEnum;
import com.infinity.bytes.WhatsappApiService.model.entity.MessageTypes;
import com.infinity.bytes.WhatsappApiService.service.IMainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class MainRecords implements CommandLineRunner {
    private IMainService<MessageTypes> objMessageService ;

    public MainRecords(IMainService<MessageTypes> objMessageService) {
        this.objMessageService = objMessageService;
    }

    @Override
    public void run(String... args) throws Exception {
        //Busqueda de los tipos de mensajes

        List<?> allTypeMessages = this
                .objMessageService.getAllData();

        if (allTypeMessages.isEmpty()){
            List<MessageTypes> allTypesToSave =
                    new ArrayList<>();
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.TEXT.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.AUDIO.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.VOICE.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.IMAGE.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.VIDEO.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.DOCUMENT.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.STICKER.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.LOCATION.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.CONTACT_CARD.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.CONTACT_CARD_MULTI.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.ORDER.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.REVOKED.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.PRODUCT.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.UNKNOWN.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.GROUP_INVITE.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.LIST.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.LIST_RESPONSE.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.BUTTONS_RESPONSE.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.PAYMENT.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.BROADCAST_NOTIFICATION.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.CALL_LOG.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.CIPHERTEXT.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.DEBUG.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.E2E_NOTIFICATION.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.GP2.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.GROUP_NOTIFICATION.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.HSM.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.INTERACTIVE.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.NATIVE_FLOW.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.NOTIFICATION.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.NOTIFICATION_TEMPLATE.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.OVERSIZED.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.PROTOCOL.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.REACTION.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.TEMPLATE_BUTTON_REPLY.toString()).build());
            allTypesToSave.add(MessageTypes.builder().isActive("S").dateCreation(new Date()).type(MessageTypesEnum.POLL_CREATION.toString()).build());

            this.objMessageService.createItemsInBatch(allTypesToSave);

            log.debug(String.format("Se han guardado %s entidades de MessageType", allTypesToSave.size()));


        }





    }
}
