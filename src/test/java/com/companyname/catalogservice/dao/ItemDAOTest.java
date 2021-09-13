package com.companyname.catalogservice.dao;

import com.companyname.catalogservice.enums.Category;
import com.companyname.catalogservice.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ExtendWith(MockitoExtension.class)
public class ItemDAOTest {

    @InjectMocks
    ItemDAO itemDAO;

    @Test
    void getAllItems() {

        List<Item> expectedItemList = new ArrayList<>(ItemDAO.itemsMap.values());

        List<Item> actualItemList = itemDAO.getAllItems();

        assertThat(actualItemList, is(notNullValue()));
        assertThat(actualItemList.size(), equalTo(expectedItemList.size()));
        assertThat(actualItemList.toArray(), arrayContainingInAnyOrder(expectedItemList.toArray()));
        //assertThat(actualItemList, is(expectedItemList));
    }

    @Test
    void getItemForId() {

        final int itemId = 1;

        Item actualItem = itemDAO.getItemForId(itemId);

        assertThat(actualItem, is(notNullValue()));
        assertThat(actualItem.getId(), equalTo(itemId));
    }

    @Test
    void createItem() {

        final int id = itemDAO.getAllItems().size() + 1;
        String name = "Item " + id;
        String description = "This is description for item " + id;
        List<Category> categoryList = Arrays.asList(Category.ELECTRONICS, Category.CAMERA);

        Item item = new Item(id, name, description, null, categoryList, null);

        Item actualItem = itemDAO.createItem(item);

        assertThat(actualItem, is(notNullValue()));
        assertThat(actualItem.getId(), equalTo(id));
        assertThat(actualItem.getName(), equalTo(name));
        assertThat(actualItem.getDescription(), equalTo(description));
        assertThat(actualItem.getCategories().get(0), equalTo(categoryList.get(0)));
        assertThat(actualItem.getCategories().get(1), equalTo(categoryList.get(1)));
    }

    @Test
    void updateItem() {

        final int id = 2;
        String name = "Item 2";
        String description = "This is description for item 2";

        Item item = itemDAO.getItemForId(id);
        item.setName(name);
        item.setDescription(description);

        Item actualItem = itemDAO.updateItem(item);

        assertThat(actualItem, is(notNullValue()));
        assertThat(actualItem, equalTo(item));
        assertThat(actualItem.getId(), equalTo(id));
        assertThat(actualItem.getName(), equalTo(name));
        assertThat(actualItem.getDescription(), equalTo(description));
    }

    @Test
    void deleteItem() {

        final int id = 1;

        Item deletedItem = itemDAO.deleteItem(id);

        assertThat(deletedItem, is(notNullValue()));
        assertThat(deletedItem.getId(), equalTo(id));
    }
}
