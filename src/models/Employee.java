package models;

public class Employee extends Person{
    private String trinh_do;
    private String vi_tri;
    private int luong;

    public Employee(String code, String name, Localdate dateOfBirth, String so_cmnd, String phone, String email,String gender, String trinh_do, String vi_tri, int luong) {
        super(code, name, dateOfBirth, so_cmnd, phone, email,gender);
        this.trinh_do = trinh_do;
        this.vi_tri = vi_tri;
        this.luong = luong;
    }

    public String getTrinh_do() {
        return trinh_do;
    }

    public void setTrinh_do(String trinh_do) {
        this.trinh_do = trinh_do;
    }

    public String getVi_tri() {
        return vi_tri;
    }

    public void setVi_tri(String vi_tri) {
        this.vi_tri = vi_tri;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    @Override
    public String getString() {
        return super.getString() + "," + trinh_do + "," + vi_tri + "," + luong;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", trinh_do: '" + trinh_do + '\'' +
                ", vi_tri: '" + vi_tri + '\'' +
                ", luong: " + luong +
                '}';
    }
}
