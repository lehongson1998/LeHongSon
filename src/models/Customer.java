package models;

import java.time.LocalDate;

public class Customer extends Person{
    private String type_customer;
    private String address;

    public Customer(String code, String name, LocalDate dateOfBirth, String so_cmnd, String phone, String email, String gender, String type_customer, String address) {
        super(code, name, dateOfBirth, so_cmnd, phone, email,gender);
        this.type_customer = type_customer;
        this.address = address;
    }

    public String getType_customer() {
        return type_customer;
    }

    public void setType_customer(String type_customer) {
        this.type_customer = type_customer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
// phuong thuc getString customer
    @Override
    public String getString() {
        return super.getString() + "," + type_customer + "," + address;
    }
// phuong thuc toString customer
    @Override
    public String toString() {
        return super.toString() +
                ", type_customer: '" + type_customer + '\'' +
                ", address: '" + address + '\'' +
                '}';
    }
}
