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
@Table(name = "county")
public class County {
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @DocumentId
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
