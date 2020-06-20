package com.sda.controller;

import com.sda.model.Costume;
import com.sda.model.Customer;
import com.sda.repository.CostumeRepository;
import com.sda.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CostumeController {

    private final OrderService orderService;

    public CostumeController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public ModelAndView showWebSite(@ModelAttribute Costume costume) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("costumes", orderService.findAll(PageRequest.of(0, 6)));
        return modelAndView;
    }

    @GetMapping(value = "/costume/{id}", produces = "application/json")
    public ModelAndView findAllCostumes(@PathVariable(required = false) Long id) {
        ModelAndView modelAndView = new ModelAndView("costume");
        return modelAndView;
    }

    @GetMapping("/costumes")
    public ModelAndView showAll(@RequestParam(defaultValue = "0")int page) {
        ModelAndView modelAndView = new ModelAndView("costumes");
        modelAndView.addObject("costumes", orderService.findAll(PageRequest.of(page, 6)));
        modelAndView.addObject("currentPage", page);
        return modelAndView;
    }

    @GetMapping("/rentForm")
    public String sendForm(Customer customer) {
        return "rentForm";
    }

    @PostMapping("/rentForm")
    public String handleCostumeForm(@ModelAttribute Customer customer) {
        return "thank-you";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}

