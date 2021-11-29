package com.counties.kenya.repository;

import com.counties.kenya.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Repos {

    public static CountyRepository countyRepository;
    public static SubCountyRepository subCountyRepository;
    public static WardRepository wardRepository;


    //service
    public static DataService dataService;

    @Autowired
    public void setDataService(DataService dataService) {
        Repos.dataService = dataService;
    }

    @Autowired
    public void setCountyRepository(CountyRepository countyRepository) {
        Repos.countyRepository = countyRepository;
    }

    @Autowired
    public void setSubCountyRepository(SubCountyRepository subCountyRepository) {
        Repos.subCountyRepository = subCountyRepository;
    }

    @Autowired
    public void setWardRepository(WardRepository wardRepository) {
        Repos.wardRepository = wardRepository;
    }
}
