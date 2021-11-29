package com.counties.kenya.repository;

import com.counties.kenya.models.Ward;
import com.counties.kenya.utils.AbstractFirestoreRepository;
import com.google.cloud.firestore.Firestore;
import org.springframework.stereotype.Repository;

@Repository
public class WardRepository extends AbstractFirestoreRepository<Ward> {

    public static final String WARD = "ward";

    protected WardRepository(Firestore firestore) {
        super(firestore, WARD);
    }
}
