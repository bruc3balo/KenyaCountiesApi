package com.counties.kenya.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ward")
public class Ward {

    @Id
    @DocumentId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    @JsonProperty(value = "name")
    private String name;

    @Column(name = "deleted")
    @JsonProperty(value = "deleted")
    private Boolean deleted;

    @Column(name = "createdAt", updatable = false)
    @JsonProperty(value = "createdAt")
    private String createdAt;

    @Column(name = "subCountyId")
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
