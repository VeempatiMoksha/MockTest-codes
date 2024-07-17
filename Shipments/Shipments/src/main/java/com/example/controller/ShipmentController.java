package com.example.controller;

import com.example.model.Shipment;
import com.example.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

    @PostMapping("/add")
    public ResponseEntity<Shipment> addShipment(@RequestBody Shipment shipment) {
        Shipment newShipment = shipmentService.addShipment(shipment);
        return new ResponseEntity<>(newShipment, HttpStatus.CREATED);
    }

    @GetMapping("/{trackNo}")
    public ResponseEntity<Shipment> getShipmentByTrackNo(@PathVariable String trackNo) {
        Optional<Shipment> shipment = shipmentService.getShipmentByTrackNo(trackNo);
        return shipment.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{shipId}")
    public ResponseEntity<String> deleteShipmentById(@PathVariable Integer shipId) {
        boolean isDeleted = shipmentService.deleteShipmentById(shipId);
        if (isDeleted) {
            return ResponseEntity.ok("Shipment with ID " + shipId + " deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Shipment with ID " + shipId + " not found");
        }
    }
}
