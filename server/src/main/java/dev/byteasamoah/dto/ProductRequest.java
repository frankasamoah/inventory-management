package dev.byteasamoah.dto;


import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {

    private String name;
    private Double price;
    private Double rating;
    private Integer stockQuantity;
}
