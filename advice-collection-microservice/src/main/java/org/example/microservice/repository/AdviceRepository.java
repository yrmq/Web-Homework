package org.example.microservice.repository;

import org.example.microservice.entity.AdviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdviceRepository extends JpaRepository<AdviceEntity, Long> {
}
