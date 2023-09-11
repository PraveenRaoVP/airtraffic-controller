package com.example.airtraffic.service;




import com.example.airtraffic.model.Terminal;
import com.example.airtraffic.repository.TerminalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class TerminalService {
    @Autowired
    private TerminalRepo terminalRepository;

    public ResponseEntity<List<Terminal>> getAllTerminals() {
        List<Terminal> terminals = terminalRepository.findAll();
        return new ResponseEntity<>(terminals, HttpStatus.OK);
    }

    public ResponseEntity<Terminal> getTerminalById(int terminal_id) {
        Optional<Terminal> optionalTerminal = terminalRepository.findById(terminal_id);
        if (optionalTerminal.isPresent()) {
            return new ResponseEntity<>(optionalTerminal.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Terminal> createTerminal(Terminal terminal) {
        Terminal createdTerminal = terminalRepository.save(terminal);
        return new ResponseEntity<>(createdTerminal, HttpStatus.CREATED);
    }

    public ResponseEntity<Terminal> updateTerminal(int terminal_id, Terminal updatedTerminal) {
        Optional<Terminal> optionalTerminal = terminalRepository.findById(terminal_id);
        if (optionalTerminal.isPresent()) {
            Terminal existingTerminal = optionalTerminal.get();
            existingTerminal.setName(updatedTerminal.getName());
            existingTerminal.setDomestic(updatedTerminal.isDomestic());
            existingTerminal.setFlightParkingCapacity(updatedTerminal.getFlightParkingCapacity());
            existingTerminal.setLocation(updatedTerminal.getLocation());
            Terminal updatedTerminalEntity = terminalRepository.save(existingTerminal);
            return new ResponseEntity<>(updatedTerminalEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> deleteTerminal(int terminal_id) {
        Optional<Terminal> optionalTerminal = terminalRepository.findById(terminal_id);
        if (optionalTerminal.isPresent()) {
            terminalRepository.deleteById(terminal_id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
