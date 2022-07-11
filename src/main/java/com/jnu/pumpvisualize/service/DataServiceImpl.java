package com.jnu.pumpvisualize.service;

import com.jnu.pumpvisualize.entity.Data;
import com.jnu.pumpvisualize.entity.Measure;
import com.jnu.pumpvisualize.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DataServiceImpl implements DataService{
    @Autowired
    DataRepository dataRepository;
    @Override
    public List<Data> findAlldatas() {
        return dataRepository.findAll();
    }

    @Override
    public List<Data> findSampledData() {
        return dataRepository.findSampledData();
    }


}
