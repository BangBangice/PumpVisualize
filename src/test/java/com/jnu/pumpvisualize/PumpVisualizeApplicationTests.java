package com.jnu.pumpvisualize;

import com.jnu.pumpvisualize.entity.Measure;
import com.jnu.pumpvisualize.service.DatabaseServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PumpVisualizeApplicationTests {
	@Autowired
	DatabaseServiceImpl databaseService;

	@Test
	void contextLoads() {


	}
	@Test
	void DatabaseTest(){
		List<Measure> measureList;
		measureList=databaseService.findMeasuresByComponent_id(1);

	}

}
