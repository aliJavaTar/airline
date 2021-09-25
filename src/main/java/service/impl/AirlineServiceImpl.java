package service.impl;

import entity.Airline;
import entity.Customer;
import repository.AirLineRepository;
import service.AirlineService;
import service.base.impl.BaseServiceImpl;

import java.util.Scanner;

public class AirlineServiceImpl extends BaseServiceImpl<Airline, Long, AirLineRepository> implements AirlineService {
    public AirlineServiceImpl(AirLineRepository repository) {
        super(repository);
    }

    static Scanner input = new Scanner(System.in);


    private void register() {
        System.out.println("register page...");
        Airline airline = inputUserField();
        Airline save = repository.save(airline);
        if (save != null)
            userActive(airline);
        else System.out.println("userName or password is duplicate");
    }

    private void loginUser() {
        Airline airline = new Airline();
        System.out.println("enter you username ");
        String username = input.next();
        System.out.println("enter you password ");
        String password = input.next();
        airline.setUsername(username);
        airline.setPassword(password);
        System.out.println(customer);
        //  User userLogin = ApplicationContext.getUserService().findUserByUserName(user);
        //  Customer customerLogin = repository.(customer);
//        if (userLogin == null) {
//            System.out.println("user not exist");
//            System.exit(0);
//        }
//        if (password.equals(userLogin.getPassword())) {
//            System.out.println("well come\n");
//            userActive(userLogin);
//        } else
//            System.out.println("username or password false");
    }
}
