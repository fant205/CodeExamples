package example.spring.and.jpa.controller;

import example.spring.and.jpa.model.Personalization;
import example.spring.and.jpa.service.PersonalizationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * целевой адрес будет:
 * https://host:port/SpringAndJPA/jpa/find
 */
@RestController
@RequestMapping(value = "/jpa")
public class PersonalizationController {

    private PersonalizationService personalizationService;

    @GetMapping("/find")
    public Personalization find() {
        return personalizationService.find();
    }

}