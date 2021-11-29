package com.counties.kenya.service;

import com.counties.kenya.models.County;
import com.counties.kenya.models.SubCounty;
import com.counties.kenya.models.Ward;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

import static com.counties.kenya.repository.Repos.*;

@Service
public class DataServiceImpl implements DataService {


    @Override
    public County saveCounty(County county) {
        return countyRepository.save(county);
    }

    @Override
    public County updateCounty(County county) {
        return countyRepository.save(county);
    }

    @Override
    public List<County> getCounties() {
        return countyRepository.retrieveAll();
    }

    @Override
    public SubCounty saveSubCounty(SubCounty subCounty) {
        return subCountyRepository.save(subCounty);
    }

    @Override
    public SubCounty updateSubCounty(SubCounty subCounty) {
        return subCountyRepository.save(subCounty);
    }

    @Override
    public List<SubCounty> getSubCounties() {
        return subCountyRepository.retrieveAll();
    }

    @Override
    public Ward saveWard(Ward ward) {
        return wardRepository.save(ward);
    }

    @Override
    public Ward updateWard(Ward ward) {
        return wardRepository.save(ward);
    }

    @Override
    public List<Ward> getWard() {
        return wardRepository.retrieveAll();
    }
}
