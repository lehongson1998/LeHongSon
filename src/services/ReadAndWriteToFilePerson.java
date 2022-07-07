package services;

import models.Customer;
import models.Employee;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReadAndWriteToFilePerson {
    // ghi file employee
    public void writeToEmployee(List<Employee> employees){
        try {
            FileWriter fw = new FileWriter("src/data/employee.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Employee e: employees){
                bw.write(e.getString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // doc file employee
    public List<Employee> readToEmployee(){
        List<Employee> employees = new ArrayList<>();
        try {
            FileReader fr = new FileReader("src/data/employee.csv");
            BufferedReader br = new BufferedReader(fr);
            String[] str;
            String line;
            while ((line = br.readLine()) != null){
                str = line.split(",");
                employees.add(new Employee(str[0],str[1],LocalDate.parse(str[2]),str[3],str[4],str[5],str[6],str[7],str[8],Integer.parseInt(str[9])));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
    // ghi file customer
    public void writeToCustomer(LinkedList<Customer> customers){
        try {
            FileWriter fw = new FileWriter("src/data/customer.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Customer c: customers){
                bw.write(c.getString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // doc file customer
    public LinkedList<Customer> readToCustomer(){
        LinkedList<Customer> customers = new LinkedList<>();
        try {
            FileReader fr = new FileReader("src/data/customer.csv");
            BufferedReader br = new BufferedReader(fr);
            String[] str;
            String line;
            while ((line = br.readLine()) != null){
                str = line.split(",");
                customers.add(new Customer(str[0],str[1], LocalDate.parse(str[2]),str[3],str[4],str[5],str[6],str[7],str[8]));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
