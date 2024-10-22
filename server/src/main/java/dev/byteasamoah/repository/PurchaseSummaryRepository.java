package dev.byteasamoah.repository;

import dev.byteasamoah.entity.PurchaseSummary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PurchaseSummaryRepository extends JpaRepository<PurchaseSummary, UUID> {
    List<PurchaseSummary> findTop5ByOrderByDateDesc();
}
