package com.counties.kenya.repository;

import com.counties.kenya.models.County;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CountyRepo extends JpaRepository<County,Integer>, JpaSpecificationExecutor<County> {

}
