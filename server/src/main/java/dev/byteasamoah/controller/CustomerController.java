package dev.byteasamoah.controller;


import dev.byteasamoah.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/customers")
    public ResponseEntity<Map<String, Object>> getCustomers() {
        return ResponseEntity.ok(customerService.fetchCustomers());
    }
}
