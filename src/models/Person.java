package models;

import java.time.LocalDate;

public abstract class Person {
    private String code;
    private String name;
    private LocalDate dateOfBirth;
    private String so_cmnd;
    private String phone;
    private String email;
    private String gender;

    public Person(String code, String name, LocalDate dateOfBirth, String so_cmnd, String phone, String email,String gender) {
        this.code = code;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.so_cmnd = so_cmnd;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSo_cmnd() {
        return so_cmnd;
    }

    public void setSo_cmnd(String so_cmnd) {
        this.so_cmnd = so_cmnd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getString(){
        return code + "," + name + "," + dateOfBirth + "," + so_cmnd + "," + phone + "," + email + "," + gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "code: '" + code + '\'' +
                ", name: '" + name + '\'' +
                ", dateOfBirth: '" + dateOfBirth + '\'' +
                ", so_cmnd: '" + so_cmnd + '\'' +
                ", phone: '" + phone + '\'' +
                ", email: '" + email +
                ", gender: " + gender;
    }
}
