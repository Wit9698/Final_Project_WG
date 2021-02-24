package pl.coderslab.agentInsurance.repositories;

import org.springframework.stereotype.Repository;
import pl.coderslab.agentInsurance.model.VehicleModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class VehicleModelDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(VehicleModel vehicleModel) {
        entityManager.persist(vehicleModel);
    }

    public VehicleModel findById(long id) {
        return entityManager.find(VehicleModel.class, id);
    }

    public void update(VehicleModel vehicleModel) {
        entityManager.merge(vehicleModel);
    }

    public void delete(VehicleModel vehicleModel) {
        entityManager.remove(entityManager.contains(vehicleModel) ?
                vehicleModel : entityManager.merge(vehicleModel));
    }

    public List<VehicleModel> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM VehicleModel b");
        return query.getResultList();
    }

    public List<VehicleModel> findByBrandId(Long id) {
        Query query = entityManager.createQuery("SELECT b FROM VehicleModel b where b.brand.id =: id");
        query.setParameter("id", id);
        return query.getResultList();
    }

}
