package com.jnu.pumpvisualize.service;

import com.jnu.pumpvisualize.entity.Component;
import com.jnu.pumpvisualize.entity.Data;
import com.jnu.pumpvisualize.entity.Measure;

import java.util.List;

public interface DatabaseService {
    List<Data> getAllDatas();
    List<Component> getAllComponents();
    List<Measure> getAllMeasures();
    List<Measure> findMeasuresByComponent_id(int component_id);
}
