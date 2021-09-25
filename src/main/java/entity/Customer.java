package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static entity.Customer.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
public class Customer extends Information {
    protected static final String TABLE_NAME = "customer";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String FATHER_NAME = "fatherName";
    private static final String NATIONAL_CODE = "nationalCode";

    @Column(name = FIRST_NAME, nullable = false)
    private String firstName;
    @Column(name = LAST_NAME, nullable = false)
    private String lastName;
    @Column(name = FATHER_NAME, nullable = false)
    private String fatherName;
    @Column(name = NATIONAL_CODE, nullable = false)
    private String nationalCode;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String fatherName, String nationalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.nationalCode = nationalCode;
    }

    public Customer(String username, String password, String phoneNumber, String email, String firstName, String lastName, String fatherName, String nationalCode) {
        super(username, password, phoneNumber, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.nationalCode = nationalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }
}
