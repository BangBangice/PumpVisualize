package com.jnu.pumpvisualize.service;

import com.jnu.pumpvisualize.entity.Component;
import com.jnu.pumpvisualize.entity.Data;
import com.jnu.pumpvisualize.entity.Measure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseServiceImpl implements DatabaseService{
    @Autowired
    ComponentServiceImpl componentService;
    @Autowired
    DataServiceImpl dataServiceImpl;
    @Autowired
    MeasureServiceImpl measureServiceImpl;


    @Override
    public List<Data> getAllDatas() {
        return dataServiceImpl.findAlldatas();
    }

    @Override
    public List<Component> getAllComponents() {
        return componentService.findAllComponents();
    }

    @Override
    public List<Measure> getAllMeasures() {
        return measureServiceImpl.findAllMeasures();
    }

    @Override
    public List<Measure> findMeasuresByComponent_id(int component_id) {
        return measureServiceImpl.findMeasuresByComponent_id(component_id);
    }

    @Override
    public List<Data> findSampledData() {
        return dataServiceImpl.findSampledData();
    }
}
