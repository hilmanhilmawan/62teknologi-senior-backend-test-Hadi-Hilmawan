package com.enamdua.controller;

import com.enamdua.dto.ResultDto;
import com.enamdua.request.BusinessesRequest;
import com.enamdua.response.BusinessesResponse;
import com.enamdua.service.BusinessesService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

@RestController
@AllArgsConstructor
@RequestMapping("/businesses")
public class BusinessesController {
    public static final String DEFAULT_PAGE_NO = "0";
    public static final String DEFAULT_PAGE_SIZE = "16";

    private final BusinessesService businessesService;

    @GetMapping("/list")
    public ResponseEntity<?> getListBusinesses(
            @RequestParam String categoriesReftId,
            @RequestParam String locationReftId,
            @RequestParam String price,
            @RequestParam String latitude,
            @RequestParam String longitude,
            @RequestParam(defaultValue = DEFAULT_PAGE_NO) Integer pageNo,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer pageSize) {
        Pageable listPageable = PageRequest.of(pageNo, pageSize);
        Page<BusinessesResponse> businessesPage;
        if (StringUtils.isEmpty(categoriesReftId) && StringUtils.isEmpty(locationReftId) && StringUtils.isEmpty(price)
                && StringUtils.isEmpty(latitude) && StringUtils.isEmpty(longitude)) {
            businessesPage = businessesService.getListBusinesses(listPageable);
        } else {
            businessesPage = businessesService.getListBusinesses(categoriesReftId, locationReftId, price,
                    latitude, longitude, listPageable);
        }
        return ResponseEntity.ok(businessesPage);
    }

    @PostMapping("/create")
    public ResponseEntity<ResultDto<String>> createBusinesses(@RequestBody BusinessesRequest createRequest) throws Exception {
        return ResponseEntity.ok(ResultDto.res(HttpStatus.OK,
                HttpStatus.OK.toString(),
                businessesService.createBusinesses(createRequest)));
    }

    @PutMapping("/edit")
    public ResponseEntity<ResultDto<String>> editBusinesses(@RequestBody BusinessesRequest createRequest) throws Exception {
        return ResponseEntity.ok(ResultDto.res(HttpStatus.OK,
                HttpStatus.OK.toString(),
                businessesService.editBusinesses(createRequest)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResultDto<String>> deleteBusinessesById(@PathVariable String id) throws Exception {
        businessesService.deleteBusinesses(id);
        return ResponseEntity.ok(ResultDto.res(HttpStatus.OK,
                HttpStatus.OK.toString(),
                "Delete berhasil"));
    }
}
