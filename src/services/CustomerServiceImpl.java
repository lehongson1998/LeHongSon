package services;


import models.Customer;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    private final ReadAndWriteToFilePerson rc = new ReadAndWriteToFilePerson();
    private LinkedList<Customer> customers = new LinkedList<>();
    private final Scanner input = new Scanner(System.in);

    @Override
    public void display() {
        customers = rc.readToCustomer();
        for (Customer c : customers) {
            System.out.println(c.toString());
        }
    }

    @Override
    public void add() {
        customers = rc.readToCustomer();
        System.out.println("nhập mã khách hàng:");
        String code = input.nextLine();
        System.out.println("nhập tên khách hàng:");
        String name = input.nextLine();
        LocalDate date;
        do {
            try {
                System.out.println("nhập ngày sinh khách hàng:");
                date = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            }catch (DateTimeException e){
                System.err.println("sai dinh dang!");
            }
        } while (true);

        String cmnd;
        do {
            System.out.println("nhập số cmnd khách hàng:");
            cmnd = input.nextLine();
        }while (!CheckRegex.checkCmndPerson(cmnd));

        String phone;
        do {
            System.out.println("nhập số điên thoại khách hàng:");
            phone = input.nextLine();
        }while (!CheckRegex.checkRegexPhone(phone));

        String email;
        do {
            System.out.println("nhập email khách hàng:");
            email = input.nextLine();
        }while (!CheckRegex.checkRegexEmail(email));
        System.out.println("nhập giới tính khách hàng:");
        String gender = input.nextLine();
        System.out.println("nhập loại khách hàng:");
        String type = input.nextLine();
        System.out.println("nhập địa chỉ khách hàng:");
        String address = input.nextLine();
        customers.add(new Customer(code, name, date, cmnd, phone, email, gender, type, address));
        rc.writeToCustomer(customers);
    }

    @Override
    public void edit() {
        customers = rc.readToCustomer();
        System.out.println("nhập mã khách hàng:");
        String code = input.nextLine();
        for (Customer c : customers) {
            if (code.equals(c.getCode())) {
                String name;
                do {
                    System.out.println("nhập tên khách hàng:");
                    name = input.nextLine();
                } while (!CheckRegex.checkRegexPersonName(name));
                LocalDate date;
                do {
                    try {
                        System.out.println("nhập ngày sinh khách hàng:");
                        date = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        break;
                    } catch (DateTimeException e) {
                        e.printStackTrace();
                    }
                } while (true);
                String cmnd;
                do {
                    System.out.println("nhập số cmnd khách hàng:");
                    cmnd = input.nextLine();
                } while (!CheckRegex.checkCmndPerson(cmnd));
                String phone;
                do {
                    System.out.println("nhập số điên thoại khách hàng:");
                    phone = input.nextLine();
                } while (!CheckRegex.checkRegexPhone(phone));
                String email;
                do {
                    System.out.println("nhập email khách hàng:");
                    email = input.nextLine();
                } while (!CheckRegex.checkRegexEmail(email));
                System.out.println("nhập giới tính khách hàng:");
                String gender = input.nextLine();
                System.out.println("nhập loại khách hàng:");
                String type = input.nextLine();
                System.out.println("nhập địa chỉ khách hàng:");
                String address = input.nextLine();
                c.setName(name);
                c.setDateOfBirth(date);
                c.setSo_cmnd(cmnd);
                c.setPhone(phone);
                c.setEmail(email);
                c.setGender(gender);
                c.setType_customer(type);
                c.setAddress(address);
            }
        }
        rc.writeToCustomer(customers);
    }
}
