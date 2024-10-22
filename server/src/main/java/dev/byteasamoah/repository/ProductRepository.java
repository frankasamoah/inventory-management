package dev.byteasamoah.repository;

import dev.byteasamoah.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findTop15ByOrderByStockQuantityDesc();

    List<Product> findByNameContainingIgnoreCase(String name);
}
