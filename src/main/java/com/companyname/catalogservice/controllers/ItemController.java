package com.companyname.catalogservice.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.companyname.catalogservice.model.Item;
import com.companyname.catalogservice.service.ItemService;

@RestController
public class ItemController {
    
    @Autowired
    private ItemService itemService;
    
    @GetMapping("/items")
    public List<Item> getAllItems() {
        List<Item> itemList = itemService.getAllItems();
        return itemList;
    }
 
    @GetMapping("/item/{id}")
    public Item getItemForId(@PathVariable Integer id) {
        Item item = itemService.getItemForId(id);
        return item;
    }
    
    @PostMapping("/createItem")
    public Item createItem(@Valid Item item) {
        Item itemResponse = itemService.createItem(item);
        return itemResponse;
    }
 
    @PutMapping("/updateItem")
    public Item updateItem(@Valid Item item) {
        Item itemResponce = itemService.updateItem(item);
        return itemResponce;
    }
    
    @DeleteMapping("/deleteItem/{id}")
    public Item deleteItem(@PathVariable int id) {
        Item itemResponce = itemService.deleteItem(id);
        return itemResponce;
    }
}
