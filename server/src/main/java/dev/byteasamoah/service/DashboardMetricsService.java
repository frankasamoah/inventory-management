package dev.byteasamoah.service;


import dev.byteasamoah.entity.*;
import dev.byteasamoah.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DashboardMetricsService {
    private final ProductRepository productRepository;
    private final SaleSummaryRepository saleSummaryRepository;
    private final PurchaseSummaryRepository purchaseSummaryRepository;
    private final ExpenseSummaryRepository expenseSummaryRepository;
    private final ExpenseByCategoryRepository expenseByCategoryRepository;

    public Map<String, Object> getDashboardMetrics() {
        Map<String, Object> dashboardMetrics = new HashMap<>();
        List<Product> products = productRepository.findTop15ByOrderByStockQuantityDesc();
        List<SaleSummary> salesSummaries = saleSummaryRepository.findTop5ByOrderByDateDesc();
        List<PurchaseSummary> purchaseSummaries = purchaseSummaryRepository.findTop5ByOrderByDateDesc();
        List<ExpenseSummary> expenseSummaries = expenseSummaryRepository.findTop5ByOrderByDateDesc();
        List<ExpenseByCategory> expenseByCategory = expenseByCategoryRepository.findTop5ByOrderByDateDesc();

        dashboardMetrics.put("popularProducts", products);
        dashboardMetrics.put("salesSummary", salesSummaries);
        dashboardMetrics.put("purchaseSummary", purchaseSummaries);
        dashboardMetrics.put("expenseSummary", expenseSummaries);
        dashboardMetrics.put("expenseByCategory", expenseByCategory);

        return dashboardMetrics;
    }
}
