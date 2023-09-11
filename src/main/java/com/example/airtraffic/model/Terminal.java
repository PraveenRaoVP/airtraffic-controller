package com.example.airtraffic.model;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Terminal_id")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Terminal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int terminal_id;
    private String name;
    private boolean isDomestic;
    private int flightParkingCapacity;
    private String location;
    @OneToMany(mappedBy = "terminal",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Flights> flights;
}