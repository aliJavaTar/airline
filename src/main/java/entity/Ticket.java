package entity;

import entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.sql.Date;
import java.time.LocalDateTime;

import static entity.Ticket.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
public class Ticket extends BaseEntity<Long> {
    protected static final String TABLE_NAME = "ticket";
    private static final String CREATED_AT = "created_at";
    private static final String PRICE = "price";
    private static final String DEPARTURE_DATE = "departure_date";
    private static final String RETURN_DATE = "return_date";
    private static final String BEGINNING = "beginning";
    private static final String GOAL = "goal";
    private static final String CLASS = "class";
    private static final String FLIGHT_NUMBER = "flight_number";

    @Column(name = CREATED_AT)
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = PRICE, nullable = false)
    private int price;
    @Column(name = DEPARTURE_DATE, nullable = false)
    private Date departureDate;
    @Column(name = RETURN_DATE)
    private Date returnDate;
    @Column(name = BEGINNING, nullable = false)
    private String beginning;
    @Column(name = GOAL, nullable = false)
    private String goal;
    @Column(name = CLASS, nullable = false)
    private String flightClass;
    @Column(name = FLIGHT_NUMBER, nullable = false)
    private int flightNumber;

    public Ticket() {
    }

    public Ticket(LocalDateTime createdAt, int price, Date departureDate, Date returnDate,
                  String beginning, String goal, String flightClass, int flightNumber) {
        this.createdAt = createdAt;
        this.price = price;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.beginning = beginning;
        this.goal = goal;
        this.flightClass = flightClass;
        this.flightNumber = flightNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getBeginning() {
        return beginning;
    }

    public void setBeginning(String beginning) {
        this.beginning = beginning;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }
}
