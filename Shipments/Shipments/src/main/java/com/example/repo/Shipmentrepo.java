package com.example.repo;

import com.example.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Shipmentrepo extends JpaRepository<Shipment, Integer> {
    Optional<Shipment> findByTrackNo(String trackNo);
}
