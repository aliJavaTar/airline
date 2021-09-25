package repository.impl;

import entity.Airline;
import repository.AirLineRepository;
import repository.base.impl.BaseRepositoryImpl;

import javax.persistence.EntityManager;

public class AirLineRepositoryImpl extends BaseRepositoryImpl<Airline,Long> implements AirLineRepository {
    public AirLineRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Airline> getEntityClass() {
        return Airline.class;
    }
}
