package com.jnu.pumpvisualize.service;

import com.jnu.pumpvisualize.entity.Measure;
import com.jnu.pumpvisualize.repository.MeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MeasureServiceImpl implements MeasureService{
    @Autowired
    MeasureRepository measureRepository;
    @Override
    public List<Measure> findAllMeasures() {
        return measureRepository.findAll();
    }

    @Override
    public List<Measure> findMeasuresByComponent_id(int component_id) {
        return measureRepository.findMeasureByComponent_id(component_id);
    }
}
