package entity;

import entity.base.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance
public class Information extends BaseEntity<Long> {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String EMAIL = "email";

    @Column(name = USERNAME, nullable = false, unique = true)
    private String username;
    @Column(name = PASSWORD, nullable = false, unique = true)
    private String password;
    @Column(name = PHONE_NUMBER, nullable = false, unique = true)
    private String phoneNumber;
    @Column(name = EMAIL, nullable = false, unique = true)
    private String email;

    public Information() {
    }

    public Information(String username, String password, String phoneNumber, String email) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
