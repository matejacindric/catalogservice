package com.companyname.catalogservice.dao;

import com.companyname.catalogservice.enums.Category;
import com.companyname.catalogservice.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemFilterDAOTest {

    @Mock
    private ItemDAO itemDAO;
    @InjectMocks
    private ItemFilterDAO itemFilterDAO;

    @Test
    void searchByName() {
        String keyword = "item";

        Item item1 = new Item(1, "Item 1", "This is description for item 1", null, Arrays.asList(Category.ELECTRONICS, Category.PHONES), null);
        Item item2 = new Item(2, "Item 2", "This is description for item 2", null, Arrays.asList(Category.ELECTRONICS, Category.CAMERA), null);
        Item item3 = new Item(3, "It 3", "This is description for item 3", null, Arrays.asList(Category.ELECTRONICS, Category.CAMERA), null);

        List<Item> itemList = Arrays.asList(item1, item2, item3);

        when(itemDAO.getAllItems()).thenReturn(itemList);

        List<Item> actualItemList = itemFilterDAO.searchByName(keyword);

        assertThat(actualItemList, is(notNullValue()));
        assertThat(actualItemList.size(), equalTo(2));
    }

    @Test
    void searchByCategories() {
        List<Category> categoryList = Arrays.asList(Category.CAMERA, Category.PHONES, Category.TV);

        Item item1 = new Item(1, "Item 1", "This is description for item1", null, Arrays.asList(Category.ELECTRONICS, Category.PHONES), null);
        Item item2 = new Item(2, "Item 2", "This is description for item2", null, Arrays.asList(Category.ELECTRONICS, Category.CAMERA), null);
        Item item3 = new Item(3, "Item 3", "This is description for item3", null, Arrays.asList(Category.SOFTWARE), null);

        List<Item> itemList = Arrays.asList(item1, item2, item3);

        when(itemDAO.getAllItems()).thenReturn(itemList);

        List<Item> actualItemList = itemFilterDAO.searchByCategories(categoryList);

        assertThat(actualItemList, is(notNullValue()));
        assertThat(actualItemList.size(), equalTo(2));
    }

    @Test
    void searchByNameAndDescription() {

        String keyword = "item";

        Item item1 = new Item(1, "Item 1", "This is description for item1", null, Arrays.asList(Category.ELECTRONICS, Category.PHONES), null);
        Item item2 = new Item(2, "Item 2", "This is description for item2", null, Arrays.asList(Category.ELECTRONICS, Category.CAMERA), null);
        Item item3 = new Item(3, "It 3", "This is description for it3", null, Arrays.asList(Category.ELECTRONICS, Category.CAMERA), null);

        List<Item> itemList = Arrays.asList(item1, item2, item3);

        when(itemDAO.getAllItems()).thenReturn(itemList);

        List<Item> actualItemList = itemFilterDAO.searchByNameAndDescription(keyword);

        assertThat(actualItemList, is(notNullValue()));
        assertThat(actualItemList.size(), equalTo(2));
    }

}
