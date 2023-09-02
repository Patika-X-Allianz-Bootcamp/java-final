package patika.fhw.demo.model.requestDTO;

import patika.fhw.demo.util.dbutil.BaseDTO;

public class HotelRequestDTO extends BaseDTO {
    
    private String name;
    private String location;
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
    public int getStarRating() {
        return starRating;
    }
    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }
    
    
}

