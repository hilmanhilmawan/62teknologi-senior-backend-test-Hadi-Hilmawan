package com.enamdua.service;

import com.enamdua.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LocationService {
    Page<Location> getListLocation(Pageable pageable);
}
