package com.sda.controller;


import com.sda.model.Costume;
import com.sda.model.User;
import com.sda.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;


@Controller
public class CostumeController {

    private final OrderService orderService;

    public CostumeController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/costume/{id}", produces = "application/json")
    public ModelAndView findAllCostumes(@PathVariable(required = false) Long id) {
        ModelAndView modelAndView = new ModelAndView("costume");
        return modelAndView;
    }

    @GetMapping("/costumes")
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("costumes-bootstrap");
        modelAndView.addObject("costumes", orderService.findAll());
        return modelAndView;
    }

    @GetMapping("/rentForm")
    public String sendForm(User user) {
        return "rentForm";
    }

    @PostMapping("/rentForm")
    public String handleCostumeForm(@ModelAttribute User user) {
        return "thank-you";
    }

    @GetMapping("/admin")
    public ModelAndView adminSite() {
        ModelAndView modelAndView = new ModelAndView("admin-site");
        modelAndView.addObject("costumes", orderService.findAll());
        return modelAndView;
    }

    @GetMapping("/admin/add")
    public String addNewCostume(Costume costume) {
        return "admin-add";
    }

    @PostMapping(value = "/admin", consumes = "application/json")
    public ResponseEntity<Long> addCostume(@RequestBody Costume costume) {
        Costume addedCostume = orderService.add(costume.getId(), costume.getName(), costume.getSize(), costume.getGenre(),
                costume.getSex(), costume.getBorrowedTill(), costume.getImageUrl(), costume.getPrice());
        return new ResponseEntity<>(addedCostume.getId(), HttpStatus.CREATED);

    }
}

