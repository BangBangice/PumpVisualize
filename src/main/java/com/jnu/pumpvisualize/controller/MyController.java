package com.jnu.pumpvisualize.controller;

import com.jnu.pumpvisualize.entity.Measure;
import com.jnu.pumpvisualize.service.DatabaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.valueOf;

@Controller
public class MyController {
    @Autowired
    DatabaseServiceImpl databaseService;

    @RequestMapping("/")
    public String homePage(Model model){
        List<Measure> measures= databaseService.getAllMeasures();
        List<Measure> measure_Component1;
        List<Measure> measure_Component2;
        List<Measure> measure_Component3;
        List<Measure> measure_Component4;
        List<Measure> measure_Component5;
        List<Measure> measure_Component6;
        List<Measure> measure_Component7;
        List<Measure> measure_Component8;

//        List<List> MeasureLists=new ArrayList<>();
//        MeasureLists.add(measure_Component1);

        measure_Component1=databaseService.findMeasuresByComponent_id(1);
        measure_Component2=databaseService.findMeasuresByComponent_id(2);
        measure_Component3=databaseService.findMeasuresByComponent_id(3);
        measure_Component4=databaseService.findMeasuresByComponent_id(4);
        measure_Component5=databaseService.findMeasuresByComponent_id(5);
        measure_Component6=databaseService.findMeasuresByComponent_id(6);
        measure_Component7=databaseService.findMeasuresByComponent_id(7);
        measure_Component8=databaseService.findMeasuresByComponent_id(8);

        model.addAttribute("measures",measures);
        model.addAttribute("measure_Component1",measure_Component1);
        model.addAttribute("measure_Component2",measure_Component2);
        model.addAttribute("measure_Component3",measure_Component3);
        model.addAttribute("measure_Component4",measure_Component4);
        model.addAttribute("measure_Component5",measure_Component5);
        model.addAttribute("measure_Component6",measure_Component6);
        model.addAttribute("measure_Component7",measure_Component7);
        model.addAttribute("measure_Component8",measure_Component8);




        return "index";
    }
    @RequestMapping("/line_chart")
    public String lineChart(){
        return "line_chart";
    }
    @RequestMapping("/table")
    public String table(){
        return "table";
    }
}
