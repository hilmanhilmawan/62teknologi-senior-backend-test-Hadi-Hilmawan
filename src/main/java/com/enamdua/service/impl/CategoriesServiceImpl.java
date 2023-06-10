package com.enamdua.service.impl;

import com.enamdua.model.Categories;
import com.enamdua.repository.CategoriesRepository;
import com.enamdua.service.CategoriesService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoriesServiceImpl implements CategoriesService {
    private final CategoriesRepository categoriesRepository;

    @Override
    public Page<Categories> getListCategories(Pageable pageable) {
        Page<Categories> categories = categoriesRepository.findAll(pageable);
        return categories;
    }
}
