package com.example.airtraffic.service;
import com.example.airtraffic.dao.FlightsDAO;
import com.example.airtraffic.model.Flights;
import com.example.airtraffic.model.Runway;
import com.example.airtraffic.model.Terminal;
import com.example.airtraffic.repository.FlightRepo;
import com.example.airtraffic.repository.RunwayRepo;
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
    @Autowired
    private RunwayService runwayService;
    @Autowired
    private TerminalService terminalService;
    public ResponseEntity<List<Flights>> getAllFlights(){
        List<Flights> flights = flightRepo.findAll();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
    public Flights getFlightById(int flight_id){
        Optional<Flights> optionalFlights = flightRepo.findById(flight_id);
        return optionalFlights.orElse(new Flights());
    }
    public List<Flights> getFlightsByRunway(Runway runway){
        return flightRepo.findByRunway(runway);
    }
    public List<Flights> getFlightsByTerminals(Terminal terminal){
        return flightRepo.findByTerminal(terminal);
    }
    public Flights createNewFlight(FlightsDAO flightsDAO) {
        Flights flights = new Flights();
        flights.setFlight_name(flightsDAO.getFlight_name());
        flights.setDomestic(flightsDAO.isDomestic());
        flights.setStatus(flightsDAO.isStatus());
        flights.setCapacity(flightsDAO.getCapacity());
        flights.setArrivedAirport(flightsDAO.getArrivedAirport());
        flights.setDepartureAirport(flightsDAO.getDepartureAirport());
        flights.setArrivalTime(flightsDAO.getArrivalTime());
        flights.setDepartureTime(flightsDAO.getDepartureTime());
        flights.setTicketPrice(flightsDAO.getTicketPrice());

        // Get the Runway and Terminal objects
        Runway runway = runwayService.getRunwayById(flightsDAO.getRunwayId());
        Terminal terminal = terminalService.getTerminalById(flightsDAO.getTerminalId());

        if (runway == null || terminal == null) {
            // Handle the case where either the Runway or Terminal is not found
            // You may return an error response or throw an exception
            // Example: throw new ResourceNotFoundException("Runway or Terminal not found");
            return null; // Modify this line based on your error handling strategy
        }

        flights.setRunway(runway);
        flights.setTerminal(terminal);

        // Save the Runway entity if it's new
        if (runway.getRunway_id() == 0) {
            runway = runwayService.createRunway(runway).getBody();
        }

        return flightRepo.save(flights);
    }

    public Flights updateFlight(int flight_id,Flights updatedFlight){
        Optional<Flights> optionalFlights1 = flightRepo.findById(flight_id);
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
    public void deleteFlight(int flight_id){
        flightRepo.deleteById(flight_id);
    }

}
