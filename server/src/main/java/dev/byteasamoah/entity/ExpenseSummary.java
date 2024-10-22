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
@Table(name = "expense_summary")
public class ExpenseSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "expense_summary_id", nullable = false, unique = true)
    private String expenseSummaryId;
    @Column(name = "total_expenses", nullable = false)
    private Integer totalExpenses;
    @Column(name = "date", nullable = false)
    private LocalDateTime date;

}
