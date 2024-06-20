package com.infinity.bytes.WhatsappApiService.service.interfaces;

import java.util.List;
import java.util.Optional;

public interface IReadService<T>{
    List<T> getAllData();
    Optional<T> findItem(Object id);
}
