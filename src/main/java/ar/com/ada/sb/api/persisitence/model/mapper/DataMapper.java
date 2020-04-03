package ar.com.ada.sb.api.persisitence.model.mapper;

import java.util.List;

public interface DataMapper<E, D> {
    E toEntity(D dto);
    D toDto (E entity);

    List<E> toEntity(List<D> dtoList);
    List<D> toDto(List<E> entityList);
}
