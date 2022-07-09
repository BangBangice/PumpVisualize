package com.jnu.pumpvisualize.service;

import com.jnu.pumpvisualize.entity.Component;
import com.jnu.pumpvisualize.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentServiceImpl implements ComponentService{
    @Autowired
    ComponentRepository componentRepository;
    @Override
    public List<Component> findAllComponents() {
        return componentRepository.findAll();
    }
}
