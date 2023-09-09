package com.example.airtraffic.controller;
import com.example.airtraffic.model.Runway;
import com.example.airtraffic.service.RunwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/runways")

public class RunwayController {
    @Autowired
    private RunwayService runwayService;

    public RunwayController(RunwayService runwayService){
        this.runwayService = runwayService;
    }
    @GetMapping("/allRunways")
    public ResponseEntity<List<Runway>> getAllRunways(){
        return runwayService.getAllRunways();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Runway> getRunwayById(@PathVariable Long id){
        return runwayService.getRunwayById(id);
    }
    @PostMapping("/create")
    public ResponseEntity<Runway> createRunway(@RequestBody Runway runway){
        return runwayService.createRunway(runway);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Runway> updateRunway(@PathVariable Long id,@RequestBody Runway updatedRunway){
        return runwayService.updateRunway(id, updatedRunway);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRunway(@PathVariable Long id){
        return runwayService.deleteRunway(id);
    }

}
