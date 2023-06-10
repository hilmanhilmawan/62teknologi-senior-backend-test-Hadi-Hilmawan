package com.enamdua.mapper;

import com.enamdua.model.Businesses;
import com.enamdua.response.BusinessesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class BusinessesMapper {
    @Mappings({
            @Mapping(target = "alias", source = "alias"),
            @Mapping(target = "categories.alias", source = "categories.alias"),
            @Mapping(target = "categories.title", source = "categories.title"),
            @Mapping(target = "latitude", source = "latitude"),
            @Mapping(target = "longitude", source = "longitude"),
            @Mapping(target = "displayPhone", source = "displayPhone"),
            @Mapping(target = "distance", source = "distance"),
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "imageUrl", source = "imageUrl"),
            @Mapping(target = "isClosed", source = "closed"),
            @Mapping(target = "location.address1", source = "location.address1"),
            @Mapping(target = "location.address2", source = "location.address2"),
            @Mapping(target = "location.address3", source = "location.address3"),
            @Mapping(target = "location.city", source = "location.city"),
            @Mapping(target = "location.country", source = "location.country"),
            @Mapping(target = "location.state", source = "location.state"),
            @Mapping(target = "location.zipCode", source = "location.zipCode"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "phone", source = "phone"),
            @Mapping(target = "price", source = "price"),
            @Mapping(target = "reviewCount", source = "reviewCount"),
            @Mapping(target = "url", source = "url"),
            @Mapping(target = "total", source = "total")
    })
    public abstract BusinessesResponse convertToResponse(Businesses businesses);
}
