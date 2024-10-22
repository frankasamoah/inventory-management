package dev.byteasamoah.repository;

import dev.byteasamoah.entity.SaleSummary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SaleSummaryRepository extends JpaRepository<SaleSummary, UUID> {
    List<SaleSummary> findTop5ByOrderByDateDesc();
}
