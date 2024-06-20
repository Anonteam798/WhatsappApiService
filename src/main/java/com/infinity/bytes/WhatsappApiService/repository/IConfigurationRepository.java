package com.infinity.bytes.WhatsappApiService.repository;

import com.infinity.bytes.WhatsappApiService.model.entity.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IConfigurationRepository extends JpaRepository<Configuration, Integer> {

    List<Configuration> findByBussinessId_Id(int bussinesId);


}
