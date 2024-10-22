package dev.byteasamoah.repository;

import dev.byteasamoah.entity.ExpenseByCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ExpenseByCategoryRepository extends JpaRepository<ExpenseByCategory, UUID> {
    List<ExpenseByCategory> findTop5ByOrderByDateDesc();
}
