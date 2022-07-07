package services;

import models.Facility;
import models.House;
import models.Room;
import models.Villa;

import java.util.*;

public class FacilityServiceImpl implements IFacilityService{
    Scanner input = new Scanner(System.in);
    final Integer num = 0;
    final String PATH = "D:\\FuramaResort\\src\\data\\facility.csv";
    ReadAndWriteFacity readAndWriteFacity = new ReadAndWriteFacity();
    @Override
    public void display() {
        Map<Facility, Integer> map ;
        map = readAndWriteFacity.readFacility(PATH);
        Set<Facility> set = map.keySet();
        for (Facility v:set) {
            System.out.println(v.toString()+","+map.get(v));
        }
    }

    @Override
    public void add() {
        Map<Facility,Integer> map = readAndWriteFacity.readFacility(PATH);
        System.out.println("enter number :");
        int i = Integer.parseInt(input.nextLine());
        String tenDv;
        do {
            System.out.println("nhap ten dv:");
            tenDv = input.nextLine();
        }while (!CheckRegex.checkRegexNameService(tenDv));
        System.out.println("nhap dien tich su dung:");
        double dt = Double.parseDouble(input.nextLine());
        System.out.println("nhap chi phi:");
        double chiphi = Double.parseDouble(input.nextLine());
        System.out.println("nhap so luong nguoi toi da:");
        int maxPerson = Integer.parseInt(input.nextLine());
        System.out.println("nhap kieu thue:");
        String type = input.nextLine();
        switch (i){
            case 1:
                System.out.println("nhap tieu chuan phong:");
                String tcPhong = input.nextLine();
                System.out.println("nhap dien tich ho boi:");
                double dthb = Double.parseDouble(input.nextLine());
                System.out.println("nhap so tang:");
                int sotang = Integer.parseInt(input.nextLine());
                map.put(new Villa(tenDv,dt,chiphi,maxPerson,type,tcPhong,dthb,sotang),num);
                readAndWriteFacity.writeFacility(PATH,map,false);
                break;
            case 2:
                System.out.println("nhap tieu chuan phòng:");
                String tieuchuan = input.nextLine();
                System.out.println("nhap so tang:");
                int stang = Integer.parseInt(input.nextLine());
                map.put(new House(tenDv,dt,chiphi,maxPerson,type,tieuchuan,stang),num);
                readAndWriteFacity.writeFacility(PATH,map,false);
                break;
            case 3:
                System.out.println("nhap dich vu free:");
                String free = input.nextLine();
                map.put(new Room(tenDv,dt,chiphi,maxPerson,type,free),num);
                readAndWriteFacity.writeFacility(PATH,map,false);
                break;
            case 4:
                break;
        }
    }
    @Override
    public void edit() {

    }
}
