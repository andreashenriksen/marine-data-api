package com.demo.controller;

import com.demo.model.MarineData;
import com.demo.utils.MarineDataUtils;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/marine-data")
public class MarineDataController {

    private List<MarineData> marineDataList;

    @PostConstruct
    public void init() {
        marineDataList = new ArrayList<>();
        marineDataList.add(new MarineData(0L, "Location1", "25.5"));
        marineDataList.add(new MarineData(1L, "Location2", "23.8"));
    }

    @GetMapping
    public List<MarineData> getAllMarineData() {
        return marineDataList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMarineDataById(@PathVariable Long id) {
        MarineData marineData = findMarineDataById(id);

        if (marineData != null) {
            return ResponseEntity.ok(marineData);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marine data not found with ID: " + id);
        }
    }

    private MarineData findMarineDataById(Long id) {
        return marineDataList.stream()
                .filter(data -> Objects.equals(data.getId(), id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public ResponseEntity<String> addMarineData(@RequestBody MarineData marineData) {
        try {
            marineData.setId(MarineDataUtils.getNextId(marineDataList));
            marineDataList.add(marineData);
            return ResponseEntity.ok("Marine data added successfully");
        } catch (Exception e) {
            // Log the exception details
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateMarineData(@PathVariable Long id, @RequestBody MarineData updatedData) {
        MarineData existingData = findMarineDataById(id);
        if (existingData != null) {
           existingData.setLocation(updatedData.getLocation());
           existingData.setTemperature(updatedData.getTemperature());

           return ResponseEntity.ok("Marine data updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marine data not found with ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMarineData(@PathVariable Long id) {
        MarineData dataToDelete = findMarineDataById(id);

        if (dataToDelete != null) {
            marineDataList.remove(dataToDelete);
            return ResponseEntity.ok("Marine data deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marine data not found with id: " + id);
        }
    }
}
