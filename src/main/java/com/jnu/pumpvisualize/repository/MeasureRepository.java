package com.jnu.pumpvisualize.repository;

import com.jnu.pumpvisualize.entity.Measure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasureRepository extends JpaRepository<Measure,Long> {
}
