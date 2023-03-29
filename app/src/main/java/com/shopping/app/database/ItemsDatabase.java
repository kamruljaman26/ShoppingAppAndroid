package com.shopping.app.database;

import com.shopping.app.model.Item;

import java.util.List;
import java.util.ArrayList;

/**
 * Just an Overlay or ArrayList so we can assume it as dummy database
 */
public class ItemsDatabase {
    private final ArrayList<Item> itemList;

    public ItemsDatabase() {
        itemList = new ArrayList<>();
    }

    public Item getById(int id) {
        for (Item item : itemList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public boolean addOrUpdate(Item item) {
        int index = itemList.indexOf(item);
        if (index != -1) {
            itemList.set(index, item);
            return true;
        } else {
            itemList.add(item);
            return false;
        }
    }

    public boolean remove(int id) {
        for (Item item : itemList) {
            if (item.getId() == id) {
                itemList.remove(item);
                return true;
            }
        }
        return false;
    }

    public boolean remove(Item item) {
        return itemList.remove(item);
    }

    public List<Item> getAll() {
        return itemList;
    }

    // here we will load all dummy items data for Item
    public void loadDummyData() {
        addOrUpdate(new Item(1, "Macbook Pro M1 16gb", "macbook_pro.jpeg", 1099.99, "Macbook Pro M1 features a 6.7-inch Super Retina XDR display and A14 Bionic chip."));
        addOrUpdate(new Item(2, "Iphone 14 Pro Max", "iphone_14_pro.jpeg", 1199.99, "The iPhone 12 Pro Max features a 6.7-inch Super Retina XDR display and A14 Bionic chip"));
        addOrUpdate(new Item(3, "Sony WH-1000XM4", "macbook_pro.jpeg", 349.99, "The Sony WH-1000XM4 is a noise-cancelling wireless headphone with up to 30 hours of battery life."));
        addOrUpdate(new Item(4, "DJI Mavic Air 2", "macbook_pro.jpeg", 799.99, "The DJI Mavic Air 2 is a foldable drone with a 48MP camera and 4K video recording."));
        addOrUpdate(new Item(5, "Logitech MX Master 3", "iphone_14_pro.jpeg", 99.99, "The Logitech MX Master 3 is a wireless mouse with customizable buttons and a 4000 DPI sensor."));
        addOrUpdate(new Item(6, "Bose QuietComfort Earbuds", "macbook_pro.jpeg", 279.99, "The Bose QuietComfort Earbuds are wireless noise-cancelling earbuds with up to 6 hours of battery life."));
        addOrUpdate(new Item(7, "Apple iPad Pro (2021)", "macbook_pro.jpeg", 1099.99, "The iPad Pro (2021) features an M1 chip and a Liquid Retina XDR display."));
        addOrUpdate(new Item(8, "Sony A7 III", "macbook_pro.jpeg", 1999.99, "The Sony A7 III is a full-frame mirrorless camera with 24.2MP sensor and 4K video recording."));
        addOrUpdate(new Item(9, "Samsung Odyssey G7", "iphone_14_pro.jpeg", 799.99, "The Samsung Odyssey G7 is a 27-inch curved gaming monitor with a 240Hz refresh rate."));
        addOrUpdate(new Item(10, "Microsoft Surface Laptop 4", "macbook_pro.jpeg", 1299.99, "The Microsoft Surface Laptop 4 features a 13.5-inch touchscreen display and 11th Gen Intel Core processors."));
    }
}

