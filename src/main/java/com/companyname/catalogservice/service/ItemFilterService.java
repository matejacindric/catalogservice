package com.companyname.catalogservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyname.catalogservice.dao.ItemFilterDAO;
import com.companyname.catalogservice.enums.Category;
import com.companyname.catalogservice.model.Item;

@Service
public class ItemFilterService {
    
    @Autowired
    ItemFilterDAO itemFilterDAO;
    
    public List<Item> searchByName(String keyword) {
        List<Item> itemList = itemFilterDAO.searchByName(keyword);
        return itemList;
    }
    
    public List<Item> searchByCategories(List<Category> categoryList) {
        List<Item> itemList = itemFilterDAO.searchByCategories(categoryList);
        return itemList;
    }
    
    public List<Item> searchByNameAndDescription(String keyword) {
        List<Item> itemList = itemFilterDAO.searchByNameAndDescription(keyword);
        return itemList;
    }

}
