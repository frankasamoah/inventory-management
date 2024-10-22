package dev.byteasamoah.repository;

import dev.byteasamoah.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface PurchaseRepository extends JpaRepository<Purchase, UUID> {
}
