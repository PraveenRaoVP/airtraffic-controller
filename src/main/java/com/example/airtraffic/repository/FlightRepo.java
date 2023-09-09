package com.example.airtraffic.repository;




import com.example.airtraffic.model.Flights;
import com.example.airtraffic.model.Runway;
import com.example.airtraffic.model.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepo extends JpaRepository<Flights,Long> {
    List<Flights> findByRunway(Runway runway);
    List<Flights> findByTerminal(Terminal terminal);
}
