package dev.byteasamoah.controller;


import dev.byteasamoah.service.DashboardMetricsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class DashboardMetricsController {
    private final DashboardMetricsService dashboardMetricsService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/dashboard")
    public ResponseEntity<Map<String, Object>> getDashboardMetrics() {
        try {
            Map<String, Object> metrics = dashboardMetricsService.getDashboardMetrics();
            return ResponseEntity.ok(metrics);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }


    }
}
