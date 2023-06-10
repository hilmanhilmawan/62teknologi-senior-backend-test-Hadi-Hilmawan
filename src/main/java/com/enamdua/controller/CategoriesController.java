package com.enamdua.controller;

import com.enamdua.dto.ResultDto;
import com.enamdua.service.CategoriesService;
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
@RequestMapping("/categories")
public class CategoriesController {
    public static final String DEFAULT_PAGE_NO = "0";
    public static final String DEFAULT_PAGE_SIZE = "16";

    private final CategoriesService categoriesService;

    @GetMapping("/list")
    public ResponseEntity<?> getListCategories(
            @RequestParam(defaultValue = DEFAULT_PAGE_NO) Integer pageNo,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer pageSize) {
        Pageable listPageable = PageRequest.of(pageNo, pageSize);
        return ResponseEntity.ok(ResultDto.res(HttpStatus.OK,
                HttpStatus.OK.toString(),
                categoriesService.getListCategories(listPageable)));
    }
}
