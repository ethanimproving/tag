package org.improving.tag.database;

import org.improving.tag.domain.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {
    List<Location> findAll();
}
