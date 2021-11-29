package com.counties.kenya.service;

import com.counties.kenya.models.County;
import com.counties.kenya.models.SubCounty;
import com.counties.kenya.models.Ward;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.counties.kenya.repository.Repos.*;

@Service
public class DataServiceImpl implements DataService {


    @Override
    public County saveCounty(County county) {
        return countyRepository.save(county);
    }

    @Override
    public List<County> getCounties(String name, String id, Boolean deleted) {
        return countyRepository.retrieveAll().stream().filter(i -> {

            boolean nameEval = true;

            boolean idEval = true;

            boolean deletedVal = true;

            if (name != null) {
                nameEval = name.equals(i.getName());
            }

            if (id != null) {
                idEval = id.equals(i.getId());
            }

            if (deleted != null) {
                deletedVal = deleted == i.getDeleted();
            }

            return nameEval && idEval && deletedVal;

        }).collect(Collectors.toList());
    }

    @Override
    public SubCounty saveSubCounty(SubCounty subCounty) {
        subCounty.setCreatedAt(LocalDateTime.now().toString());
        return subCountyRepository.save(subCounty);
    }

    @Override
    public List<SubCounty> getSubCounties(String name, String id, String countryId, Boolean deleted) {
        return subCountyRepository.retrieveAll().stream().filter(i -> {

            boolean nameEval = true;
            boolean idEval = true;
            boolean countryEval = true;
            boolean deletedEval = true;

            if (name != null) {
                nameEval = name.equals(i.getName());
            }

            if (id != null) {
                idEval = id.equals(i.getId());
            }

            if (deleted != null) {
                deletedEval = deleted == i.getDeleted();
            }

            if (countryId != null) {
                countryEval = countryId.equals(String.valueOf(i.getCountyId()));
            }



            return nameEval && idEval && countryEval && deletedEval;
        }).collect(Collectors.toList());
    }

    @Override
    public Ward saveWard(Ward ward) {
        ward.setCreatedAt(LocalDateTime.now().toString());
        return wardRepository.save(ward);
    }

    @Override
    public List<Ward> getWard(String name, String id, String subCountryId, Boolean deleted) {
        return wardRepository.retrieveAll().stream().filter(i -> {

            boolean nameEval = true;
            boolean idEval = true;
            boolean subCountryEval = true;
            boolean deletedEval = true;


            if (name != null) {
                nameEval = name.equals(i.getName());
            }

            if (id != null) {
                idEval = id.equals(i.getId());
            }

            if (deleted != null) {
                deletedEval = deleted == i.getDeleted();
            }

            if (subCountryId != null) {
                subCountryEval = subCountryId.equals(String.valueOf(i.getSubCountyId()));
            }

            return nameEval && idEval && subCountryEval && deletedEval;


        }).collect(Collectors.toList());
    }

}
