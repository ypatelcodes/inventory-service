package com.ypatelcodes.inventory.controller;

import com.ypatelcodes.inventory.model.Inventory;
import com.ypatelcodes.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @GetMapping
    public List<Inventory> getAllInventories(){
        return inventoryService.getAllInventory();
    }

    @GetMapping("/{id}")
    public Inventory getInventoryById(@PathVariable String id){
        return inventoryService.getInventoryById(id);
    }

    @PutMapping("/{productId}")
    public Inventory updateInventory(@PathVariable String productId , @RequestParam int quantity ){
        return inventoryService.updateInventory(productId,quantity);
    }

    @PostMapping
    public Inventory addInventory(@RequestBody Inventory inventory ){
        return inventoryService.addInventory(inventory);
    }

}
