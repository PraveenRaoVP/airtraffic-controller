package com.example.airtraffic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Flights {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long flight_id;
    private String flight_name;
    private boolean isDomestic;
    private boolean status;
    private String ArrivedAirport;
    private String DepartureAirport;
    private String DepartureTime;
    private String ArrivalTime;
    private double ticketPrice;
    private long capacity;
    @ManyToOne
    @JoinColumn(name = "runway_id")
    @JsonBackReference
    private Runway runway;
    @ManyToOne
    @JoinColumn(name = "terminal_id")
    @JsonBackReference
    private Terminal terminal;

    public Long getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Long flight_id) {
        this.flight_id = flight_id;
    }

    public String getFlight_name() {
        return flight_name;
    }

    public void setFlight_name(String flight_name) {
        this.flight_name = flight_name;
    }

    public boolean isDomestic() {
        return isDomestic;
    }

    public void setDomestic(boolean domestic) {
        isDomestic = domestic;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getArrivedAirport() {
        return ArrivedAirport;
    }

    public void setArrivedAirport(String arrivedAirport) {
        ArrivedAirport = arrivedAirport;
    }

    public String getDepartureAirport() {
        return DepartureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        DepartureAirport = departureAirport;
    }

    public String getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(String departureTime) {
        DepartureTime = departureTime;
    }

    public String getArrivalTime() {
        return ArrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        ArrivalTime = arrivalTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public Runway getRunway() {
        return runway;
    }

    public void setRunway(Runway runway) {
        this.runway = runway;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }
}