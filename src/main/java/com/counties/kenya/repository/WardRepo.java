package com.counties.kenya.repository;

import com.counties.kenya.models.SubCounty;
import com.counties.kenya.models.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface WardRepo extends JpaRepository<Ward,Integer>, JpaSpecificationExecutor<Ward> {

}
