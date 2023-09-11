package com.example.airtraffic.model;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Table(name = "Runway_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Runway {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int runway_id;
    private String name;
    private boolean isRunWayAvailable;
    private int length;
    @OneToMany(mappedBy = "runway",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Flights> flights;

}