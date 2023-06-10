package com.enamdua.response;

import com.enamdua.dto.Categories;
import com.enamdua.dto.Location;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BusinessesResponse {
    private String alias;
    private Categories categories = new Categories();
    private String latitude;
    private String longitude;
    private String displayPhone;
    private String distance;
    private String id;
    private String imageUrl;
    private String isClosed;
    private Location location = new Location();
    private String name;
    private String phone;
    private String price;
    private String rating;
    private String reviewCount;
    private String url;
    private String total;

}
