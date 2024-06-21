package com.infinity.bytes.WhatsappApiService.service;

import com.infinity.bytes.WhatsappApiService.model.entity.Configuration;
import com.infinity.bytes.WhatsappApiService.repository.IConfigurationRepository;
import com.infinity.bytes.WhatsappApiService.service.interfaces.AbstractMainService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
@Transactional
public class ConfigurationServiceImpl extends
        AbstractMainService<Configuration> {

    private IConfigurationRepository iConfigurationRepository;

    public ConfigurationServiceImpl(IConfigurationRepository iConfigurationRepository) {
        this.iConfigurationRepository = iConfigurationRepository;
    }

    @Override
    public Configuration createItem(Configuration newItem) {
        return this.iConfigurationRepository.save(newItem);
    }

    @Override
    public List<Configuration> createItemsInBatch(List<Configuration> newItems) {
        return this.iConfigurationRepository.saveAll(newItems);
    }

    @Override
    public Optional<Configuration> findItem(Object id) {
        return this.iConfigurationRepository.findById((int)id);
    }

    @Override
    public Configuration updateItem(Configuration updatedItem) {
        return this.iConfigurationRepository.save(updatedItem);
    }

    @Override
    public boolean deleteItem(Object id) {
        Optional<Configuration> foundConfig =
                findItem(id);

        AtomicBoolean isDeleted = new AtomicBoolean(false);

        foundConfig.ifPresent(configuration ->{
            configuration
                    .setIsActive("N");
            this.iConfigurationRepository.save(foundConfig.get());
            isDeleted.set(true);
        });

        return isDeleted.get();
    }

    @Override
    public List<Configuration> getAllData() {
        return  this.iConfigurationRepository.findAll();
    }
}
