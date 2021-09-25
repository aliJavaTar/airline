package service.base;

import entity.base.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends BaseEntity<ID>, ID extends Serializable> {
    E save(E e);

    E update(E e);

    E findByID(ID id);

    List<E> findAll();

    void delete(E e);

    boolean deleteByID(E e);

    boolean existsById(ID id);
}

