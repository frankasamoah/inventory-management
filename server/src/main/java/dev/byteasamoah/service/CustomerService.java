package dev.byteasamoah.service;


import dev.byteasamoah.entity.Customer;
import dev.byteasamoah.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    public Map<String, Object> fetchCustomers() {
        Map<String, Object> result = new HashMap<>();
        List<Customer> customers = customerRepository.findAll();
        result.put("customers", customers);
        return result;
    }
}
