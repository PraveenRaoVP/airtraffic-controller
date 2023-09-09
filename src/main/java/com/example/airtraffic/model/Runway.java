package com.example.airtraffic.model;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.util.List;

@Entity

public class Runway {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private boolean isRunWayAvailable;
    private int length;
    @OneToMany(mappedBy = "runway")
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

    public boolean isRunWayAvailable() {
        return isRunWayAvailable;
    }

    public void setRunWayAvailable(boolean runWayAvailable) {
        isRunWayAvailable = runWayAvailable;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<Flights> getFlights() {
        return flights;
    }

    public void setFlights(List<Flights> flights) {
        this.flights = flights;
    }
}