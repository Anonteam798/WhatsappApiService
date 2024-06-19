package com.infinity.bytes.WhatsappApiService.repository;

import com.infinity.bytes.WhatsappApiService.model.entity.MessageTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWhatsappMessageType extends
        JpaRepository<MessageTypes,Integer> {
}
