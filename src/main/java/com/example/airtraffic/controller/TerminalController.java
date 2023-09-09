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
    @GetMapping("/{id}")
    public ResponseEntity<Terminal> getTerminalById(@PathVariable Long id){
        return terminalService.getTerminalById(id);
    }
    @PostMapping("/addTerminal")
    public ResponseEntity<Terminal> createTerminal(@RequestBody Terminal terminal){
        return terminalService.createTerminal(terminal);
    }
    @PutMapping("/updateTerminal/{id}")
    public ResponseEntity<Terminal> updateTerminal(@PathVariable Long id,@RequestBody Terminal terminal){
        return  terminalService.updateTerminal(id, terminal);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTerminal(@PathVariable Long id){
        return terminalService.deleteTerminal(id);
    }


}
