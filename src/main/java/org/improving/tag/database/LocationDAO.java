package org.improving.tag.database;

import org.improving.tag.Adversary;
import org.improving.tag.Location;
import org.improving.tag.items.UniqueItems;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
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
            EntityManager em = JPAUtility.getEntityManager();
            List<Location> locs =
                    em.createQuery("SELECT loc FROM org.improving.tag.Location loc").getResultList();

            for (Location loc : locs) {
                if (loc.getAdversaryId() != null) {
                    Adversary adversary = em.find(Adversary.class, loc.getAdversaryId());
                    loc.setAdversary(adversary);
                }

            }

//            List<Location> locations = jdbcTemplate.query("SELECT l.Id as LocId, l.Name as LocName, l.Description, l.AdversaryId, a.Id as AdvId, a.Name as AdvName, a.HitPoints, a.DamageTaken, a.AttackDamage, a.DropItem FROM location l LEFT JOIN adversary a ON l.AdversaryId = a.Id",
//                    (result, rowNum) -> {
//                Location location = new Location();
//                location.setId(result.getInt("LocId"));
//                location.setName(result.getString("LocName"));
//                location.setDescription(result.getString("Description"));
//
//
////                if (result.getString("AdversaryId") != null) {
////
//////                    EntityManager em = JPAUtility.getEntityManager();
//////                    var Adversary = em.find(Adversary.class, Long.parseLong(result.getString("AdversaryId")));
////
////
////                    Integer adversaryId = result.getInt("AdversaryId");
////                    Adversary adversary = new Adversary();
////                    adversary.setName(result.getString("AdvName"));
////                    adversary.setHitPoints(result.getInt("HitPoints"));
////                    adversary.setDamageTaken(result.getInt("DamageTaken"));
////
////
////                    String dropItem = result.getString("DropItem");
////                    location.setAdversary(adversary);
////
////                }
//                return location;
//                    });

            System.out.println(locs);
            return locs;
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
