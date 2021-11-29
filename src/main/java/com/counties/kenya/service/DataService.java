package com.counties.kenya.service;

import com.counties.kenya.models.County;
import com.counties.kenya.models.SubCounty;
import com.counties.kenya.models.Ward;
import com.google.api.gax.paging.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface DataService {
    County saveCounty(County county);
    County updateCounty(County county);
    List<County> getCounties();

    SubCounty saveSubCounty(SubCounty subCounty);
    SubCounty updateSubCounty(SubCounty subCounty);
    List<SubCounty> getSubCounties();

    Ward saveWard(Ward ward);
    Ward updateWard(Ward ward);
    List<Ward> getWard();
}
