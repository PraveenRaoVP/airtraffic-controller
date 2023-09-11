package com.example.airtraffic.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "Flights_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flights {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int flight_id;
    private String flight_name;
    private boolean isDomestic;
    private boolean status;
    private String arrivedAirport;
    private String departureAirport;
    private String departureTime;
    private String arrivalTime;
    private double ticketPrice;
    private int capacity;
    @ManyToOne
    @JoinColumn(name = "runway_id")
    private Runway runway;
    @ManyToOne
    @JoinColumn(name = "terminal_id")
    private Terminal terminal;

}