package controller;

import models.Facility;
import services.*;

import java.util.Scanner;

public class FuramaController {
    EmployeeServiceImpl e = new EmployeeServiceImpl();
    CustomerServiceImpl c = new CustomerServiceImpl();
    FacilityServiceImpl facilityService = new FacilityServiceImpl();
    BookingServiceImpl bs = new BookingServiceImpl();
    ContactServiceImpl cs = new ContactServiceImpl();
    public void displayMainMenu() {
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        int choice;
        do {
            try {
                System.out.println("-----------MENU-----------\n" +
                                   "1.\tEmployee Management.\n" +
                                   "2.\tCustomer Management.\n" +
                                   "3.\tFacility Management.\n" +
                                   "4.\tBooking Management.\n" +
                                   "5.\tPromotion Management.\n" +
                                   "6.\tExit");
                System.out.println("enter choice:");
                choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("1.\tDisplay list employees.\n" +
                                           "2.\tAdd new employee.\n" +
                                           "3.\tEdit employee.\n" +
                                           "4.\tReturn main menu.\n");
                        int i = Integer.parseInt(input.nextLine());
                        switch (i){
                            case 1:
                                e.display();
                                break;
                            case 2:
                                e.add();
                                break;
                            case 3:
                                e.edit();
                                break;
                            case 4:
                                break;
                        }
                    case 2:
                        System.out.println("1.\tDisplay list customers.\n" +
                                           "2.\tAdd new customer.\n" +
                                           "3.\tEdit customer.\n" +
                                           "4.\tReturn main menu.\n");

                        int i1 = Integer.parseInt(input.nextLine());
                        switch (i1){
                            case 1:
                                c.display();
                                break;
                            case 2:
                                c.add();
                                break;
                            case 3:
                                c.edit();
                                break;
                            case 4:
                                break;
                        }
                    case 3:
                        System.out.println("1\tDisplay list facility.\n" +
                                           "2\tAdd new facility.\n" +
                                           "3\tDisplay list facility maintenance.\n" +
                                           "4\tReturn main menu.\n");
                        int choose = Integer.parseInt(input.nextLine());
                        switch (choose){
                            case 1:
                                facilityService.display();
                                break;
                            case 2:
                                facilityService.add();
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                        }
                        break;
                    case 4:
                        System.out.println("1.\tAdd new booking.\n" +
                                           "2.\tDisplay list booking.\n" +
                                           "3.\tCreate new constracts.\n" +
                                           "4.\tDisplay list contracts.\n" +
                                           "5.\tEdit contracts.\n" +
                                           "6.\tReturn main menu.\n");
                        int i2 = Integer.parseInt(input.nextLine());
                        switch (i2){
                            case 1:
                                bs.add();
                                break;
                            case 2:
                                bs.display();
                                break;
                            case 3:
                                cs.add();
                                break;
                            case 4:
                                cs.display();
                                break;
                            case 5:
                                cs.edit();
                                break;
                            case 6:
                                break;
                        }
                    case 5:
                        System.out.println("1.\tDisplay list customers use service.\n" +
                                           "2.\tDisplay list customers get voucher.\n" +
                                           "3.\tReturn main menu.\n");
                        break;
                    case 6:
                        flag = false;
                        break;
                    default:
                        System.err.println("vui lòng enter lại!!!");
                }
            }catch (NumberFormatException e){
                System.err.println("NHẬP SỐ !");
            }
        } while (flag);
    }
}
