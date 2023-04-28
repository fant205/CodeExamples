package sapportal.example.rest.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sapportal.example.rest.model.Guitar;

/**
 * На SAP Portal целевой адрес будет:
 *  https://host:port/SimpleRestWithSpring/rest/find
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/rest")
public class RestController {

    @GetMapping("/find")
    public Guitar find() {
        Guitar guitar = new Guitar();
        guitar.setName("Explorer");
        guitar.setStringsCount(6);
        return guitar;
    }
}
