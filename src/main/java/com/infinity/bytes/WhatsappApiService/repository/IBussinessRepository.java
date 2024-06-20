package com.infinity.bytes.WhatsappApiService.repository;

import com.infinity.bytes.WhatsappApiService.model.entity.Bussiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IBussinessRepository
            extends JpaRepository<Bussiness, Integer> {

    List<Bussiness> findByRuc(String ruc);
    List<Bussiness> findByPhone(String phone);
    List<Bussiness> findByRazonSocial(String razonSocial);



}
