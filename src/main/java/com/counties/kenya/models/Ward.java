package com.counties.kenya.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter

public class Ward {

    @DocumentId
    private String id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "deleted")
    private Boolean deleted;

    @JsonProperty(value = "createdAt")
    private String createdAt;

    @JsonProperty(value = "subCountyId")
    private Integer subCountyId;

    public Ward() {

    }

    public Ward(String name, boolean deleted, String createdAt, Integer subCountyId) {
        this.name = name;
        this.deleted = deleted;
        this.createdAt = createdAt;
        this.subCountyId = subCountyId;
    }

    public Ward(String id, String name, Boolean deleted, Integer subCountyId) {
        this.id = id;
        this.name = name;
        this.deleted = deleted;
        this.subCountyId = subCountyId;
    }
}
