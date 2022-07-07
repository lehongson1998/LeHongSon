package services;

import common.UserException;
import models.Booking;
import models.Customer;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BookingServiceImpl implements IBookingService{
    private final Scanner input = new Scanner(System.in);
    private final ReadAndWriteFacity rw = new ReadAndWriteFacity();
    private Set<Booking> bookingSet = new TreeSet<>();
    private final String PATH = "src/data/booking.csv";
// hien thi booking
    @Override
    public void display() {
        bookingSet = rw.readBooking(PATH);
        for (Booking b: bookingSet){
            System.out.println(b.toString());
        }
    }
// them moi booking
    @Override
    public void add() {
        ReadAndWriteToFilePerson rp = new ReadAndWriteToFilePerson();
        List<Customer> cm = rp.readToCustomer();

        System.out.println("nhap mã booking:");
        String code = input.nextLine();

        LocalDate start;
        do {
            try {
                System.out.println("nhập ngày bắt đầu: type(dd/MM/yyyy)");
                start = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            }catch (DateTimeException e){
                e.printStackTrace();
            }

        }while (true);

        LocalDate end;
        do {
            try {
                System.out.println("nhập ngày kết thúc:");
                end = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            }catch (DateTimeException e){
                e.printStackTrace();
            }
        }while (true);

        System.out.println("nhập mã khách hàng:");
        String codekh = input.nextLine();

        System.out.println("nhập tên dịch vụ:");
        String nameDv = input.nextLine();

        System.out.println("nhập kiểu dịch vụ:");
        String type = input.nextLine();

        Customer customer = null;
        for (Customer c: cm){
            if (c.getCode().equals(codekh)){
                customer = c;
            }
        }
        bookingSet.add(new Booking(code,start,end,customer,nameDv,type));
        rw.writeBooking(PATH,bookingSet,true);
    }
// chinh sua booking
    @Override
    public void edit() {

    }
}