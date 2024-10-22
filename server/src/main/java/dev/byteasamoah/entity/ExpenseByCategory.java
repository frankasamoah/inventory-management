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
@Table(name = "expense_by_category")
public class ExpenseByCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "expense_by_category_id", nullable = false, unique = true)
    private String expenseByCategoryId;

    @Column(name = "expense_summary_id")
    private String expenseSummaryId;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "amount", nullable = false)
    private Double amount;


}
