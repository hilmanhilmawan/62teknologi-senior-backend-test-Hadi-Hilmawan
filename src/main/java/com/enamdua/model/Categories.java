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
@Table(name = "categories")
public class Categories {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reft_id", unique = true, updatable = false, nullable = false)
    private String reftId;

    @Column(name = "alias")
    private String alias;

    @Column(name = "title")
    private String title;

    @PrePersist
    public void initializeUUID() {
        if (reftId == null) {
            reftId = UUID.randomUUID().toString();
        }
    }
}
