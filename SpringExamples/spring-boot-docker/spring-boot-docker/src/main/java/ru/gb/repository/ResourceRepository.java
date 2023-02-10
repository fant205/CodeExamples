package ru.gb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.model.ResourceEntity;

public interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {
}
