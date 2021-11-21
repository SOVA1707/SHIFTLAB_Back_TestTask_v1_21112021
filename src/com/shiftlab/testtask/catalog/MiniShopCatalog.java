package com.shiftlab.testtask.catalog;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MiniShopCatalog implements ShopCatalog {
    private Map<String, Float> catalog;

    public MiniShopCatalog() {
        catalog = new HashMap<>();

        File file = new File("catalog.txt");

        try (Scanner scanner = new Scanner(file)){

            while (scanner.hasNext()) {
                String name = scanner.next();
                float price = scanner.nextFloat();
                catalog.put(name, price);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Program error! File " + file + " not found.");
        }
    }

    @Override
    public boolean checkName(String name) {
        return catalog.containsKey(name);
    }

    @Override
    public float getPrice(String name) {
        return catalog.get(name);
    }
}
