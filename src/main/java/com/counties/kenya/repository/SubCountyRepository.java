package com.counties.kenya.repository;

import com.counties.kenya.models.SubCounty;
import com.counties.kenya.utils.AbstractFirestoreRepository;
import com.google.cloud.firestore.Firestore;
import org.springframework.stereotype.Repository;

@Repository
public class SubCountyRepository extends AbstractFirestoreRepository<SubCounty> {
    public static final String SUB_COUNTY = "sub_county";

    protected SubCountyRepository(Firestore firestore) {
        super(firestore, SUB_COUNTY);
    }
}
