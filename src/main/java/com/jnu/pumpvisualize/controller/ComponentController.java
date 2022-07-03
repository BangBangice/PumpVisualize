package com.jnu.pumpvisualize.controller;

import com.jnu.pumpvisualize.entity.Component;
import com.jnu.pumpvisualize.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ComponentController {
    @Autowired
    private ComponentRepository componentRepository;
    @GetMapping("/component")
    public List<Component> getComponent(){
        return componentRepository.findAll();
    }
}
