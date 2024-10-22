package dev.byteasamoah.controller;


import dev.byteasamoah.dto.ProductRequest;
import dev.byteasamoah.entity.Product;
import dev.byteasamoah.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @CrossOrigin(origins = "http://localhost:3000")
//     GET /products?search=term
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(@RequestParam(value = "search", required = false) String search) {
        return ResponseEntity.ok(productService.getProducts(search));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest request) {

//        return ResponseEntity.ok(productService.saveProduct(request));
        return new ResponseEntity<>(productService.saveProduct(request), HttpStatus.CREATED);


    }


}
