package org.improving.tag.database;

import org.improving.tag.Exit;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class ExitDAO {

    private final LocationDAO locationDAO;

    public ExitDAO(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }


    public List<Exit> findExitsByOriginId() {

        try {
            EntityManager em = JPAUtility.getEntityManager();
            List<Exit> exits =
                    em.createQuery("SELECT exit FROM org.improving.tag.Exit exit").getResultList();
            return exits;
        } catch (DataAccessException e) {
            System.out.println("Exception in JDBC: " + e.getMessage());
            return null;
        }

    }
}
