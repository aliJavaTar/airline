package repository.impl;

import entity.Ticket;
import repository.TicketRepository;
import repository.base.impl.BaseRepositoryImpl;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TicketRepositoryImpl extends BaseRepositoryImpl<Ticket, Long> implements TicketRepository {
    public TicketRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    static Scanner input = new Scanner(System.in);

    public void createTicket() {
        Ticket ticket = new Ticket();
        inputTicket(ticket);
        menuCreate();
    }

    private void menuCreate() {
        System.out.println(" 1) do you want Create new ticket ? ");
        System.out.println(" 2) Exit ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                createTicket();
                break;
            case 2:
                System.exit(0);
            default:
                menuCreate();
        }
    }

    private Ticket inputTicket(Ticket ticket) {
        System.out.println("enter Beginning : ");
        String begin = input.next();
        ticket.setBeginning(begin);

        System.out.println("enter goal : ");
        String goal = input.next();
        ticket.setGoal(goal);


        LocalDateTime departureDate = selectDate();
        ticket.setDepartureDate(departureDate);

        System.out.println("enter price");
        int price = input.nextInt();
        ticket.setPrice(price);

        System.out.println(" enter class of you flight : ");
        String flightClass = input.next();
        ticket.setFlightClass(flightClass);

        System.out.println("do you want set ReturnDate ? ");
        String answer = input.next();
        if (answer.equals("yes"))
            ticket.setReturnDate(selectDate());
        else System.out.println("done");

        return ticket;
    }

    private LocalDateTime selectDate() {
        System.out.println("enter departureDate : ( year \n month \n dayOfMonth \n hour \n minute ");
        int year = input.nextInt();
        int month = input.nextInt();
        int dayOfMonth = input.nextInt();
        int hour = input.nextInt();
        int minute = input.nextInt();
        LocalDateTime dateTime = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
        return dateTime;
    }

    @Override
    public Ticket save(Ticket ticket) {
        return super.save(ticket);
    }

    @Override
    public Class<Ticket> getEntityClass() {
        return Ticket.class;
    }
}
