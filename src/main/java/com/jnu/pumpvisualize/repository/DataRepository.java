package com.jnu.pumpvisualize.repository;

import com.jnu.pumpvisualize.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data,Long> {
}
