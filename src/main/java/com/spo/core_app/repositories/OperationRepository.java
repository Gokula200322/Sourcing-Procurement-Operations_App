package com.spo.core_app.repositories;

import com.spo.core_app.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OperationRepository extends JpaRepository<Operation, UUID> {

    public Optional<Operation> findByOperationName(String operationName);
}
