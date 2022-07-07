package services;

import models.*;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ReadAndWriteFacity {
    // ham read chung
    public List<String> read(String path) {
        List<String> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String string;
            while ((string = br.readLine()) != null) {
                list.add(string);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    // ham write chung
    public void write(String path, List<String> list, boolean append) {
        try {
            FileWriter fw = new FileWriter(path, append);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String s : list) {
                bw.write(s);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<Facility, Integer> readFacility(String pathFile) {
        List<String> list = read(pathFile);
        String[] arr;
        Map<Facility, Integer> map = new LinkedHashMap<>();
        for (String s : list) {
            arr = s.split(",");

            if (arr[0].contains("VL")) {
                Villa villa = new Villa(arr[0], Double.parseDouble(arr[1]), Double.parseDouble(arr[2]), Integer.parseInt(arr[3]), arr[4], arr[5], Double.parseDouble(arr[6]), Integer.parseInt(arr[7]));
                map.put(villa, Integer.parseInt(arr[8]));
            } else if (arr[0].contains("HO")) {
                House house = new House(arr[0], Double.parseDouble(arr[1]), Double.parseDouble(arr[2]), Integer.parseInt(arr[3]), arr[4], arr[5], Integer.parseInt(arr[6]));
                map.put(house, Integer.parseInt(arr[7]));
            } else if (arr[0].contains("RO")) {
                Room room = new Room(arr[0], Double.parseDouble(arr[1]), Double.parseDouble(arr[2]), Integer.parseInt(arr[3]), arr[4], arr[5]);
                map.put(room, Integer.parseInt(arr[6]));

            }
        }
        return map;
    }

    public void writeFacility(String path, Map<Facility, Integer> map, boolean append) {
        List<String> list = new ArrayList<>();
        Set<Facility> set = map.keySet();
        for (Facility v : set) {
            list.add(v.getString() + "," + map.get(v));
        }
        write(path, list, append);
    }

    // read booking
    public Set<Booking> readBooking(String path) {
        ReadAndWriteToFilePerson readAndWriteToFilePerson = new ReadAndWriteToFilePerson();
        List<String> list = read(path);
        List<Customer> customers = readAndWriteToFilePerson.readToCustomer();
        String[] arr;
        Customer c = null;
        Set<Booking> bookingSet = new TreeSet<>();
        for (String s : list) {
            arr = s.split(",");
            for (Customer customer : customers) {
                if (customer.getCode().equals(arr[3])) {
                    c = customer;
                }
            }
            bookingSet.add(new Booking(arr[0], LocalDate.parse(arr[1]), LocalDate.parse(arr[2]), c, arr[4], arr[5]));
        }
        return bookingSet;
    }

    // write booking
    public void writeBooking(String path, Set<Booking> bookingSet, boolean append) {
        List<String> list = new ArrayList<>();
        for (Booking b : bookingSet) {
            list.add(b.getString());
        }
        write(path, list, append);
    }
}
