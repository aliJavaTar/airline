package service.impl;

import entity.Airline;
import repository.AirLineRepository;
import service.AirlineService;
import service.base.impl.BaseServiceImpl;

public class AirlineServiceImpl extends BaseServiceImpl<Airline,Long, AirLineRepository> implements AirlineService {
    public AirlineServiceImpl(AirLineRepository repository) {
        super(repository);
    }
}
