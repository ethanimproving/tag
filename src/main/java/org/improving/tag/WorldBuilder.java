package org.improving.tag;

import org.improving.tag.database.LocationRepository;
import org.improving.tag.domain.Location;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorldBuilder {
    private List<Location> locationList = new ArrayList<>();
    private LocationRepository locationRepository;

    public WorldBuilder(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Transactional
    public Location buildWorld() {
        try {
            // TODO: Modify findAll() to return List<Location>
            List<Location> locations = new ArrayList<>();
            locationRepository.findAll().forEach(locations::add);

            locationList = locations;
            return locationList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception has been caught" + e.getMessage());
            return null;
        }
    }

    public Location getLocationOf(String intendedLocationName) {
        for (Location location : locationList) {
            if (intendedLocationName.equalsIgnoreCase(location.getName())) {
                return location;
            }
        }

        return null;
    }

    public List<Location> getLocationList() {
        return locationList;
    }
}
