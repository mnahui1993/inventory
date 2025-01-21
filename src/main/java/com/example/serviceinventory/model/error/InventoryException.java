package com.example.serviceinventory.model.error;

public class InventoryException extends  RuntimeException{
    public InventoryException(String message) {
        super(message);
    }
}
