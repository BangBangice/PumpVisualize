package com.jnu.pumpvisualize.repository;

import com.jnu.pumpvisualize.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DataRepository extends JpaRepository<Data,Long> {

    @Query(nativeQuery = true,value="select * from data WHERE datetime%40000=0 LIMIT 10")
    public List<Data> findSampledData();

}
