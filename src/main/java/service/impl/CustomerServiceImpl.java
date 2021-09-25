package service.impl;

import entity.Airline;
import entity.Customer;
import repository.AirLineRepository;
import repository.CustomerRepository;
import service.AirlineService;
import service.CustomerService;
import service.base.impl.BaseServiceImpl;

public class CustomerServiceImpl extends BaseServiceImpl<Customer,Long, CustomerRepository> implements CustomerService {
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }
}
