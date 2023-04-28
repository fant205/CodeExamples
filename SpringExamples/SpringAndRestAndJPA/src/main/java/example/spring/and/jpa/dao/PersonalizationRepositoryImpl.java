package example.spring.and.jpa.dao;

import example.spring.and.jpa.model.Personalization;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonalizationRepositoryImpl implements PersonalizationRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public List<Personalization> findAll() {
        return em.createQuery("select p from Personalization p").getResultList();
    }
}
