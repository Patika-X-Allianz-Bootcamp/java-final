package patika.fhw.demo.database.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import patika.fhw.demo.util.dbutil.BaseEntity;

@Entity
public class Hospital extends BaseEntity {
    private String name;
    private String location;
    private String contactNumber;

    @OneToMany(mappedBy = "hospital")
    private Set<Doctor> doctors;

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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    
}
