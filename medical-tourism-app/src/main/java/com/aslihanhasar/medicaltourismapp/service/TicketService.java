package com.aslihanhasar.medicaltourismapp.service;

import com.aslihanhasar.medicaltourismapp.dto.request.TicketPurchaseRequest;
import com.aslihanhasar.medicaltourismapp.dto.response.FlightSaveResponse;
import com.aslihanhasar.medicaltourismapp.dto.response.TicketPurchaseResponse;
import com.aslihanhasar.medicaltourismapp.entity.Flight;
import com.aslihanhasar.medicaltourismapp.entity.Ticket;
import com.aslihanhasar.medicaltourismapp.enums.TicketClass;
import com.aslihanhasar.medicaltourismapp.enums.TicketStatus;
import com.aslihanhasar.medicaltourismapp.exception.*;
import com.aslihanhasar.medicaltourismapp.repository.TicketRepository;
import com.aslihanhasar.medicaltourismapp.utils.CreditCardUtils;
import com.aslihanhasar.medicaltourismapp.utils.UniqueNumberGeneratorUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * The TicketService class is a service responsible for managing operations related to flight tickets.
 * It interacts with the TicketRepository for data storage and utilizes the FlightService for flight-related operations.
 */
@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final FlightService flightService;
    private final PatientService patientService;

    /**
     * Purchases a flight ticket based on the provided TicketPurchaseRequest.
     *
     * @param request The TicketPurchaseRequest containing the details of the ticket to be purchased.
     * @return A TicketPurchaseResponse indicating the result of the ticket purchase operation.
     * @throws TicketValidationException If any of the required fields in the request are null or empty.
     */
    @Transactional
    public TicketPurchaseResponse purchaseTicket(TicketPurchaseRequest request) {
        validateTicketPurchaseRequest(request);
        Ticket savedTicket = buildTicketAndSave(request);
        return convertTicketToResponse(savedTicket);
    }

    /**
     * Checks in a ticket based on the provided ticket number.
     *
     * @param ticketNumber The ticket number of the ticket to be checked in.
     * @throws AlreadyCheckedInException If the ticket is already checked in.
     */
    public void checkInTicket(String ticketNumber) {
        Ticket ticket = getByTicketNumber(ticketNumber);
        if (ticket.getStatus() == TicketStatus.PURCHASED) {
            ticket.setStatus(TicketStatus.CHECKED_IN);
            ticketRepository.save(ticket);
        } else {
            throw new AlreadyCheckedInException("Ticket already checked in");
        }
    }

    /**
     * Cancels a ticket based on the provided ticket number.
     *
     * @param ticketNumber The ticket number of the ticket to be cancelled.
     * @throws TicketOperationException If the ticket is already checked in and cannot be cancelled.
     */
    public void cancelTicket(String ticketNumber) {
        Ticket ticket = getByTicketNumber(ticketNumber);
        if (ticket.getStatus() == TicketStatus.CHECKED_IN) {
            throw new TicketOperationException("Cannot cancel a checked ticket.");
        }
        ticket.setStatus(TicketStatus.CANCELLED);
        ticket.setCancelled(true);
        flightService.updateAvailableSeats(ticket.getFlight(), ticket.getPassengerCount());
        ticketRepository.save(ticket);
    }

    /**
     * Retrieves a ticket based on the provided ticket number.
     *
     * @param ticketNumber The ticket number of the ticket to retrieve.
     * @return The retrieved Ticket.
     * @throws TicketNotFoundException If no ticket is found with the provided ticket number.
     */
    public Ticket getByTicketNumber(String ticketNumber) {
        return ticketRepository.findByTicketNumber(ticketNumber)
                .orElseThrow(() -> new TicketNotFoundException("Ticket not found."));

    }

    /**
     * Converts a Ticket entity to a TicketPurchaseResponse object.
     *
     * @param ticket The Ticket entity to be converted.
     * @return A TicketPurchaseResponse object representing the converted entity.
     */
    public TicketPurchaseResponse convertTicketToResponse(Ticket ticket) {
        FlightSaveResponse flightSaveResponse = flightService.
                convertFlightToResponse(ticket.getFlight());
        return TicketPurchaseResponse
                .builder()
                .ticketNumber(ticket.getTicketNumber())
                .passengerNumber(ticket.getPatient().getPatientNumber())
                .flightSaveResponse(flightSaveResponse)
                .ticketClass(ticket.getTicketClass())
                .maskedCreditCardNumber(ticket.getCreditCardNumber())
                .totalPrice(ticket.getTicketPrice())
                .build();
    }

    private Ticket buildTicketAndSave(TicketPurchaseRequest request) {
        Flight flight = flightService.getFlightById(request.getFlightId());
        flightService.reserveSeats(flight, request.getPassengerCount());
        TicketClass ticketClass = TicketClass.fromValue(request.getTicketClass());
        BigDecimal ticketPrice = calculateTicketPrice(request, flight);
        String maskedCreditCarNumber = CreditCardUtils.maskCreditCardNumber(request.getCreditCardNumber());
        makePayment(maskedCreditCarNumber);
        String ticketNumber = generateUniqueTicketNumber();
        Ticket ticket = Ticket
                .builder()
                .ticketNumber(ticketNumber)
                .patient(patientService.getByPatientNumber(request.getPatientNumber()))
                .creditCardNumber(maskedCreditCarNumber)
                .flight(flight)
                .passengerCount(request.getPassengerCount())
                .status(TicketStatus.PURCHASED)
                .ticketClass(ticketClass)
                .ticketPrice(ticketPrice)
                .cancelled(false)
                .build();
        return ticketRepository.save(ticket);
    }

    private BigDecimal calculateTicketPrice(TicketPurchaseRequest request, Flight flight) {
        TicketClass ticketClass = TicketClass.fromValue(request.getTicketClass());
        BigDecimal classMultiplier = getTicketClassMultiplier(ticketClass);
        BigDecimal basePrice = flight.getTicketBasePrice();
        return basePrice.multiply(classMultiplier).multiply
                (BigDecimal.valueOf(request.getPassengerCount()));
    }

    private BigDecimal getTicketClassMultiplier(TicketClass ticketClass) {
        return switch (ticketClass) {
            case BUSINESS_CLASS -> BigDecimal.valueOf(1.5);
            case FIRST_CLASS -> BigDecimal.valueOf(2.0);
            default -> throw new InvalidTicketClassException
                    ("Unsupported ticket class");
        };
    }

    private boolean isPaymentSuccess() {
        return true;
    }

    private String generateUniqueTicketNumber() {
        return UniqueNumberGeneratorUtils.generateUniqueNumber();
    }

    private void makePayment(String maskedCreditCardNumber) {
        if (!isPaymentSuccess()) {
            throw new PaymentFailedException("Payment process failed.");
        }
    }

    private void validateTicketPurchaseRequest(TicketPurchaseRequest request) {
        boolean anyFieldBlank = Stream.of(request.getPatientNumber(),
                        request.getFlightId(),
                        request.getPassengerCount(),
                        request.getTicketClass(),
                        request.getCreditCardNumber())
                .anyMatch(Objects::isNull);
        if (anyFieldBlank) {
            throw new TicketValidationException("Required fields cannot be left blank");
        }
    }
}



