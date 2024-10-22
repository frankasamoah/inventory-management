package dev.byteasamoah.repository;

import dev.byteasamoah.entity.ExpenseSummary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ExpenseSummaryRepository extends JpaRepository<ExpenseSummary, UUID> {
    List<ExpenseSummary> findTop5ByOrderByDateDesc();
}
