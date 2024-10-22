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
@Table(name = "purchase_summary")
public class PurchaseSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "purchase_summary_id", nullable = false, unique = true)
    private String purchaseSummaryId;
    @Column(name = "total_purchased")
    private Double totalPurchased;
    @Column(name = "change_percentage")
    private Double changePercentage;
    private LocalDateTime date;
}
