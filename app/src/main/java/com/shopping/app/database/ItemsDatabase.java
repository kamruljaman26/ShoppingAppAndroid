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
        addOrUpdate(new Item(1, "Tesla Model S", "tesla_model_s.jpeg", 79999.99, "The Tesla Model S is an all-electric luxury sedan with a range of up to 520 miles."));
        addOrUpdate(new Item(2, "Porsche 911 Carrera", "porsche_911.jpeg", 99999.99, "The Porsche 911 Carrera is a high-performance sports car with a 3.0-liter twin-turbocharged engine."));
        addOrUpdate(new Item(3, "Ford Mustang Mach-E", "tesla_model_s.jpg", 42999.99, "The Ford Mustang Mach-E is an electric SUV with a range of up to 300 miles and fast-charging capabilities."));
        addOrUpdate(new Item(4, "Audi e-tron GT", "tesla_model_s.jpg", 129999.99, "The Audi e-tron GT is an electric sports car with a 93.4 kWh battery and a range of up to 238 miles."));
        addOrUpdate(new Item(5, "Jeep Grand Cherokee L", "porsche_911.jpg", 39999.99, "The Jeep Grand Cherokee L is a three-row SUV with a 3.6-liter V6 engine and advanced off-road capabilities."));
        addOrUpdate(new Item(6, "Chevrolet Corvette Stingray", "tesla_model_s.jpg", 59999.99, "The Chevrolet Corvette Stingray is a high-performance sports car with a 6.2-liter V8 engine and a top speed of 194 mph."));
        addOrUpdate(new Item(7, "BMW M5 Competition", "porsche_911.jpg", 109999.99, "The BMW M5 Competition is a high-performance luxury sedan with a 4.4-liter V8 engine and a top speed of 190 mph."));
        addOrUpdate(new Item(8, "Mercedes-Benz S-Class", "tesla_model_s.jpg", 129999.99, "The Mercedes-Benz S-Class is a luxury sedan with a spacious and refined interior and advanced technology features."));
        addOrUpdate(new Item(9, "Lamborghini Huracan Evo", "porsche_911.jpg", 299999.99, "The Lamborghini Huracan Evo is a high-performance sports car with a 5.2-liter V10 engine and a top speed of 202 mph."));
        addOrUpdate(new Item(10, "Toyota RAV4 Hybrid", "tesla_model_s.jpg", 33999.99, "The Toyota RAV4 Hybrid is a fuel-efficient SUV with a 2.5-liter hybrid engine and a range of up to 580 miles."));
    }
}

