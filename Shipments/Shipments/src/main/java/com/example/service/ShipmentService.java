package com.example.service;

import com.example.model.Shipment;
import com.example.repo.Shipmentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipmentService {

    @Autowired
    private Shipmentrepo shipmentRepository;

    public Shipment addShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    public Optional<Shipment> getShipmentByTrackNo(String trackNo) {
        return shipmentRepository.findByTrackNo(trackNo);
    }

    public boolean deleteShipmentById(Integer shipId) {
        if (shipmentRepository.existsById(shipId)) {
            shipmentRepository.deleteById(shipId);
            return true;
        }
        return false;
    }
}
