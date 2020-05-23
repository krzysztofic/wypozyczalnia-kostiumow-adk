package com.sda.controller;


import com.sda.model.Costume;
import com.sda.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class CostumeController {

    private final OrderService orderService;

    public CostumeController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/costumes", produces = "application/json")
    public Set<Costume> findAllCostumes (@RequestParam(required = false) Long id) {

        return orderService.findAll(id);
    }



}
