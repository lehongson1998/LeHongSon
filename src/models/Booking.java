package models;

import java.time.LocalDate;
import java.util.Objects;

public class Booking implements Comparable<Booking>{
    private String codeBooking;
    private LocalDate startDay;
    private LocalDate endDay;
    private Customer codeKh;
    private String nameDv;
    private String typeDv;

    public Booking(String codeBooking, LocalDate startDay, LocalDate endDay, Customer codeKh, String nameDv, String typeDv) {
        this.codeBooking = codeBooking;
        this.startDay = startDay;
        this.endDay = endDay;
        this.codeKh = codeKh;
        this.nameDv = nameDv;
        this.typeDv = typeDv;
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }

    public Customer getCodeKh() {
        return codeKh;
    }

    public void setCodeKh(Customer codeKh) {
        this.codeKh = codeKh;
    }

    public String getNameDv() {
        return nameDv;
    }

    public void setNameDv(String nameDv) {
        this.nameDv = nameDv;
    }

    public String getTypeDv() {
        return typeDv;
    }

    public void setTypeDv(String typeDv) {
        this.typeDv = typeDv;
    }
    public String getString(){
        return codeBooking + "," + startDay + "," + endDay + "," + codeKh.getCode() + "," + nameDv + "," + typeDv;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "codeBooking='" + codeBooking + '\'' +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", codeKh=" + codeKh.getCode() +
                ", nameDv='" + nameDv + '\'' +
                ", typeDv='" + typeDv + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return startDay.equals(booking.startDay) && endDay.equals(booking.endDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDay, endDay);
    }

    @Override
    public int compareTo(Booking o) {
        return 0;
    }
}
