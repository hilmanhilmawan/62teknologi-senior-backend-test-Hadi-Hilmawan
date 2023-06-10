package com.enamdua.request;

import lombok.Data;

import java.time.LocalTime;

@Data
public class BusinessesRequest {
    private String id;
    private String name;
    private String imageUrl;
    private String url;
    private String categoriesReftId;
    private String latitude;
    private String longitude;
    private String price;
    private String locationReftId;
    private String phone;
    private String displayPhone;
    private LocalTime isOpenNow;
    private LocalTime openAt;
    private String total;

}
