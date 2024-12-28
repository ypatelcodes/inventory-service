package com.ypatelcodes.inventory.service;

import com.ypatelcodes.inventory.model.Inventory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {
    List<Inventory> getAllInventory();
    Inventory getInventoryById(String id);
    Inventory addInventory(Inventory inventory);
    Inventory updateInventory(String productId, int quantity);
}
