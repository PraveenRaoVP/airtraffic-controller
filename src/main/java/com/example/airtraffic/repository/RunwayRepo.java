package com.example.airtraffic.repository;

import com.example.airtraffic.model.Runway;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunwayRepo extends JpaRepository<Runway,Integer> {
}
