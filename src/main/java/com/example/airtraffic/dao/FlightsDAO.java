package com.example.airtraffic.dao;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightsDAO {
    private String flight_name;
    private boolean isDomestic;
    private boolean status;
    private String arrivedAirport;
    private String departureAirport;
    private String departureTime;
    private String arrivalTime;
    private double ticketPrice;
    private int capacity;
    private int runwayId;
    private int terminalId;
}
