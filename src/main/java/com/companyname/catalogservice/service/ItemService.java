package com.companyname.catalogservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyname.catalogservice.dao.ItemDAO;
import com.companyname.catalogservice.model.Item;

@Service
public class ItemService {
    
    @Autowired
    private ItemDAO itemDao;
 
    public List<Item> getAllItems() {
        List<Item> itemList = itemDao.getAllItems();
        return itemList;
    }
 
    public Item getItemForId(int id) {
        Item item = itemDao.getItemForId(id);
        return item;
    }
 
    public Item createItem(Item item) {
        Item itemResponse = itemDao.createItem(item);
        return itemResponse;
    }
 
    public Item updateItem(Item item) {
        Item itemResponse = itemDao.updateItem(item);
        return itemResponse;
    }
 
    public Item deleteItem(int id) {
        Item itemResponse = itemDao.deleteItem(id);
        return itemResponse;
    }
}
