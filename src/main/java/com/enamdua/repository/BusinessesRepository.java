package com.enamdua.repository;

import com.enamdua.model.Businesses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface BusinessesRepository extends JpaRepository<Businesses, String>, PagingAndSortingRepository<Businesses, String> {
    Page<Businesses> findByCategoriesReftIdIgnoreCaseLikeAndLocationReftIdIgnoreCaseLikeAndPriceIgnoreCaseLikeAndLatitudeIgnoreCaseLikeAndLongitudeIgnoreCaseLike(String categoriesReftId, String locationReftId, String price, String latitude, String longitude, Pageable pageable);
    Optional<Businesses> findById(String id);
}
