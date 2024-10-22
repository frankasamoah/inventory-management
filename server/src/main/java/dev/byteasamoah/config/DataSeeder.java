package dev.byteasamoah.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dev.byteasamoah.entity.*;
import dev.byteasamoah.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.InputStream;
import java.util.List;


@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final SaleRepository saleRepository;
    private final PurchaseRepository purchaseRepository;
    private final ExpenseSummaryRepository expenseSummaryRepository;
    private final SaleSummaryRepository saleSummaryRepository;
    private final PurchaseSummaryRepository purchaseSummaryRepository;
    private final ExpenseByCategoryRepository expenseByCategoryRepository;
    private final ExpenseRepository expenseRepository;




    private final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())   // Register the module to handle LocalDateTime
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)   //Disable timestamp format
            ;


    @Override
    public void run(String... args) {
        if (customerRepository.count() == 0) seedCustomers();
        if (productRepository.count() == 0) seedProducts();
        if (expenseSummaryRepository.count() == 0) seedExpenseSummary();
        if (purchaseSummaryRepository.count() == 0) seedPurchaseSummary();
        if (saleSummaryRepository.count() == 0) seedSaleSummary();
        if (expenseRepository.count() == 0) seedExpenses();
        if (expenseByCategoryRepository.count() == 0) seedExpenseByCategory();
        if (purchaseRepository.count() == 0) seedPurchases();
        if (saleRepository.count() == 0) seedSales();
    }

    private void seedProducts() {
        try {
            InputStream inputStream = new ClassPathResource("product.json").getInputStream();
            List<Product> products = mapper.readValue(inputStream, new TypeReference<>() {
            });
            productRepository.saveAll(products);
            System.out.println("Products seeded successfully");
        } catch(Exception e) {
            System.err.println("Unable to seed products: " + e.getMessage());
        }
    }

    private void seedExpenseSummary() {
        try {
         InputStream inputStream = new ClassPathResource("expense-summary.json").getInputStream();
            List<ExpenseSummary> expenseSummaries = mapper.readValue(inputStream, new TypeReference<>() {
            });
            expenseSummaryRepository.saveAll(expenseSummaries);
            System.out.println("Expense summaries seeded successfully");
        } catch(Exception e) {
            System.err.println("Unable to seed expense summary: " + e.getMessage());
        }
    }

    private void seedExpenses() {
        try {
            InputStream inputStream = new ClassPathResource("expense.json").getInputStream();
            List<Expense> expenses = mapper.readValue(inputStream, new TypeReference<>() {
            });
            expenseRepository.saveAll(expenses);
            System.out.println("Expenses seeded successfully");
        } catch(Exception e) {
            System.err.println("Unable to seed expenses: " + e.getMessage());
        }
    }

    private void seedSales() {
        try {
            InputStream inputStream = new ClassPathResource("sale.json").getInputStream();
            List<Sale> sales = mapper.readValue(inputStream, new TypeReference<>() {
            });


            saleRepository.saveAll(sales);
            System.out.println("Sales seeded successfully");
        } catch(Exception e) {
            System.err.println("Unable to seed sales: " + e.getMessage());
        }
    }

    private void seedSaleSummary() {
        try {
            InputStream inputStream = new ClassPathResource("sale-summary.json").getInputStream();
            List<SaleSummary> saleSummaries = mapper.readValue(inputStream, new TypeReference<>() {
            });
            saleSummaryRepository.saveAll(saleSummaries);
            System.out.println("Sale summaries seeded successfully");
        } catch(Exception e) {
            System.err.println("Unable to seed sale summary: " + e.getMessage());
        }
    }

    private void seedExpenseByCategory() {
        try {
            InputStream inputStream = new ClassPathResource("expense-by-category.json").getInputStream();
            List<ExpenseByCategory> expenseByCategories = mapper.readValue(inputStream, new TypeReference<>() {
            });


            expenseByCategoryRepository.saveAll(expenseByCategories);
            System.out.println("Expense by categories seeded successfully");
        } catch(Exception e) {
            System.err.println("Unable to seed expense by category: " + e.getMessage());
        }
    }

    private void seedPurchaseSummary() {
        try {
            InputStream inputStream = new ClassPathResource("purchase-summary.json").getInputStream();
            List<PurchaseSummary> purchaseSummaries = mapper.readValue(inputStream, new TypeReference<>() {
            });
            purchaseSummaryRepository.saveAll(purchaseSummaries);
            System.out.println("Purchase summaries seeded successfully");
        } catch(Exception e) {
            System.err.println("Unable to seed purchase summary: " + e.getMessage());
        }
    }

    private void seedPurchases() {
        try {
            InputStream inputStream = new ClassPathResource("purchase.json").getInputStream();
            List<Purchase> purchases = mapper.readValue(inputStream, new TypeReference<>() {
            });

            purchaseRepository.saveAll(purchases);
            System.out.println("Purchases seeded successfully");
        } catch(Exception e) {
            System.err.println("Unable to seed purchases: " + e.getMessage());
        }
    }

    private void seedCustomers() {
        try {
            InputStream inputStream = new ClassPathResource("customer.json").getInputStream();
            List<Customer> customers = mapper.readValue(inputStream, new TypeReference<>() {
            });
            customerRepository.saveAll(customers);
            System.out.println("Customers seeded successfully");
        } catch(Exception e) {
            System.err.println("Unable to seed customers: " + e.getMessage());
        }
    }

}
