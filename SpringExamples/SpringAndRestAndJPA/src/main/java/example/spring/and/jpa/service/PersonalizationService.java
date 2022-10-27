package example.spring.and.jpa.service;

import example.spring.and.jpa.dao.PersonalizationRepository;
import example.spring.and.jpa.model.Personalization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalizationService {

    @Autowired
    private PersonalizationRepository personalizationRepository;

       public Personalization find() {
        return personalizationRepository.findAll().get(0);
    }

}