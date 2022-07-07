package models;

public class House extends Facility{
    private String tc_phong;
    private int so_tang;

    public House(String ten_Dv, double dt_suDung, double chi_phi, int max_person, String type_thue, String tc_phong, int so_tang) {
        super(ten_Dv, dt_suDung, chi_phi, max_person, type_thue);
        this.tc_phong = tc_phong;
        this.so_tang = so_tang;
    }

    public String getTc_phong() {
        return tc_phong;
    }

    public void setTc_phong(String tc_phong) {
        this.tc_phong = tc_phong;
    }

    public int getSo_tang() {
        return so_tang;
    }

    public void setSo_tang(int so_tang) {
        this.so_tang = so_tang;
    }

    @Override
    public String getString() {
        return super.getString() + "," + tc_phong + "," + so_tang;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", tc_phong: '" + tc_phong + '\'' +
                ", so_tang: " + so_tang +
                '}';
    }
}
