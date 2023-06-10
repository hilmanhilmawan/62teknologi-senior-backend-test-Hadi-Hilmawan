package com.enamdua.service;

import com.enamdua.request.BusinessesRequest;
import com.enamdua.response.BusinessesResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BusinessesService {
    Page<BusinessesResponse> getListBusinesses(Pageable pageable);
    Page<BusinessesResponse> getListBusinesses(String categoriesReftId, String locationReftId, String price,
                                               String latitude, String longitude, Pageable pageable);
    String createBusinesses(BusinessesRequest createRequest) throws Exception;
    String editBusinesses(BusinessesRequest createRequest) throws Exception;
    void deleteBusinesses(String id) throws Exception;
}
