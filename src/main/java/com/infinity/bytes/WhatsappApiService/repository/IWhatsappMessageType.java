package com.infinity.bytes.WhatsappApiService.repository;

import com.infinity.bytes.WhatsappApiService.model.entity.MessageTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IWhatsappMessageType extends
        JpaRepository<MessageTypes,Integer> {

    //Buscar por nombre
    Optional<MessageTypes> findByType(String type);

}
