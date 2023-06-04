package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product_detail")
public class ProductDetail {
    @Id
    private Integer id;
    @Column
    private String description;
    @Column
    private String image1;
    @Column
    private String image2;
}
