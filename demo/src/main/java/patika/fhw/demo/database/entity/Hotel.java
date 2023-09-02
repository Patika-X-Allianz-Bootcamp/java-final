package patika.fhw.demo.database.entity;

import jakarta.persistence.Entity;
import patika.fhw.demo.util.dbutil.BaseEntity;

@Entity
public class Hotel extends BaseEntity {
    private String name;
    private String location;
    private String contactNumber;
    private int starRating;
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
    public int getStarRating() {
        return starRating;
    }
    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    
}
