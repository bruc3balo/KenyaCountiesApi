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
@Table(name = "sub_county")
public class SubCounty {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @DocumentId
    private Integer id;

    @Column(name = "name")
    @JsonProperty(value = "name")
    private String name;

    @Column(name = "deleted")
    @JsonProperty(value = "deleted")
    private Boolean deleted;

    @Column(name = "createdAt", updatable = false)
    @JsonProperty(value = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "countyId")
    @JsonProperty(value = "countyId")
    private Integer countyId;

    public SubCounty() {

    }

    public SubCounty(String name, Integer countyId) {
        this.name = name;
        this.countyId = countyId;
    }

    public SubCounty(String name, boolean deleted, LocalDateTime createdAt, Integer countyId) {
        this.name = name;
        this.deleted = deleted;
        this.createdAt = createdAt;
        this.countyId = countyId;
    }

    public SubCounty(Integer id, Integer countyId, String name, Boolean deleted) {
        this.name = name;
        this.deleted = deleted;
        this.id = id;
        this.countyId = countyId;
    }
}
