package com.enamdua.controller;

import com.enamdua.dto.ResultDto;
import com.enamdua.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/location")
public class LocationController {
    public static final String DEFAULT_PAGE_NO = "0";
    public static final String DEFAULT_PAGE_SIZE = "16";

    private final LocationService locationService;

    @GetMapping("/list")
    public ResponseEntity<?> getListLocation(
            @RequestParam(defaultValue = DEFAULT_PAGE_NO) Integer pageNo,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer pageSize) {
        Pageable listPageable = PageRequest.of(pageNo, pageSize);
        return ResponseEntity.ok(ResultDto.res(HttpStatus.OK,
                HttpStatus.OK.toString(),
                locationService.getListLocation(listPageable)));
    }
}
