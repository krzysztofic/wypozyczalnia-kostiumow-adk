package com.sda.controller;

import com.sda.repository.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CostumePageController {

    @Autowired
    private Pageable pageable;

    @GetMapping("/costumes/{page}")
    public String showPage(Model model, @RequestParam(defaultValue = "0")int page){
        model.addAttribute("data", pageable
                .findAll(PageRequest.of(page, 4)));
        model.addAttribute("currentPage, page");
        return "costumes-bootstrap";

    }
}
