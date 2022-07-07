package models;

public class Villa extends Facility{
    private String tc_phong;
    private double dt_hoBoi;
    private int so_tang;

    public Villa(String ten_Dv, double dt_suDung, double chi_phi, int max_person, String type_thue, String tc_phong, double dt_hoBoi, int so_tang) {
        super(ten_Dv, dt_suDung, chi_phi, max_person, type_thue);
        this.tc_phong = tc_phong;
        this.dt_hoBoi = dt_hoBoi;
        this.so_tang = so_tang;
    }

    public String getTc_phong() {

        return tc_phong;
    }

    public void setTc_phong(String tc_phong) {
        this.tc_phong = tc_phong;
    }

    public double getDt_hoBoi() {
        return dt_hoBoi;
    }

    public void setDt_hoBoi(double dt_hoBoi) {
        this.dt_hoBoi = dt_hoBoi;
    }

    public int getSo_tang() {
        return so_tang;
    }

    public void setSo_tang(int so_tang) {
        this.so_tang = so_tang;
    }
    @Override
    public String getString(){
        return super.getString() + "," + tc_phong + "," + dt_hoBoi + "," + so_tang;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", tc_phong: '" + tc_phong + '\'' +
                ", dt_hoBoi: " + dt_hoBoi +
                ", so_tang: " + so_tang +
                '}';
    }
}
