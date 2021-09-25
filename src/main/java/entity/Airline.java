package entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import static entity.Airline.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
public class Airline extends Information {
    protected static final String TABLE_NAME ="Airline";

    public Airline() {
    }

    public Airline(String username, String password, String phoneNumber, String email) {
        super(username, password, phoneNumber, email);
    }

}

