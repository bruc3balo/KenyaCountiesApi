package com.counties.kenya.service;

import com.counties.kenya.models.County;
import com.counties.kenya.models.SubCounty;
import com.counties.kenya.models.Ward;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface DataService {
    County saveCounty(County county);
    County updateCounty(County county);
    Page<County> getCounties(PageRequest pageRequest);

    SubCounty saveSubCounty(SubCounty subCounty);
    SubCounty updateSubCounty(SubCounty subCounty);
    Page<SubCounty> getSubCounties(PageRequest pageRequest);

    Ward saveWard(Ward ward);
    Ward updateWard(Ward ward);
    Page<Ward> getWard(PageRequest pageRequest);
}
