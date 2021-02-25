package pl.coderslab.agentInsurance.repositories;

import org.springframework.stereotype.Repository;
import pl.coderslab.agentInsurance.model.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class VehicleDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveVehicle(Vehicle vehicle) {
        entityManager.persist(vehicle);
    }

    public Vehicle findById(long id) {
        return entityManager.find(Vehicle.class, id);
    }

    public void update(Vehicle vehicle) {
        entityManager.merge(vehicle);
    }

    public void delete(Vehicle vehicle) {
        entityManager.remove(entityManager.contains(vehicle) ?
                vehicle : entityManager.merge(vehicle));
    }

    public List<Vehicle> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM Vehicle b");
        return query.getResultList();
    }

    public List<Vehicle> findByClient(Long id) {
        Query query = entityManager.createQuery("SELECT b FROM Vehicle b where b.client.id =: id");
        query.setParameter("id", id);
        return query.getResultList();
    }
    public List<Vehicle> findByPlate(String plateNumber) {
        Query query = entityManager.createQuery("SELECT b FROM Vehicle b where b.plateNumber =: plateNumber");
        query.setParameter("plateNumber", plateNumber);
        return query.getResultList();
    }
}
