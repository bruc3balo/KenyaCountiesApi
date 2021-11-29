package com.counties.kenya.repository;

import com.counties.kenya.models.County;
import com.counties.kenya.models.SubCounty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCountyRepo extends JpaRepository<SubCounty,Integer>, JpaSpecificationExecutor<SubCounty> {

}
