package com.sda.controller;

import com.sda.model.Costume;
import com.sda.model.Genre;
import com.sda.model.Sex;
import com.sda.model.Size;
import com.sda.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    private final OrderService orderService;

    public AdminController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/admin")
    public ModelAndView adminSite() {
        ModelAndView modelAndView = new ModelAndView("admin-site");
        modelAndView.addObject("costumes", orderService.listAll());
        return modelAndView;
    }

    @GetMapping("/admin/add")
    public ModelAndView addNewCostume() {
        ModelAndView modelAndView = new ModelAndView("admin-add");
        modelAndView.addObject("costume", new Costume());
        modelAndView.addObject("sizes", Size.values());
        modelAndView.addObject("genders", Sex.values());
        modelAndView.addObject("genres", Genre.values());
        return modelAndView;
    }

    @PostMapping(value = "/admin/add")
    public String addCostume(@ModelAttribute Costume costume) {
        orderService.add(costume.getId(), costume.getName(), costume.getSize(), costume.getGenre(),
                costume.getSex(), costume.getBorrowedTill(), costume.getImageUrl(), costume.getPrice());
        return "redirect:/admin";
    }

    @GetMapping("/admin/remove")
    public String removeCostume(@RequestParam("id") Long id) {
        orderService.remove(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/book")
    public String BookCostume() {
        return "admin-book";
    }
}
