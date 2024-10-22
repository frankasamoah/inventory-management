package dev.byteasamoah.service;



import dev.byteasamoah.dto.ProductRequest;
import dev.byteasamoah.entity.Product;
import dev.byteasamoah.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProducts(String search) {
        if (search != null && !search.isEmpty()) {
            return productRepository.findByNameContainingIgnoreCase(search);
        } else {
            return productRepository.findAll();
        }
    }

    public Product saveProduct(ProductRequest request) {
        var product = Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .rating(request.getRating())
                .stockQuantity(request.getStockQuantity())
                .build();
        return productRepository.save(product);
    }
}
