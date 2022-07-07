package models;

public abstract class Facility {
    private String ten_Dv;
    private double dt_suDung;
    private double chi_phi;
    private int max_person;
    private String type_thue;

    public Facility(String ten_Dv, double dt_suDung, double chi_phi, int max_person, String type_thue) {
        this.ten_Dv = ten_Dv;
        this.dt_suDung = dt_suDung;
        this.chi_phi = chi_phi;
        this.max_person = max_person;
        this.type_thue = type_thue;
    }

    public String getTen_Dv() {
        return ten_Dv;
    }

    public void setTen_Dv(String ten_Dv) {
        this.ten_Dv = ten_Dv;
    }

    public double getDt_suDung() {
        return dt_suDung;
    }

    public void setDt_suDung(double dt_suDung) {
        this.dt_suDung = dt_suDung;
    }

    public double getChi_phi() {
        return chi_phi;
    }

    public void setChi_phi(double chi_phi) {
        this.chi_phi = chi_phi;
    }

    public int getMax_person() {
        return max_person;
    }

    public void setMax_person(int max_person) {
        this.max_person = max_person;
    }

    public String getType_thue() {
        return type_thue;
    }

    public void setType_thue(String type_thue) {
        this.type_thue = type_thue;
    }
    public String getString(){
        return ten_Dv + "," + dt_suDung + "," + chi_phi + "," + max_person + "," + type_thue;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "ten_Dv: '" + ten_Dv + '\'' +
                ", dt_suDung: " + dt_suDung +
                ", chi_phi: " + chi_phi +
                ", max_person: " + max_person +
                ", type_thue: '" + type_thue;
    }
}
