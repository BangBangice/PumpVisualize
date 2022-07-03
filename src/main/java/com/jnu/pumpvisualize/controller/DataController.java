package com.jnu.pumpvisualize.controller;

import com.jnu.pumpvisualize.entity.Component;
import com.jnu.pumpvisualize.entity.Data;
import com.jnu.pumpvisualize.repository.ComponentRepository;
import com.jnu.pumpvisualize.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {
    @Autowired
    private DataRepository dataRepository;
    @GetMapping("data")
    public List<Data> getData(){
        return dataRepository.findAll();
    }
}
