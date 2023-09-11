package com.example.airtraffic.service;



import com.example.airtraffic.model.Runway;
import com.example.airtraffic.repository.RunwayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RunwayService {
    @Autowired
    private RunwayRepo runwayRepo;

    public ResponseEntity<List<Runway>> getAllRunways(){
        List<Runway> runways = runwayRepo.findAll();
        return new ResponseEntity<>(runways, HttpStatus.OK);
    }
    public ResponseEntity<Runway> getRunwayById(int runway_id){
        Optional<Runway> optionalRunway = runwayRepo.findById(runway_id);
        if (optionalRunway.isPresent()){
            return new ResponseEntity<>(optionalRunway.get(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Runway> createRunway(Runway runway){
        Runway createdRunway = runwayRepo.save(runway);
        return new ResponseEntity<>(createdRunway,HttpStatus.CREATED);
    }
    public ResponseEntity<Runway> updateRunway(int runway_id,Runway updatedRunway){
        Optional<Runway> optionalRunway = runwayRepo.findById(runway_id);
        if (optionalRunway.isPresent()){
            Runway existingRunway = optionalRunway.get();
            existingRunway.setName(updatedRunway.getName());
            existingRunway.setRunWayAvailable(updatedRunway.isRunWayAvailable());
            existingRunway.setRunway_id(updatedRunway.getRunway_id());
            existingRunway.setLength(updatedRunway.getLength());
            Runway updatedRunwayEntity = runwayRepo.save(existingRunway);
            return new ResponseEntity<>(updatedRunwayEntity,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Void> deleteRunway(int runway_id){
        Optional<Runway> optionalRunway = runwayRepo.findById(runway_id);
        if (optionalRunway.isPresent()){
            runwayRepo.deleteById(runway_id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
