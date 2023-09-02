package patika.fhw.demo.model.dto;

import patika.fhw.demo.util.dbutil.BaseDTO;

public class HospitalDTO extends BaseDTO {
    private String name;
    private String location;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
