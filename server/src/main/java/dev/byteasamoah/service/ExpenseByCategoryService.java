package dev.byteasamoah.service;

import dev.byteasamoah.entity.ExpenseByCategory;
import dev.byteasamoah.repository.ExpenseByCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseByCategoryService {
    private final ExpenseByCategoryRepository expenseByCategoryRepository;
    public List<ExpenseByCategory> getExpenseByCategory() {
        return expenseByCategoryRepository.findAll();
    }
}
