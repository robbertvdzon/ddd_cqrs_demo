package com.vdzon.ordersystem;

import com.vdzon.ordersystem.restrepositories.OrderRegelRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

public class rest {
    @RestController
    public static class OrderregelCountResource {
        @Autowired
        OrderRegelRestRepository repository;

        @GetMapping("productordercount/{productId}")
        public int getCount(@PathVariable long productId){
            return repository.findByProductId(productId).size();
        }
    }
}
