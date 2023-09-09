package com.example.airtraffic.service;



import com.example.airtraffic.model.Flights;
import com.example.airtraffic.model.Runway;
import com.example.airtraffic.model.Terminal;
import com.example.airtraffic.repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class FlightService {
    @Autowired
    private FlightRepo flightRepo;
    public ResponseEntity<List<Flights>> getAllFlights(){
        List<Flights> flights = flightRepo.findAll();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
    public Flights getFlightById(Long id){
        Optional<Flights> optionalFlights = flightRepo.findById(id);
        return optionalFlights.orElse(new Flights());
    }
    public List<Flights> getFlightsByRunway(Runway runway){
        return flightRepo.findByRunway(runway);
    }
    public List<Flights> getFlightsByTerminals(Terminal terminal){
        return flightRepo.findByTerminal(terminal);
    }
    public Flights createNewFlight(Flights flights){
        return flightRepo.save(flights);
    }
    public Flights updateFlight(Long id,Flights updatedFlight){
        Optional<Flights> optionalFlights1 = flightRepo.findById(id);
        if(optionalFlights1.isPresent()){
            Flights exisitingFlights = optionalFlights1.get();
            exisitingFlights.setFlight_name(updatedFlight.getFlight_name());
            exisitingFlights.setFlight_id(updatedFlight.getFlight_id());
            exisitingFlights.setDomestic(updatedFlight.isDomestic());
            exisitingFlights.setStatus(updatedFlight.isStatus());
            exisitingFlights.setCapacity(updatedFlight.getCapacity());
            exisitingFlights.setArrivedAirport(updatedFlight.getArrivedAirport());
            exisitingFlights.setDepartureAirport(updatedFlight.getDepartureAirport());
            exisitingFlights.setArrivalTime(updatedFlight.getArrivalTime());
            exisitingFlights.setDepartureTime(updatedFlight.getDepartureTime());
            exisitingFlights.setTicketPrice(updatedFlight.getTicketPrice());
            return flightRepo.save(exisitingFlights);
        }
        return null;
    }
    public void deleteFlight(Long id){
        flightRepo.deleteById(id);
    }

}
