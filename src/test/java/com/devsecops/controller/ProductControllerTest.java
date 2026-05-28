package com.devsecops.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductControllerTest {

    @Test
    void testProducts() {

        ProductController controller = new ProductController();

        String result = controller.products();

        assertEquals("Product API Working", result);
    }
}
