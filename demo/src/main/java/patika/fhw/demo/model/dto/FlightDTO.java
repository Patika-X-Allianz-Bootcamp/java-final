package patika.fhw.demo.model.dto;

import java.util.Date;

import patika.fhw.demo.util.dbutil.BaseDTO;

public class FlightDTO extends BaseDTO {
    private Long id;
    private String airline;
    private String departureAirport;
    private String arrivalAirport;
    private Date departureTime;
    private Date arrivalTime;
    private int availableSeats;
    private double ticketPrice;
    
    @Override
    public Long getId() {
        return id;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }
    
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
    public int getAvailableSeats() {
        return availableSeats;
    }
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    public double getTicketPrice() {
        return ticketPrice;
    }
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    
    
    
}

