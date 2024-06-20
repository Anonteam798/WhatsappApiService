package com.infinity.bytes.WhatsappApiService.service.interfaces;

import java.util.List;

public interface ICreateService<T> {
    T createItem(T newItem);
    List<T> createItemsInBatch(List<T> newItems);
}
