package example.spring.and.jpa.dao;

import example.spring.and.jpa.model.Personalization;

import javax.transaction.Transactional;
import java.util.List;

public interface PersonalizationRepository {
    @Transactional
    List<Personalization> findAll();
}
