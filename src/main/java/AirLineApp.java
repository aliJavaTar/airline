import hibernatutil.applicationcontext.ApplicationContext;
import repository.CustomerRepository;
import service.impl.CustomerServiceImpl;

public class AirLineApp {
    public static void main(String[] args) {
        try {
            ApplicationContext.getAirLineRepository();
            CustomerRepository customerRepository = ApplicationContext.getCustomerRepository();
            ApplicationContext.getTicketRepository();
            ApplicationContext.getCustomerService();
            CustomerServiceImpl customerService = new CustomerServiceImpl(customerRepository);
            customerService.startMenu();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
