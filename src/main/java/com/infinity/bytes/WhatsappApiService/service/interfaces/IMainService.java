package com.infinity.bytes.WhatsappApiService.service.interfaces;


public interface IMainService<T> extends
        IReadService<T>,
        ICreateService<T>,
        IUpdateService<T>,
        IDeleteService<T> {

    /*
    List<T> getAllData();
    Optional<T> findItem(Object id);
    T createItem(T newItem);
    List<T> createItemsInBatch(List<T> newItems);
    T updateItem(T updatedItem);
    boolean deleteItem(Object id);
     */
}
