package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

@Data
@Entity
public class Product
{
                @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
                @Column
    private String name;
                @Column
    private String image;
                @Column
    private long price;
    @Column
    private Integer category_id;
                @OneToOne
                        (cascade = CascadeType.ALL,optional = false)
                @JoinColumn(name = "detail_id", referencedColumnName = "id")
    ProductDetail productDetail;
                @OneToOne(mappedBy = "productDetail",fetch = FetchType.LAZY)
    private Product product;


}
