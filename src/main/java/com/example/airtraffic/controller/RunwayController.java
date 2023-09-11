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
    @GetMapping("/{runway_id}")
    public ResponseEntity<Runway> getRunwayById(@PathVariable int runway_id){
        return runwayService.getRunwayById(runway_id);
    }
    @PostMapping("/create")
    public ResponseEntity<Runway> createRunway(@RequestBody Runway runway){
        return runwayService.createRunway(runway);
    }
    @PutMapping("/update/{runway_id}")
    public ResponseEntity<Runway> updateRunway(@PathVariable int runway_id,@RequestBody Runway updatedRunway){
        return runwayService.updateRunway(runway_id, updatedRunway);
    }
    @DeleteMapping("/delete/{runway_id}")
    public ResponseEntity<Void> deleteRunway(@PathVariable int runway_id){
        return runwayService.deleteRunway(runway_id);
    }

}
