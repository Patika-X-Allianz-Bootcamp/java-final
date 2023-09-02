package patika.fhw.demo.model.requestDTO;

import patika.fhw.demo.util.dbutil.BaseDTO;

public class HospitalRequestDTO extends BaseDTO {
    
    private String name;
    private String location;
    private String contact;
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
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    
    
}
