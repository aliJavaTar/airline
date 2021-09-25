package hibernatutil.applicationcontext;

import hibernatutil.Jpa;
import repository.AirLineRepository;
import repository.CustomerRepository;
import repository.TicketRepository;
import repository.impl.AirLineRepositoryImpl;
import repository.impl.CustomerRepositoryImpl;
import repository.impl.TicketRepositoryImpl;
import service.AirlineService;
import service.CustomerService;
import service.TicketService;
import service.impl.AirlineServiceImpl;
import service.impl.CustomerServiceImpl;
import service.impl.TicketServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ApplicationContext {

    private static final AirLineRepository airLineRepository;
    private static final AirlineService airlineService;

    private static final CustomerRepository customerRepository;
    private static final CustomerService customerService;

    private static final TicketRepository ticketRepository;
    private static final TicketService ticketService;

    static {

        EntityManager entityManger = Jpa.getEntityMangerFactory().createEntityManager();

        airLineRepository = new AirLineRepositoryImpl(entityManger);
        airlineService = new AirlineServiceImpl(airLineRepository);

        customerRepository = new CustomerRepositoryImpl(entityManger);
        customerService = new CustomerServiceImpl(customerRepository);

        ticketRepository = new TicketRepositoryImpl(entityManger);
        ticketService = new TicketServiceImpl(ticketRepository);
    }

    public static AirLineRepository getAirLineRepository() {
        return airLineRepository;
    }

    public static AirlineService getAirlineService() {
        return airlineService;
    }

    public static CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public static CustomerService getCustomerService() {
        return customerService;
    }

    public static TicketRepository getTicketRepository() {
        return ticketRepository;
    }

    public static TicketService getTicketService() {
        return ticketService;
    }
}
