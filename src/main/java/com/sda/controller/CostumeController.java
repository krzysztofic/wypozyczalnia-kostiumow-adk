package com.sda.controller;

import com.sda.model.Costume;
import com.sda.model.User;
import com.sda.repository.CostumeRepository;
import com.sda.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CostumeController {

    private final OrderService orderService;

    public CostumeController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    private CostumeRepository costumeRepository;

    @GetMapping("/")
    public ModelAndView showWebSite(@ModelAttribute Costume costume) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("costumes", orderService.findAll());
        return modelAndView;
    }

    @GetMapping(value = "/costume/{id}", produces = "application/json")
    public ModelAndView findAllCostumes(@PathVariable(required = false) Long id) {
        ModelAndView modelAndView = new ModelAndView("costume");
        return modelAndView;
    }

    @GetMapping("/costumes")
    public ModelAndView showAll(Model model, @RequestParam(defaultValue = "0")int page) {
        ModelAndView modelAndView = new ModelAndView("costumes");
        modelAndView.addObject("costumes", costumeRepository.findAll(PageRequest.of(page, 6)));
        model.addAttribute("currentPage", page);
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
}

