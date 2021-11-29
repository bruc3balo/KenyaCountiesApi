package com.counties.kenya.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter

public class County {

    @DocumentId
    private String id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "deleted")
    private Boolean deleted;

    @JsonProperty(value = "createdAt")
    private String createdAt;

    public County() {
    }



    public County(String id, String name, boolean deleted, String createdAt) {
        this.id = id;
        this.name = name;
        this.deleted = deleted;
        this.createdAt = createdAt;
    }

    public County(String id, String name, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.deleted = deleted;
    }
}
