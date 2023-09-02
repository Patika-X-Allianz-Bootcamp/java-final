package patika.fhw.demo.model.dto;

import java.util.List;

import patika.fhw.demo.util.dbutil.BaseDTO;

public class HotelDTO extends BaseDTO {
    private Long id;
    private String name;
    private String location;
    private int starRating;
    private String amenities;
    private List<String> availableRooms;
    
    @Override
    public Long getId() {
        return id;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }
    
    
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
    public String getAmenities() {
        return amenities;
    }
    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }
    public List<String> getAvailableRooms() {
        return availableRooms;
    }
    public void setAvailableRooms(List<String> availableRooms) {
        this.availableRooms = availableRooms;
    }
    
    
    
}

