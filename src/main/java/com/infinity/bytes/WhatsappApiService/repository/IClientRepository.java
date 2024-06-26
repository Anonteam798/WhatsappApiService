package com.infinity.bytes.WhatsappApiService.repository;


import com.infinity.bytes.WhatsappApiService.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository
    extends JpaRepository<Client, Integer> {


}
