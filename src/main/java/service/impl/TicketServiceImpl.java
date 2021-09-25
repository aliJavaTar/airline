package service.impl;

import entity.Customer;
import entity.Ticket;
import repository.CustomerRepository;
import repository.TicketRepository;
import service.CustomerService;
import service.TicketService;
import service.base.impl.BaseServiceImpl;

public class TicketServiceImpl extends BaseServiceImpl<Ticket,Long, TicketRepository> implements TicketService {
    public TicketServiceImpl(TicketRepository repository) {
        super(repository);
    }
}
