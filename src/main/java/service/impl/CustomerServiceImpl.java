package service.impl;

import entity.Airline;
import entity.Customer;
import repository.AirLineRepository;
import repository.CustomerRepository;
import service.AirlineService;
import service.CustomerService;
import service.base.impl.BaseServiceImpl;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomerServiceImpl extends BaseServiceImpl<Customer, Long, CustomerRepository> implements CustomerService {
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }

    public void startMenu() {
        int select = 0;
        systemMenu();
        System.out.println("choice one of them:");
        try {
            select = input.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            startMenu();
        }

        switch (select) {
            case 1:
                loginUser();
                break;
            case 2:
                register();
                break;
        }
    }

    private void register() {
        System.out.println("register page...");
        Customer customer = inputUserField();
        Customer save = repository.save(customer);
        if (save != null)
            userActive(customer);
        else System.out.println("userName or password is duplicate");
    }

    private void loginUser() {
        Customer customer = new Customer();
        System.out.println("enter you username ");
        String username = input.next();
        System.out.println("enter you password ");
        String password = input.next();
        customer.setUsername(username);
        customer.setPassword(password);
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

    int choice;

    private void choiceMenuAfterLogin(Customer customer) {
        int choice = input.nextInt();
        switch (choice) {
            case 1:
               buyTicket(customer);
                break;
            case 2:
                menuEdit(customer);
                break;
        }
    }

    private void userActive(Customer customer) {
        menuUserActive();
        choiceMenuAfterLogin(customer);
        System.out.println("do want Exit? (enter 1)");
        byte exit = input.nextByte();
        if (exit == 1)
            System.exit(0);
        else userActive(customer);
    }

    private void menuEdit(Customer customer) {
        menuChangeInformation();
        int select = input.nextInt();
        switch (select) {
            case 1:
                changePassword(customer);
                break;
            case 2:
                changeUsername(customer);
                break;
            case 3:
                changeEmail(customer);
                break;
            case 4:
                deleteAccount(customer);
                System.exit(0);
                break;

        }
        userActive(customer);
    }

    private void buyTicket(Customer customer) {
    }

    private void menuUserActive() {
        System.out.println("1) buy one Ticket? ");
        System.out.println(" 2 ) do you want edit account ?");
        System.out.println("Enter number of menu (enter number integer) ");
    }

    private void deleteAccount(Customer customer) {
        repository.delete(customer);
    }

    private void changePassword(Customer customer) {
        do {
            System.out.println("Enter new password");
            String password = input.next();
            if (cheekPassword(password)) {
                customer.setPassword(password);
                repository.update(customer);
                break;
            }
        } while (true);
    }

    private void changeUsername(Customer customer) {
        do {
            System.out.println("Enter new username");
            String username = input.next();
            if (cheekUserName(username)) {
                customer.setUsername(username);
                repository.update(customer);
                break;
            }
        } while (true);

    }

    private void changeEmail(Customer customer) {
        do {
            System.out.println("enter new EmailAddress");
            String email = input.next();
            if (CheekEmail(email)) {
                customer.setEmail(email);
                repository.update(customer);
                break;
            }
        } while (true);

    }

    static Scanner input = new Scanner(System.in);
    boolean cheek = false, cheekUserName = false, cheekPassword = false, cheekEmail = false;

    private void menuChangeInformation() {
        System.out.println("what do you want change in yor account or delete account: ");
        System.out.println("1) change password ");
        System.out.println("2) change username");
        System.out.println("3) change email address");
        System.out.println("4) delete account");
    }

    private Customer inputUserField() {
        Customer customer = new Customer();
        do {
            if (!cheekUserName) {
                System.out.println("please enter your username: ");
                String username = input.next();
                cheekUserName = cheekUserName(username);
                if (cheekUserName)
                    customer.setUsername(username);
                else System.out.println("userName false");
            }
            if (!cheekPassword) {
                System.out.println("please enter your password: ");
                String password = input.next();
                cheekPassword = cheekPassword(password);
                if (cheekPassword)
                    customer.setPassword(password);
                else System.out.println("password false");
            }
            if (!cheekEmail)
            {
                System.out.println("please enter your email address: ");
                String email = input.next();
                cheekEmail = CheekEmail(email);
                if (cheekEmail)
                    customer.setEmail(email);
                else System.out.println("email false");
            }
            if (cheekUserName && cheekPassword && cheekEmail)
                cheek = true;
            else System.out.println("try again.............");

        } while (!cheek);
        getDetailsInformation(customer);
        return customer;
    }

    private void getDetailsInformation(Customer customer) {
        System.out.println("enter firstName ");
        String firstName = input.next();
        customer.setFirstName(firstName);

        System.out.println("enter lastName ");
        String lastName = input.next();
        customer.setLastName(lastName);

        System.out.println("enter fatherName ");
        String fatherName = input.next();
        customer.setFatherName(fatherName);

        System.out.println("enter nationalCode ");
        String nationalCode = input.next();
        customer.setNationalCode(nationalCode);

        System.out.println("enter phoneNumber ");
        String phoneNumber = input.next();
        customer.setPhoneNumber(phoneNumber);
    }

    private void systemMenu() {
        System.out.println("1) Login User ");
        System.out.println("2) Register ");
    }

    //for update
    private boolean cheekPassword(String text) {
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$";
        boolean isTrue = Pattern.matches(regex, text);
        return isTrue;
    }

    private boolean cheekUserName(String text) {
        String regex = "^[a-zA-Z]([._-](?![._-])|[a-zA-Z0-9]){1,16}[a-zA-Z0-9]$";
        boolean isTrue = Pattern.matches(regex, text);
        return isTrue;
    }

    private boolean CheekEmail(String text) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        boolean isTrue = Pattern.matches(regex, text);
        return isTrue;
    }
}
