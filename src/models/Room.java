package models;

public class Room extends Facility{
    private String dv_free;

    public Room(String ten_Dv, double dt_suDung, double chi_phi, int max_person, String type_thue, String dv_free) {
        super(ten_Dv, dt_suDung, chi_phi, max_person, type_thue);
        this.dv_free = dv_free;
    }

    public String getDv_free() {
        return dv_free;
    }

    public void setDv_free(String dv_free) {
        this.dv_free = dv_free;
    }

    @Override
    public String getString() {
        return super.getString() + "," + dv_free;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", dv_free: '" + dv_free + '\'' +
                '}';
    }
}
