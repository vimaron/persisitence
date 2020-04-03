package ar.com.ada.sb.api.persisitence.services;

import java.util.List;

public interface Services<T> {
    T save(T dto);
    List<T> findAll();
    Boolean delete (Long id);
}
