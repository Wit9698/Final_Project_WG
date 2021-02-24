package pl.coderslab.agentInsurance.repositories;

import org.springframework.stereotype.Repository;
import pl.coderslab.agentInsurance.model.Client;
import pl.coderslab.agentInsurance.model.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ClientDao {


    @PersistenceContext
    EntityManager entityManager;

    public void saveClient(Client client) {
        entityManager.persist(client);
    }

    public Client findById(long id) {
        return entityManager.find(Client.class, id);
    }

    public void update(Client client) {
        entityManager.merge(client);
    }

    public void delete(Client client) {
        entityManager.remove(entityManager.contains(client) ?
                client : entityManager.merge(client));
    }

    public List<Vehicle> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM Client b");
        return query.getResultList();
    }

    public List<Vehicle> findByEmail(String email) {
        Query query = entityManager.createQuery("SELECT b FROM Client b where b.email =: ema");
        query.setParameter("ema", email);
        return query.getResultList();
    }

}
