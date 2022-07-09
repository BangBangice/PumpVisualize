package com.jnu.pumpvisualize.repository;

import com.jnu.pumpvisualize.entity.Measure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MeasureRepository extends JpaRepository<Measure,Long> {
    @Query("select measure from Measure measure where measure.component_id=?1")
    public List<Measure> findMeasureByComponent_id(int component_id);
}
