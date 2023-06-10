package com.enamdua.service.impl;

import com.enamdua.mapper.BusinessesMapper;
import com.enamdua.model.Businesses;
import com.enamdua.model.Categories;
import com.enamdua.model.Location;
import com.enamdua.repository.BusinessesRepository;
import com.enamdua.repository.CategoriesRepository;
import com.enamdua.repository.LocationRepository;
import com.enamdua.request.BusinessesRequest;
import com.enamdua.response.BusinessesResponse;
import com.enamdua.service.BusinessesService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BusinessesServiceImpl implements BusinessesService {
    private final BusinessesRepository businessesRepository;
    private final CategoriesRepository categoriesRepository;
    private final LocationRepository locationRepository;
    private final BusinessesMapper businessesMapper;
    private String getLikeString(String keyword) {
        return "%" + keyword + "%";
    }

    @Override
    public Page<BusinessesResponse> getListBusinesses(Pageable pageable) {
        Page<Businesses> businesses = businessesRepository.findAll(pageable);
        return businesses.map(businessesMapper::convertToResponse);
    }

    @Override
    public Page<BusinessesResponse> getListBusinesses(String categoriesReftId, String locationReftId, String price,
                                                      String latitude, String longitude, Pageable pageable) {
        Page<Businesses> businesses = businessesRepository.findByCategoriesReftIdIgnoreCaseLikeAndLocationReftIdIgnoreCaseLikeAndPriceIgnoreCaseLikeAndLatitudeIgnoreCaseLikeAndLongitudeIgnoreCaseLike(
                getLikeString(categoriesReftId), getLikeString(locationReftId), getLikeString(price), getLikeString(latitude),
                getLikeString(longitude), pageable);
        return businesses.map(businessesMapper::convertToResponse);
    }

    @Override
    public String createBusinesses(BusinessesRequest createRequest) throws Exception {
        Optional<Categories> categories = categoriesRepository.findByReftId(createRequest.getCategoriesReftId());
        if (!categories.isPresent()) {
            throw new FileNotFoundException("Data tidak ditemukan");
        }
        Optional<Location> location = locationRepository.findByReftId(createRequest.getLocationReftId());
        if (!location.isPresent()) {
            throw new FileNotFoundException("Data tidak ditemukan");
        }
        Businesses businesses = new Businesses();
        businesses.setAlias(createRequest.getName());
        businesses.setName(createRequest.getName());
        businesses.setImageUrl(createRequest.getImageUrl());
        businesses.setUrl(createRequest.getUrl());
        businesses.setCategories(categories.get());
        businesses.setLatitude(createRequest.getLatitude());
        businesses.setLongitude(createRequest.getLongitude());
        businesses.setPrice(createRequest.getPrice());
        businesses.setLocation(location.get());
        businesses.setPhone(createRequest.getPhone());
        businesses.setPhone(createRequest.getPhone());
        businesses.setDisplayPhone(createRequest.getDisplayPhone());
        businesses.setIsOpenNow(createRequest.getIsOpenNow());
        businesses.setOpenAt(createRequest.getOpenAt());
        businesses.setTotal(createRequest.getTotal());
        businesses.setClosed(true);
        try {
            businesses = businessesRepository.save(businesses);
        } catch (Exception e) {
            throw new RuntimeException("Gagal menyimpan");
        }
        return businesses.getId();
    }

    @Override
    public String editBusinesses(BusinessesRequest createRequest) throws Exception {
        Optional<Businesses> businessesOptional = businessesRepository.findById(createRequest.getId());
        if (!businessesOptional.isPresent()) {
            throw new Exception("Data tidak ditemukan");
        }
        Optional<Categories> categories = categoriesRepository.findByReftId(createRequest.getCategoriesReftId());
        System.out.println("Categoris " + categories);
        if (!categories.isPresent()) {
            throw new Exception("Data tidak ditemukan");
        }
        Optional<Location> location = locationRepository.findByReftId(createRequest.getLocationReftId());
        if (!location.isPresent()) {
            throw new Exception("Data tidak ditemukan");
        }

        Businesses businesses = businessesOptional.get();
        businesses.setAlias(createRequest.getName());
        businesses.setName(createRequest.getName());
        businesses.setImageUrl(createRequest.getImageUrl());
        businesses.setUrl(createRequest.getUrl());
        businesses.setCategories(categories.get());
        businesses.setLatitude(createRequest.getLatitude());
        businesses.setLongitude(createRequest.getLongitude());
        businesses.setPrice(createRequest.getPrice());
        businesses.setLocation(location.get());
        businesses.setPhone(createRequest.getPhone());
        businesses.setPhone(createRequest.getPhone());
        businesses.setDisplayPhone(createRequest.getDisplayPhone());
        businesses.setIsOpenNow(createRequest.getIsOpenNow());
        businesses.setOpenAt(createRequest.getOpenAt());
        businesses.setTotal(createRequest.getTotal());
        try {
            businesses = businessesRepository.save(businesses);
        } catch (Exception e) {
            throw new RuntimeException("Gagal menyimpan");
        }
        return businesses.getId();
    }

    @Override
    public void deleteBusinesses(String id) throws Exception {
        Optional<Businesses> businessesOptional = businessesRepository.findById(id);
        if (!businessesOptional.isPresent()) {
            throw new FileNotFoundException("ID tidak ditemukan");
        }
        try {
            businessesRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Gagal delete data");
        }
    }
}
