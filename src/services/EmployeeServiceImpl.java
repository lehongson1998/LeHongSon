package services;

import common.UserException;
import jdk.internal.org.objectweb.asm.util.TraceAnnotationVisitor;
import models.Employee;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    private Scanner input = new Scanner(System.in);
    private List<Employee> employees = new ArrayList<>();
    private ReadAndWriteToFilePerson rw = new ReadAndWriteToFilePerson();

    @Override
    public void display() {
        employees = rw.readToEmployee();
        for (Employee e : employees) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void add() {
        employees = rw.readToEmployee();
        System.out.println("nhập mã nhân viên:");
        String code = input.nextLine();
        String name;
        do {
            System.out.println("nhập tên nhân viên:");
            name = input.nextLine();
            if (!CheckRegex.checkRegexPersonName(name)) {
                System.err.println("sai định dạng tên!");
            }
        } while (!CheckRegex.checkRegexPersonName(name));

        LocalDate date;
        do {
            try {
                System.out.println("nhập ngày sinh nhân viên:");
                date = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            }catch (DateTimeException d){
                System.err.println("sai dinh dang!");
            }
        } while (true);
        String cmnd;
        do {
            System.out.println("nhập số cmnd nhân viên:");
            cmnd = input.nextLine();
            if (!CheckRegex.checkCmndPerson(cmnd)) {
                System.err.println("sai định dạng cmnd!");
            }
        } while (!CheckRegex.checkCmndPerson(cmnd));
        String phone;
        do {
            System.out.println("nhập số điên thoại nhân viên:");
            phone = input.nextLine();
            if (!CheckRegex.checkRegexPhone(phone)) {
                System.err.println("sai định dạng số điện thoại nha!");
            }
        } while (!CheckRegex.checkRegexPhone(phone));
        String email;
        do {
            System.out.println("nhập email nhân viên:");
            email = input.nextLine();
            if (!CheckRegex.checkRegexEmail(email)) {
                System.err.println("sai định dạng email!");
            }
        } while (!CheckRegex.checkRegexEmail(email));

        System.out.println("nhập giới tính nhân viên:");
        String gender = input.nextLine();

        System.out.println("nhập trình độ học vấn:");
        String trinhDo = input.nextLine();

        System.out.println("nhập chúc vụ nhân viên:");
        String cv = input.nextLine();

        System.out.println("nhập tiền lương nhân viên:");
        int luong = Integer.parseInt(input.nextLine());

        employees.add(new Employee(code, name, date, cmnd, phone, email, gender, trinhDo, cv, luong));
        rw.writeToEmployee(employees);
    }

    @Override
    public void edit() {
        employees = rw.readToEmployee();
        System.out.println("nhập mã nhân viên:");
        String code = input.nextLine();
        for (Employee e : employees) {
            if (code.equals(e.getCode())) {
                String name;
                do {
                    System.out.println("nhập tên nhân viên:");
                    name = input.nextLine();
                } while (!CheckRegex.checkRegexPersonName(name));

                LocalDate date;
                do {
                    try {
                        System.out.println("nhập ngày sinh nhân viên:");
                        date = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        break;
                    } catch (DateTimeException d) {
                        System.err.println("sai dinh dang!");
                    }
                } while (true);
                String cmnd;
                do {
                    System.out.println("nhập số cmnd nhân viên:");
                    cmnd = input.nextLine();
                } while (!CheckRegex.checkCmndPerson(cmnd));

                String phone;
                do {
                    System.out.println("nhập số điên thoại nhân viên:");
                    phone = input.nextLine();
                } while (!CheckRegex.checkRegexPhone(phone));

                String email;
                do {
                    System.out.println("nhập email nhân viên:");
                    email = input.nextLine();
                } while (!CheckRegex.checkRegexEmail(email));
                System.out.println("nhập giới tính nhân viên:");
                String gender = input.nextLine();
                System.out.println("nhập trình độ học vấn:");
                String trinhDo = input.nextLine();
                System.out.println("nhập chúc vụ nhân viên:");
                String cv = input.nextLine();
                System.out.println("nhập tiền lương nhân viên:");
                int luong = Integer.parseInt(input.nextLine());
                e.setName(name);
                e.setDateOfBirth(date);
                e.setSo_cmnd(cmnd);
                e.setPhone(phone);
                e.setEmail(email);
                e.setGender(gender);
                e.setTrinh_do(trinhDo);
                e.setVi_tri(cv);
                e.setLuong(luong);
            }
        }
        rw.writeToEmployee(employees);
    }
}
