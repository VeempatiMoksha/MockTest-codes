package com.example.curtainmodel.controller;


import com.example.curtainmodel.entity.Curtain;
import com.example.curtainmodel.service.CurtainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curtains")
public class CurtainController {

    @Autowired
    private CurtainService curtainService;

    @GetMapping("/price/{price}")
    public List<Curtain> getCurtainsByPrice(@PathVariable int price) {
        return curtainService.getCurtainsByPrice(price);
    }

    @GetMapping("/brand/{brand}")
    public List<Curtain> getCurtainsByBrand(@PathVariable String brand) {
        return curtainService.getCurtainsByBrand(brand);
    }
}
