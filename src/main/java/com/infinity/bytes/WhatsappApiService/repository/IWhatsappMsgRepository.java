package com.infinity.bytes.WhatsappApiService.repository;


import com.infinity.bytes.WhatsappApiService.model.entity.WhatsappMensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWhatsappMsgRepository extends JpaRepository<WhatsappMensaje, Integer> {
}
