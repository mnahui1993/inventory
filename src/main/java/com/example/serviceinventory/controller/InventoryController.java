package com.example.serviceinventory.controller;

import com.example.serviceinventory.model.Inventory;
import com.example.serviceinventory.model.error.InventoryException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class InventoryController {
    @GetMapping("/stock/{productId}")
    public Mono<Inventory> getStock(@PathVariable(name = "productId") String productId){
        return getAllProduct().filter(product->product.getIdProduct().equals(productId))
                .next()
                .switchIfEmpty(Mono.error(new InventoryException("no se encontro el producto" )));
    }

    private Flux<Inventory> getAllProduct(){
        return Flux.just(buildInventory("1",10),
                buildInventory("2",3),
                buildInventory("3",2),
                buildInventory("4",1),
                buildInventory("5",0),
                buildInventory("6",0));
    }
    private Inventory buildInventory(String productId,Integer stock){
        return Inventory.builder()
                .idProduct(productId)
                .stock(stock)
                .build();
    }
}
