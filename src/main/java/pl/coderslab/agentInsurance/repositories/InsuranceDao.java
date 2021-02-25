package pl.coderslab.agentInsurance.repositories;

import org.springframework.stereotype.Repository;
import pl.coderslab.agentInsurance.model.Insurance;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class InsuranceDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveInsurance(Insurance insurance) {
        entityManager.persist(insurance);
    }

    public Insurance findById(long id) {
        return entityManager.find(Insurance.class, id);
    }

    public void update(Insurance insurance) {
        entityManager.merge(insurance);
    }

    public void delete(Insurance insurance) {
        entityManager.remove(entityManager.contains(insurance) ?
                insurance : entityManager.merge(insurance));
    }

    public List<Insurance> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM Insurance b");
        return query.getResultList();
    }

    public List<Insurance> findByVehicle(Long id) {
        Query query = entityManager.createQuery("SELECT b FROM Insurance b where b.vehicle.id =: id");
        query.setParameter("id", id);
        return query.getResultList();
    }
    public List<Insurance> findByNumber(String insuranceNumber) {
        Query query = entityManager.createQuery("SELECT b FROM Insurance b where b.insuranceNumber =: insuranceNumber");
        query.setParameter("insuranceNumber", insuranceNumber);
        return query.getResultList();
    }
}
