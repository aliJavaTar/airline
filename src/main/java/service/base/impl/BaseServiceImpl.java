package service.base.impl;


import entity.base.BaseEntity;
import repository.base.BaseRepository;
import service.base.BaseService;

import java.io.Serializable;
import java.util.List;

public class BaseServiceImpl< E extends BaseEntity < ID >,ID extends Serializable ,R extends BaseRepository < E ,ID > >
        implements BaseService<E, ID> {

    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E e) {
        return repository.save(e);
    }

    @Override
    public E update(E e) {
        return repository.update(e);
    }

    @Override
    public E findByID(ID id) {
        return repository.findByID(id);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(E e) {
      repository.delete(e);
    }

    @Override
    public boolean deleteByID(E e) {
         return repository.deleteByID(e);
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }
}
