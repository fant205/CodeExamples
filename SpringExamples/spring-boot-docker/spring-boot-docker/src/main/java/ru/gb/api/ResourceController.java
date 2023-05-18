package ru.gb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.model.ResourceEntity;
import ru.gb.service.ResourceService;

@RestController
@RequestMapping("/api")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/resource/{id}")
    public ResourceEntity resource(@PathVariable Long id) {
        return resourceService.getResource(id);
    }

    // FIXME: 20.01.2023 Должно быть POST. Использую GET, чтобы показывать из браузера.
    @GetMapping("/resource")
    public ResourceEntity createResource(@RequestParam String value) {
        return resourceService.save(value);
    }

}
