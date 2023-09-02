package patika.fhw.demo.model.requestDTO;

import patika.fhw.demo.util.dbutil.BaseDTO;

public class FlightRequestDTO extends BaseDTO {
    
    private String airline;
    private String departureAirport;
    private String arrivalAirport;
    private String departureTime;
    private String arrivalTime;
    public String getAirline() {
        return airline;
    }
    public void setAirline(String airline) {
        this.airline = airline;
    }
    public String getDepartureAirport() {
        return departureAirport;
    }
    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }
    public String getArrivalAirport() {
        return arrivalAirport;
    }
    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }
    public String getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    public String getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    
    
}
