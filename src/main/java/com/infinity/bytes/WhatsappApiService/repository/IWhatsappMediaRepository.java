package com.infinity.bytes.WhatsappApiService.repository;

import com.infinity.bytes.WhatsappApiService.model.entity.WhatsappFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IWhatsappMediaRepository
    extends JpaRepository<WhatsappFile , Integer> {

    Optional<WhatsappFile> findByHash(String hash);
    Optional<WhatsappFile> findByName(String name);
    Optional<WhatsappFile> findByUploadUrl(String urlUp);



}
