package pl.coderslab.agentInsurance.repositories;

import org.springframework.stereotype.Repository;
import pl.coderslab.agentInsurance.model.Brand;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BrandDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Brand brand) {
        entityManager.persist(brand);
    }

    public Brand findById(long id) {
        return entityManager.find(Brand.class, id);
    }

    public void update(Brand brand) {
        entityManager.merge(brand);
    }

    public void delete(Brand brand) {
        entityManager.remove(entityManager.contains(brand) ?
                brand : entityManager.merge(brand));
    }

    public List<Brand> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM Brand b");
        return query.getResultList();
    }

    public List<Brand> findByI(long id) {
        Query query = entityManager.createQuery("SELECT b FROM Brand b where b.id =: id");
        query.setParameter("id", id);
        return query.getResultList();
    }
}
