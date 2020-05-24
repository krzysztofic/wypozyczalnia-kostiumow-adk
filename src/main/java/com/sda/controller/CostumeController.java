package com.sda.controller;


import com.sda.model.User;
import com.sda.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


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

    @GetMapping("/costume")
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("costumes-bootstrap");
        modelAndView.addObject("costumes", orderService.findAll());
        return modelAndView;
    }

    @PostMapping("/costume/{id}/rent")
    public String handleCostumeRent(@PathVariable("id")Long id, @ModelAttribute User user) {
        //obsluga zamowienia
        return "redirect:/thank-you";
    }

    @GetMapping("/thank-you")
    public String thankYouPage(){
        return "thank-you";
    }
}

