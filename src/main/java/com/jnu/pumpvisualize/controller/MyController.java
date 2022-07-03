package com.jnu.pumpvisualize.controller;

import com.jnu.pumpvisualize.entity.Measure;
import com.jnu.pumpvisualize.repository.MeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    MeasureRepository measureRepository;

    @RequestMapping("/")
    public String homePage(Model model){
        List<Measure> measures=measureRepository.findAll();
        model.addAttribute("measures",measures);
        return "index";
    }
    @RequestMapping("/line_chart")
    public String lineChart(){
        return "line_chart";
    }
    @RequestMapping("/table")
    public String table(){
        return "table";
    }
}
