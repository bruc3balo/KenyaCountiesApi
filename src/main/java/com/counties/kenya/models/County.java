package com.counties.kenya.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "county")
public class County {
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    //@DocumentId
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

    public County() {
    }

    public County(String name) {
        this.name = name;
    }

    public County(Integer id) {
        this.id = id;
    }

    public County(Integer id, String name, boolean deleted, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.deleted = deleted;
        this.createdAt = createdAt;
    }

    public County(Integer id, String name, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.deleted = deleted;
    }
}
