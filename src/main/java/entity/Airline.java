package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

import static entity.Airline.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
public class Airline extends Information {
    protected static final String TABLE_NAME = "Airline";

    public Airline() {
    }

    public Airline(String username, String password, String phoneNumber, String email) {
        super(username, password, phoneNumber, email);
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "airline")
    private List<Ticket> ticketList;

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}

