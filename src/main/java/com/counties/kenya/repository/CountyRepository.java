package com.counties.kenya.repository;

import com.counties.kenya.models.County;
import com.counties.kenya.utils.AbstractFirestoreRepository;
import com.google.cloud.firestore.Firestore;
import org.springframework.stereotype.Repository;

@Repository
public class CountyRepository extends AbstractFirestoreRepository<County> {

    public static final String COUNTY = "county";

    protected CountyRepository(Firestore firestore) {
        super(firestore, COUNTY);
    }
}
