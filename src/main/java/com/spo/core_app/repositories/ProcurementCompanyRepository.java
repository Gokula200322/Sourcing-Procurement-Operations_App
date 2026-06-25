package com.spo.core_app.repositories;

import com.spo.core_app.models.ProcurementCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProcurementCompanyRepository extends JpaRepository<ProcurementCompany, UUID> {
}
