package com.counties.kenya.service;

import com.counties.kenya.models.County;
import com.counties.kenya.models.SubCounty;
import com.counties.kenya.models.Ward;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import static com.counties.kenya.repository.Repos.*;

@Service
public class DataServiceImpl implements DataService {


    @Override
    public County saveCounty(County county) {
        return countyRepository.save(county);
    }

    @Override
    public County updateCounty(County county) {
        return countyRepo.save(county);
    }

    @Override
    public Page<County> getCounties(PageRequest pageRequest) {
        return countyRepo.findAll(pageRequest);
    }

    @Override
    public SubCounty saveSubCounty(SubCounty subCounty) {
        return subCountyRepository.save(subCounty);
    }

    @Override
    public SubCounty updateSubCounty(SubCounty subCounty) {
        return subCountyRepo.save(subCounty);
    }

    @Override
    public Page<SubCounty> getSubCounties(PageRequest pageRequest) {
        return subCountyRepo.findAll(pageRequest);
    }

    @Override
    public Ward saveWard(Ward ward) {
        return wardRepository.save(ward);
    }

    @Override
    public Ward updateWard(Ward ward) {
        return wardRepo.save(ward);
    }

    @Override
    public Page<Ward> getWard(PageRequest pageRequest) {
        return wardRepo.findAll(pageRequest);
    }

}
