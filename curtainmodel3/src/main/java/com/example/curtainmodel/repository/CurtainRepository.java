package com.example.curtainmodel.repository;



import com.example.curtainmodel.entity.Curtain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurtainRepository extends JpaRepository<Curtain, Integer> {

    @Query("SELECT c FROM Curtain c WHERE c.price > :price")
    List<Curtain> getIdByPrice(@Param("price") int price);

    @Query("SELECT c FROM Curtain c WHERE c.brand = :brand")
    List<Curtain> getIdByBrand(@Param("brand") String brand);
}
