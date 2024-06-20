package com.infinity.bytes.WhatsappApiService.service.interfaces;

import java.util.List;
import java.util.Optional;

public abstract  class AbstractMainService<T> implements IMainService<T> {

    @Override
    public T createItem(T newItem) {
        return null;
    }

    @Override
    public List<T> createItemsInBatch(List<T> newItems) {
        return List.of();
    }

    @Override
    public boolean deleteItem(Object id) {
        return false;
    }

    @Override
    public List<T> getAllData() {
        return List.of();
    }

    @Override
    public Optional<T> findItem(Object id) {
        return Optional.empty();
    }

    @Override
    public T updateItem(T updatedItem) {
        return null;
    }
}
