package com.infinity.bytes.WhatsappApiService.service;


import com.infinity.bytes.WhatsappApiService.config.ClassMapper;
import com.infinity.bytes.WhatsappApiService.model.dto.request.BussinessDtoReq;
import com.infinity.bytes.WhatsappApiService.model.entity.Bussiness;
import com.infinity.bytes.WhatsappApiService.model.entity.Configuration;
import com.infinity.bytes.WhatsappApiService.repository.IBussinessRepository;
import com.infinity.bytes.WhatsappApiService.service.interfaces.AbstractMainService;
import com.infinity.bytes.WhatsappApiService.util.Constants;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@Service
@Transactional
public class BussinessServiceImpl
extends AbstractMainService<Bussiness> {

    private IBussinessRepository iBussinessRepository;
    private ConfigurationServiceImpl configurationService;
    private ClassMapper classMapper;

    public BussinessServiceImpl(IBussinessRepository iBussinessRepository, ConfigurationServiceImpl configurationService, ClassMapper classMapper) {
        this.iBussinessRepository = iBussinessRepository;
        this.configurationService = configurationService;
        this.classMapper = classMapper;
    }

    public List<BussinessDtoReq> convertEntityToDto(List<Bussiness> bus){
        return
                bus.stream().map(b -> classMapper.modelMapper().map(b, BussinessDtoReq.class))
                        .collect(Collectors.toList());

    }

    @Override
    public Bussiness createItem(Bussiness newItem) {
        Bussiness createdBussiness = iBussinessRepository.save(newItem);
        newItem
                .getConfigurationCollection()
                .forEach(configuration -> configuration.setBussinessId(
                        Bussiness.builder().id(createdBussiness.getId()).build()
                ));


        this.configurationService
                .createItemsInBatch((List<Configuration>)
                        newItem.getConfigurationCollection());



        return createdBussiness;
    }

    public Collection<Bussiness> getAllActiveBussiness(){
        return  iBussinessRepository.findByIsActive(Constants.ACTIVE_FLAG);
    }

    public List<Bussiness> findByRucOrRazonSocialContaining(String ruc,String razonSocial){
        return iBussinessRepository.findByRucOrRazonSocialContaining(ruc,razonSocial);
    }

    @Override
    public List<Bussiness> createItemsInBatch(List<Bussiness> newItems) {
        return iBussinessRepository.saveAllAndFlush(newItems);
    }

    @Override
    public boolean deleteItem(Object id) {

        Optional<Bussiness> bussiness =
                findItem(id);

        AtomicBoolean isDeleted = new AtomicBoolean(false);

        bussiness.ifPresent(configuration ->{
            configuration
                    .setIsActive("N");
            this.iBussinessRepository.save(bussiness.get());
            isDeleted.set(true);
        });

        return isDeleted.get();
    }

    @Override
    public List<Bussiness> getAllData() {
        return iBussinessRepository.findAll();
    }


    public List<Bussiness> findByRuc(String ruc){
        return iBussinessRepository.findByRuc(ruc);

    }

    public List<Bussiness> findByRazonSocial(String razonSocial){
        return iBussinessRepository.findByRazonSocial(razonSocial);

    }


    @Override
    public Optional<Bussiness> findItem(Object id) {
        return Optional.empty();
    }

    @Override
    public Bussiness updateItem(Bussiness updatedItem) {
        return super.updateItem(updatedItem);
    }
}
