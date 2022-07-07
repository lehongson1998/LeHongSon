package models;

public class Contract {
    private int soHD;
    private Booking codeBooking;
    private int soTienCoc;
    private int soTienTt;
    private Customer codeKh;

    public Contract(int soHD, Booking codeBooking, int soTienCoc, int soTienTt, Customer codeKh) {
        this.soHD = soHD;
        this.codeBooking = codeBooking;
        this.soTienCoc = soTienCoc;
        this.soTienTt = soTienTt;
        this.codeKh = codeKh;
    }

    public int getSoHD() {
        return soHD;
    }

    public void setSoHD(int soHD) {
        this.soHD = soHD;
    }

    public Booking getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(Booking codeBooking) {
        this.codeBooking = codeBooking;
    }

    public int getSoTienCoc() {
        return soTienCoc;
    }

    public void setSoTienCoc(int soTienCoc) {
        this.soTienCoc = soTienCoc;
    }

    public int getSoTienTt() {
        return soTienTt;
    }

    public void setSoTienTt(int soTienTt) {
        this.soTienTt = soTienTt;
    }

    public Customer getCodeKh() {
        return codeKh;
    }

    public void setCodeKh(Customer codeKh) {
        this.codeKh = codeKh;
    }
    public String getString(){
        return soHD + "," + codeBooking.getCodeBooking() + "," + soTienCoc + "," + soTienTt + codeKh.getCode();
    }

    @Override
    public String toString() {
        return "Contract{" +
                "soHD=" + soHD +
                ", codeBooking=" + codeBooking.getCodeBooking() +
                ", soTienCoc=" + soTienCoc +
                ", soTienTt=" + soTienTt +
                ", codeKh=" + codeKh.getCode() +
                '}';
    }
}
