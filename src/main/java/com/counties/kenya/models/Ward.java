package com.counties.kenya.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
//@Entity
//@Table(name = "ward")
public class Ward {

    //    @Id
    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@Column(name = "name")
    @JsonProperty(value = "is_deleted")
    private String name;

    //@Column(name = "is_deleted")
    @JsonProperty(value = "is_deleted")
    private Boolean deleted;

    //@Column(name = "created_at", updatable = false)
    @JsonProperty(value = "created_at")
    private LocalDateTime createdAt;

   //@Column(name = "sub_county_id")
    @JsonProperty(value = "sub_county_id")
    private Integer subCountyId;

    public Ward() {
    }

    public Ward(String name, boolean deleted, LocalDateTime createdAt, Integer subCountyId) {
        this.name = name;
        this.deleted = deleted;
        this.createdAt = createdAt;
        this.subCountyId = subCountyId;
    }

    public Ward(Integer id, String name, Boolean deleted, Integer subCountyId) {
        this.id = id;
        this.name = name;
        this.deleted = deleted;
        this.subCountyId = subCountyId;
    }
}
