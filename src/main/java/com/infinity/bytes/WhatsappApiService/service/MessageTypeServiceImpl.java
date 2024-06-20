package com.infinity.bytes.WhatsappApiService.service;

import com.infinity.bytes.WhatsappApiService.exception.DataNotFoundException;
import com.infinity.bytes.WhatsappApiService.exception.DataRepeatedException;
import com.infinity.bytes.WhatsappApiService.model.entity.MessageTypes;
import com.infinity.bytes.WhatsappApiService.repository.IWhatsappMessageType;
import com.infinity.bytes.WhatsappApiService.service.interfaces.IMainService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Transactional
@Service
@Slf4j
public class MessageTypeServiceImpl implements IMainService<MessageTypes> {

    private IWhatsappMessageType objIWhatsappMessageType;

    public MessageTypeServiceImpl(IWhatsappMessageType objIWhatsappMessageType) {
        this.objIWhatsappMessageType = objIWhatsappMessageType;

    }

    @Override
    public List<MessageTypes> getAllData() {
        return this.objIWhatsappMessageType.findAll();
    }


    @Override
    public Optional<MessageTypes> findItem(Object id) {

        Optional<MessageTypes> findItem  =  this.objIWhatsappMessageType
                .findById((Integer) id);
        if (findItem.isEmpty()) throw  new DataNotFoundException("No se han encontrado el objeto Mensaje Item con el id: "+id);
        return  findItem;
    }

    public Optional<MessageTypes> findByTypeName(String typeName){
        return this.objIWhatsappMessageType.findByType(typeName);
    }

    @Override
    public MessageTypes createItem(MessageTypes newItem) {
        Optional<MessageTypes> exists = this.objIWhatsappMessageType.findByType(newItem.getType());
        if (exists.isPresent()) throw new DataRepeatedException(String.format("El item \"%s\" ya se encuentra registrado" , newItem.getType()));
        return this.objIWhatsappMessageType.save(newItem);
    }

    @Override
    public List<MessageTypes> createItemsInBatch(List<MessageTypes> newItems) {
        return this.objIWhatsappMessageType.saveAll(newItems);
    }

    @Override
    public MessageTypes updateItem(MessageTypes updatedItem) {
        return null;
    }

    @Override
    public boolean deleteItem(Object id) {
        return false;
    }
}
