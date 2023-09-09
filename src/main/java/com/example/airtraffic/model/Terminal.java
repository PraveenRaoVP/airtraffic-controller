package com.example.airtraffic.model;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Terminal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private boolean isDomestic;
    private int flightParkingCapacity;
    private String location;
    @OneToMany(mappedBy = "terminal")
    @JsonManagedReference
    private List<Flights> flights;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDomestic() {
        return isDomestic;
    }

    public void setDomestic(boolean domestic) {
        isDomestic = domestic;
    }

    public int getflightParkingCapacity() {
        return flightParkingCapacity;
    }

    public void setflightParkingCapacity(int flightParkingCapacity) {
        this.flightParkingCapacity = flightParkingCapacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Flights> getFlights() {
        return flights;
    }

    public void setFlights(List<Flights> flights) {
        this.flights = flights;
    }
}