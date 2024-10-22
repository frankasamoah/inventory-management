package dev.byteasamoah.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "purchase_id", nullable = false, unique = true)
    private String purchaseId;
    @Column(name = "product_id", nullable=false)
    private String productId;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name = "unit_cost", nullable = false)
    private Double unitCost;
    @Column(name = "total_cost", nullable = false)
    private Double totalCost;



}
