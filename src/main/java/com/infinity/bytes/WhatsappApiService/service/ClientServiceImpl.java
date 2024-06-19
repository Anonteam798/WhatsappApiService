package com.infinity.bytes.WhatsappApiService.service;


import com.infinity.bytes.WhatsappApiService.model.entity.Client;
import com.infinity.bytes.WhatsappApiService.repository.IClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ClientServiceImpl implements IMainService<Client> {

    private IClientRepository iClientRepository;

    public ClientServiceImpl(IClientRepository iClientRepository) {
        this.iClientRepository = iClientRepository;
    }

    @Override
    public List<Client> getAllData() {
        return iClientRepository.findAll();
    }

    @Override
    public Optional<Client> findItem(Object id) {
        return iClientRepository.findById((int)id);
    }

    @Override
    public Client createItem(Client newItem) {

        return iClientRepository.save(newItem);
    }

    @Override
    public List<Client> createItemsInBatch(List<Client> newItems) {
        return iClientRepository.saveAll(newItems);
    }

    @Override
    public Client updateItem(Client updatedItem) {
        return iClientRepository.save(updatedItem);
    }

    @Override
    public boolean deleteItem(Object id) {
        Optional<Client> foundItem = findItem((int) id);

        if (foundItem.isEmpty()) throw  new RuntimeException("Cliente not found");
        foundItem.get().setIsActive("N");
        updateItem(foundItem.get());
        return true;
    }
}
