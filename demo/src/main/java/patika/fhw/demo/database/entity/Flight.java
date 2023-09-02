package patika.fhw.demo.database.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import patika.fhw.demo.util.dbutil.BaseEntity;

@Entity
public class Flight extends BaseEntity {
    private String airline;
    private String flightNumber;
    private Date departureTime;
    private Date arrivalTime;
    private String departureAirport;
    private String arrivalAirport;
    public String getAirline() {
        return airline;
    }
    public void setAirline(String airline) {
        this.airline = airline;
    }
    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    public Date getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }
    public Date getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
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

    
}
