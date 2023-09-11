    package com.example.airtraffic.controller;
    import com.example.airtraffic.model.Flights;
    import com.example.airtraffic.model.Runway;
    import com.example.airtraffic.model.Terminal;
    import com.example.airtraffic.service.FlightService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import java.util.List;
    @RestController
    @RequestMapping("/Flights")
    public class FlightController {
        @Autowired
        private FlightService flightService;
        @GetMapping("/allFlights")
        public ResponseEntity<List<Flights>> getAllFlights() {
            ResponseEntity<List<Flights>> flights = flightService.getAllFlights();
            return flights;
        }
        @GetMapping("/FlightId/{flight_id}")
        public Flights getFlightById(@PathVariable int flight_id){
            return flightService.getFlightById(flight_id);
        }
        @GetMapping("/runway/{runway_id}")
        public List<Flights> getFlightsByRunway(@PathVariable int runway_id){
            Runway runway = new Runway();
            runway.setRunway_id(runway.getRunway_id());
            return flightService.getFlightsByRunway(runway);
        }
        public List<Flights> getFlightsByTerminal(@PathVariable int terminal_id){
            Terminal terminal = new Terminal();
            terminal.setTerminal_id(terminal.getTerminal_id());
            return flightService.getFlightsByTerminals(terminal);
        }
        @PostMapping("/create")
        public Flights createNewFlight(@RequestBody Flights flights){
            return flightService.createNewFlight(flights);
        }
        @PutMapping("/updateFlight/{flight_id}")
        public Flights updateFlight(@PathVariable int flight_id,@RequestBody Flights updatedFlights){
            return flightService.updateFlight(flight_id, updatedFlights);
        }
        @DeleteMapping("/delete{flight_id}")
        public  void  deleteFlight(@PathVariable int flight_id){
            flightService.deleteFlight(flight_id);
        }
    }