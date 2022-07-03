package com.jnu.pumpvisualize.repository;

import com.jnu.pumpvisualize.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<Component,Long> {
}
