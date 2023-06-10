package com.enamdua.service.impl;

import com.enamdua.model.Location;
import com.enamdua.repository.LocationRepository;
import com.enamdua.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    @Override
    public Page<Location> getListLocation(Pageable pageable) {
        Page<Location> locations = locationRepository.findAll(pageable);
        return locations;
    }
}
