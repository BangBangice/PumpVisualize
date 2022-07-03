package com.jnu.pumpvisualize.controller;

import com.jnu.pumpvisualize.entity.Measure;
import com.jnu.pumpvisualize.repository.MeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MeasureController {
    @Autowired
    MeasureRepository measureRepository;
    @GetMapping("measure")
    public List<Measure> getMeasure(){
        return measureRepository.findAll();
    }
}
