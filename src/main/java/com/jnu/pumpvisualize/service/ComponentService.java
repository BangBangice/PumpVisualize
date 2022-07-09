package com.jnu.pumpvisualize.service;

import com.jnu.pumpvisualize.entity.Component;
import com.jnu.pumpvisualize.repository.ComponentRepository;

import java.util.List;

public interface ComponentService  {
    List<Component> findAllComponents();
}
