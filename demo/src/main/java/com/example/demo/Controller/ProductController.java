package com.example.demo.Controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDetail;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductDetailRepository;
import com.example.demo.repository.ProductRepository;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductDetailRepository productDetailRepository;
    @ResponseBody
    @GetMapping
    public List<Product> index()
    {
        List<Product> listProduct = productRepository.findAll();
        for (Product i : listProduct)
        {
            ProductDetail detail = productDetailRepository.findById(i.getId()).orElse(null);
            if (detail != null)
                i.setProductDetail(detail);
                Category category = categoryRepository.findById(i.getCategory_id()).orElse(null);
                if (category!= null)
                    i.setCategory_id(i.getCategory_id());
            };
        return listProduct;
        }
    }

