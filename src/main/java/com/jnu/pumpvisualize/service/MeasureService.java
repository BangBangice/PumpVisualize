package com.jnu.pumpvisualize.service;

import com.jnu.pumpvisualize.entity.Measure;

import java.util.List;

public interface MeasureService {
    List<Measure> findAllMeasures();
    List<Measure> findMeasuresByComponent_id(int component_id);
}
