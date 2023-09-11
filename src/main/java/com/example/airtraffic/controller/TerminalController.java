package com.example.airtraffic.controller;
import com.example.airtraffic.model.Terminal;
import com.example.airtraffic.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/terminals")
public class TerminalController {
    @Autowired
    private TerminalService terminalService;
    @GetMapping("/allTerminals")
    public ResponseEntity<List<Terminal>> getAllTerminals(){
        return terminalService.getAllTerminals();
    }
    @GetMapping("/{terminal_id}")
    public ResponseEntity<Terminal> getTerminalById(@PathVariable int terminal_id){
        Terminal terminal = terminalService.getTerminalById(terminal_id);
        return new ResponseEntity<>(terminal, org.springframework.http.HttpStatus.OK);
    }
    @PostMapping("/addTerminal")
    public ResponseEntity<Terminal> createTerminal(@RequestBody Terminal terminal){
        return terminalService.createTerminal(terminal);
    }
    @PutMapping("/updateTerminal/{terminal_id}")
    public ResponseEntity<Terminal> updateTerminal(@PathVariable int terminal_id,@RequestBody Terminal terminal){
        return  terminalService.updateTerminal(terminal_id, terminal);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTerminal(@PathVariable int terminal_id){
        return terminalService.deleteTerminal(terminal_id);
    }
}
