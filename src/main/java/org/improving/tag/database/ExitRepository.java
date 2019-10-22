package org.improving.tag.database;

import org.improving.tag.domain.Exit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExitRepository extends CrudRepository<Exit, Long> {

    List<Exit> findExitsByOriginId(int id);
    List<Exit> findByOriginId(int id);
}
