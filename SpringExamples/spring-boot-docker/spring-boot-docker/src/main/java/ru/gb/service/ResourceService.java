package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.gb.model.ResourceEntity;
import ru.gb.repository.ResourceRepository;

@Service
public class ResourceService {

    private final ResourceRepository repository;

    public ResourceService(ResourceRepository repository) {
        this.repository = repository;
    }

    public ResourceEntity getResource(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public ResourceEntity save(String value) {
        ResourceEntity entity = new ResourceEntity();
        entity.setValue(value);
        return repository.save(entity);
    }

}
