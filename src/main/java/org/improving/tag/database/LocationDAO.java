package org.improving.tag.database;

import org.improving.tag.Adversary;
import org.improving.tag.Location;
import org.improving.tag.items.UniqueItems;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Component
public class LocationDAO {

    private final JdbcTemplate jdbcTemplate;

    public LocationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Location> findAll() {
        try {
            List<Location> locations = jdbcTemplate.query("select * from location as l left join adversary as a on l.AdversaryId = a.Id",
                    (result, rowNum) -> {
                Location location = new Location();
                location.setId(result.getInt("Id"));
                location.setName(result.getString("Name"));
                location.setDescription(result.getString("Description"));
                Integer adversaryId = result.getInt("AdversaryId");
                if (adversaryId != null) {
                    Adversary adversary = new Adversary();
                    adversary.setName(result.getString("Name"));
                    adversary.setHitPoints(result.getInt("HitPoints"));
                    adversary.setDamageTaken(result.getInt("DamageTaken"));
                    String dropItem = result.getString("DropItem");
                    if (null != dropItem) {
                        adversary.setItem(Arrays
                                .stream(UniqueItems.values())
                                        .filter(item -> item.getName().equals(dropItem))
                        .findFirst()
                        .orElse(null));
                        location.setAdversary(adversary);
                    }

                }
                return location;
                    });
            return locations;
        } catch (DataAccessException e) {
            System.out.println("Exception in JDBC: " + e.getMessage());
            return null;
        }
    }

    private Location transformLocation(ResultSet result, int rowNum) throws SQLException {
        Location location = new Location();
        location.setId(result.getInt("Id"));
        location.setName(result.getString("Name"));
        location.setDescription(result.getString("Description"));
        Integer adversaryId = result.getInt("AdversaryId");
        if (adversaryId != null) {
            Adversary adversary = new Adversary();
            adversary.setName(result.getString("Name"));
            adversary.setHitPoints(result.getInt("HitPoints"));
            adversary.setDamageTaken(result.getInt("DamageTaken"));
            String dropItem = result.getString("DropItem");
            if (null != dropItem) {
                adversary.setItem(Arrays
                        .stream(UniqueItems.values())
                        .filter(item -> item.getName().equals(dropItem))
                        .findFirst()
                        .orElse(null));
            }

        }
        return location;
    }
}