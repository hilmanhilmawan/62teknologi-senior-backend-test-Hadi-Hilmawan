package com.enamdua.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "businesses")
public class Businesses {
    @Id
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private String id;

    @Column(name = "alias")
    private String alias;

    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "is_closed")
    private boolean isClosed = true;

    @Column(name = "url")
    private String url;

    @Column(name = "review_count")
    private String reviewCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categories_id", referencedColumnName = "id")
    private Categories categories;

    @Column(name = "rating")
    private String rating;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "transactions")
    private String transactions;

    @Column(name = "price")
    private String price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @Column(name = "phone")
    private String phone;

    @Column(name = "display_phone")
    private String displayPhone;

    @Column(name = "distance")
    private String distance;

    @Column(name = "is_open_now")
    private LocalTime isOpenNow;

    @Column(name = "open_at")
    private LocalTime openAt;

    @Column(name = "total")
    private String total;

    @PrePersist
    public void initializeUUID() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
