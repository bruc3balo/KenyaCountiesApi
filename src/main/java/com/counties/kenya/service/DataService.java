package com.counties.kenya.service;

import com.counties.kenya.models.County;
import com.counties.kenya.models.SubCounty;
import com.counties.kenya.models.Ward;


import java.util.List;
import java.util.Optional;

public interface DataService {
    County saveCounty(County county);
    List<County> getCounties(String name,String id,Boolean deleted);



    SubCounty saveSubCounty(SubCounty subCounty);
    List<SubCounty> getSubCounties(String name,String id,String countryId,Boolean deleted);



    Ward saveWard(Ward ward);
    List<Ward> getWard(String name,String id,String subCountryId,Boolean deleted);



}
