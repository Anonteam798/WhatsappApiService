package com.infinity.bytes.WhatsappApiService.service;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IMainService<T> {

    List<T> getAllData();
    Optional<T> findItem(Object id);
    T createItem(T newItem);
    List<T> createItemsInBatch(List<T> newItems);
    T updateItem(T updatedItem);
    boolean deleteItem(Object id);

}
