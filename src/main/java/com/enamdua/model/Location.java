package com.enamdua.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "location")
public class Location {
    @Id
    @JsonIgnore
    @Column(name = "id", columnDefinition = "VARCHAR(50)", unique = true, updatable = false, nullable = false)
    private Long id;

    @Column(name = "reft_id", unique = true, updatable = false, nullable = false)
    private String reftId;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "address3")
    private String address3;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @PrePersist
    public void initializeUUID() {
        if (reftId == null) {
            reftId = UUID.randomUUID().toString();
        }
    }
}
