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
@Table(name = "sale_summary")
public class SaleSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "sale_summary_id", nullable = false, unique = true)
    private String saleSummaryId;
    @Column(name = "total_value")
    private Double totalValue;
    @Column(name = "change_percentage")
    private Double changePercentage;
    private LocalDateTime date;
}
