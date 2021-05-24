package com.companyname.catalogservice.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.companyname.catalogservice.enums.Category;
import com.companyname.catalogservice.model.Item;

@Repository
public class ItemFilterDAO {
    
    @Autowired
    ItemDAO itemDao;
    
    public List<Item> searchByName(String keyword) {
        List<Item> itemList = new ArrayList<Item>();
        for (Item item : itemDao.getAllItems()) {
            if (item.getName() != null) {
                Boolean found = Arrays.asList(item.getName().toLowerCase().split(" ")).containsAll(Arrays.asList(keyword.toLowerCase().split(" ")));
                if(found){
                    itemList.add(item);
                }
            }
        }
        return itemList;
    }
    
    public List<Item> searchByCategories(List<Category> categoryList) {
        List<Item> itemList = new ArrayList<Item>();
        for (Item item : itemDao.getAllItems()) {
            for (Category category : item.getCategories()) {
                if (categoryList.contains(category) && !itemList.contains(item)) {
                    itemList.add(item);
                }
            }
        }
        return itemList;
    }
    
    public List<Item> searchByNameAndDescription(String keyword) {
        List<Item> itemList = new ArrayList<Item>();
        for (Item item : itemDao.getAllItems()) {
            if ((item.getName() != null && item.getName().toLowerCase().contains(keyword.toLowerCase())) 
                    || (item.getDescription() != null && item.getDescription().toLowerCase().contains(keyword.toLowerCase()))) {
                itemList.add(item);
            }
        }
        return itemList;
    }

}
