package dev.byteasamoah.controller;

import dev.byteasamoah.entity.ExpenseByCategory;
import dev.byteasamoah.service.ExpenseByCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ExpenseByCategoryController {
    private final ExpenseByCategoryService expenseByCategoryService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/expenses")
    public ResponseEntity<List<ExpenseByCategory>> getExpenses() {
        return ResponseEntity.ok(expenseByCategoryService.getExpenseByCategory());
    }
}
