package com.companyname.catalogservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.companyname.catalogservice.enums.Category;
import com.companyname.catalogservice.model.Item;
import com.companyname.catalogservice.service.ItemFilterService;

@RestController
public class ItemFilterController {
    
    @Autowired
    ItemFilterService itemFilterService;
    
    @GetMapping("/searchByName/{keyword}")
    public List<Item> searchByName(@PathVariable String keyword) {
        List<Item> itemList = itemFilterService.searchByName(keyword);
        return itemList;
    }
    
    @GetMapping("/searchByCategories/{categoryList}")
    public List<Item> searchByCategories(List<Category> categoryList) {
        List<Item> itemList = itemFilterService.searchByCategories(categoryList);
        return itemList;
    }
    
    @GetMapping("/searchByNameAndDescription/{keyword}")
    public List<Item> searchByNameAndDescription(@PathVariable String keyword) {
        List<Item> itemList = itemFilterService.searchByNameAndDescription(keyword);
        return itemList;
    }

}
