package com.companyname.catalogservice.dao;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.companyname.catalogservice.enums.Category;
import com.companyname.catalogservice.model.Item;

@Repository
public class ItemDAO {
    
    static HashMap<Integer, Item> itemsMap = new HashMap<Integer, Item>();
    private final AtomicInteger counterItemId = new AtomicInteger();
    
    public ItemDAO() {
        Item item1 = new Item();
        item1.setId(counterItemId.incrementAndGet());
        item1.setName("Samsung Galaxy S21+");
        item1.setPrice(BigDecimal.valueOf(2.00));
        item1.getImages().add(null);
        item1.getCategories().add(Category.PHONES);
        item1.getCategories().add(Category.ELECTRONICS);
       
        Item item2 = new Item();
        item2.setId(counterItemId.incrementAndGet());
        item2.setName("Iphone 11 Pro");
        item2.getCategories().add(Category.PHONES);
        item2.getCategories().add(Category.ELECTRONICS);
        try {
            item2.getImages().add(new URL("https://images-na.ssl-images-amazon.com/images/I/61ryYO8RfQL._AC_SL1000_.jpg").toURI());   
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        itemsMap.put(item1.getId(), item1);
        itemsMap.put(item2.getId(), item2);
    }
 
    public List<Item> getAllItems() {
        List<Item> itemList = new ArrayList<Item>(itemsMap.values());
        return itemList;
    }
 
    public Item getItemForId(int id) {
        Item item = itemsMap.get(id);
        return item;
    }
 
    public Item createItem(Item item) {
        item.setId(counterItemId.incrementAndGet());
        itemsMap.put(item.getId(), item);
        return itemsMap.get(item.getId());
    }
 
    public Item updateItem(Item item) {
        if (itemsMap.get(item.getId()) != null) {
            itemsMap.get(item.getId()).setName(item.getName());
            itemsMap.get(item.getId()).setDescription(item.getDescription());
            itemsMap.get(item.getId()).setPrice(item.getPrice());
            itemsMap.get(item.getId()).setCategories(item.getCategories());
            itemsMap.get(item.getId()).setImages(item.getImages());
        } /*else {
            itemsMap.put(item.getId(), item);
        }*/
        return itemsMap.get(item.getId());
    }
 
    /*public Item deleteItem(int id) {
        if (itemsMap.containsKey(id)) {
            Item itemResponse = itemsMap.remove(id);
            return itemResponse;
        }
        return null;
    }*/
    
    public Item deleteItem(int id) {
        Item itemResponse = itemsMap.remove(id);
        return itemResponse;
    }
}
