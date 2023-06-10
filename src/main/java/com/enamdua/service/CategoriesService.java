package com.enamdua.service;

import com.enamdua.model.Categories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoriesService {
    Page<Categories> getListCategories(Pageable pageable);
}
