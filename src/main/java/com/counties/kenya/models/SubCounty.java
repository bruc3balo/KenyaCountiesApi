package com.counties.kenya.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter


public class SubCounty {


    @DocumentId
    private String id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "deleted")
    private Boolean deleted;

    @JsonProperty(value = "createdAt")
    private String createdAt;

    @JsonProperty(value = "countyId")
    private Integer countyId;

    public SubCounty() {

    }

    public SubCounty(String name, Integer countyId) {
        this.name = name;
        this.countyId = countyId;
    }

    public SubCounty(String name, boolean deleted, String createdAt, Integer countyId) {
        this.name = name;
        this.deleted = deleted;
        this.createdAt = createdAt;
        this.countyId = countyId;
    }

    public SubCounty(String id, Integer countyId, String name, Boolean deleted) {
        this.name = name;
        this.deleted = deleted;
        this.id = id;
        this.countyId = countyId;
    }
}
