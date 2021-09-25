package repository.impl;

import entity.Customer;
import org.dom4j.tree.BaseElement;
import repository.CustomerRepository;
import repository.base.impl.BaseRepositoryImpl;

import javax.persistence.EntityManager;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer,Long> implements CustomerRepository {
    public CustomerRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
