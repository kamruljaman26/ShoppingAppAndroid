package com.shopping.app.dao;

import com.shopping.app.model.Item;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ItemsDAO implements DAO<Item> {
    private final Map<Integer, Item> itemMap;

    public ItemsDAO() {
        itemMap = new HashMap<>();
    }

    @Override
    public Item getById(int id) {
        return itemMap.get(id);
    }

    @Override
    public boolean addOrUpdate(Item item) {
        if (itemMap.containsKey(item.getId())) {
            itemMap.put(item.getId(), item);
            return true;
        } else {
            itemMap.put(item.getId(), item);
            return false;
        }
    }

    @Override
    public boolean remove(int id) {
        if (itemMap.containsKey(id)) {
            itemMap.remove(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(Item item) {
        return remove(item.getId());
    }

    @Override
    public List<Item> getAll() {
        return new ArrayList<>(itemMap.values());
    }

    // here we will load all dummy items data for Item
    public void loadDummyData(){
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
        addOrUpdate(new Item(11, "LG CX OLED", "macbook_pro.jpeg", 2099.99, "The LG CX OLED is a 55-inch 4K TV with HDR and Dolby Vision."));
        addOrUpdate(new Item(12, "Razer Huntsman Elite", "macbook_pro.jpeg", 199.99, "The Razer Huntsman Elite is a mechanical gaming keyboard with customizable RGB lighting."));
        addOrUpdate(new Item(13, "Oculus Quest 2", "macbook_pro.jpeg", 299.99, "The Oculus Quest 2 is a standalone VR headset with 6 degrees of freedom."));
        addOrUpdate(new Item(14, "Lenovo Legion 7i", "macbook_pro.jpeg", 1499.99, "The Lenovo Legion 7i is a gaming laptop with a 15.6-inch 144Hz display and NVIDIA GeForce RTX graphics."));
        addOrUpdate(new Item(15, "Bose SoundLink Revolve+", "macbook_pro.jpeg", 299.99, "The Bose SoundLink Revolve+ is a portable Bluetooth speaker with 360-degree sound."));
        addOrUpdate(new Item(16, "LG Gram 17", "macbook_pro.jpeg", 1599.99, "The LG Gram 17 is a lightweight laptop with a 17-inch display and long battery life."));
        addOrUpdate(new Item(17, "Apple AirPods Pro", "macbook_pro.jpeg", 249.99, "The Apple AirPods Pro are wireless noise-cancelling earbuds with a customizable fit."));
        addOrUpdate(new Item(18, "GoPro Hero9 Black", "macbook_pro.jpeg", 449.99, "The GoPro Hero9 Black is a waterproof action camera with 5K video recording."));
        addOrUpdate(new Item(19, "NVIDIA GeForce RTX 3080", "macbook_pro.jpeg", 699.99, "The NVIDIA GeForce RTX 3080 is a graphics card with 10GB of GDDR6X memory and ray tracing technology."));
    }
}

