package com.ypatelcodes.inventory.service.impl;

import com.ypatelcodes.inventory.model.Inventory;
import com.ypatelcodes.inventory.repository.InventoryRepository;
import com.ypatelcodes.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;
    @Override
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory getInventoryById(String id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    @Override
    public Inventory addInventory(Inventory inventory) {
        Optional<Inventory> inventoryRecord = inventoryRepository.findById(inventory.getProductId());
        return inventoryRecord.orElseGet(() -> inventoryRepository.save(inventory));
    }

    @Override
    public Inventory updateInventory(String productId, int quantity) {
        Inventory inventory = inventoryRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product Not Found"));
        inventory.setQuantity(quantity);
        return inventoryRepository.save(inventory);
    }
}
