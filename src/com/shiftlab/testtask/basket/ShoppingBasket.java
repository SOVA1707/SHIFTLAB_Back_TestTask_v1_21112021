package com.shiftlab.testtask.basket;

import com.shiftlab.testtask.catalog.ShopCatalog;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket implements Basket {

    private Map<String, Integer> list;
    private ShopCatalog catalog;
    private int order_number;
    private String full_name;
    private String date;

    public ShoppingBasket(ShopCatalog catalog, int order_number, String full_name) {
        list = new HashMap<>();
        this.catalog = catalog;
        this.order_number = order_number;
        this.full_name = full_name;
        date = LocalDate.now().getDayOfMonth() + "." + LocalDate.now().getMonthValue() + "." + LocalDate.now().getYear();
    }

    @Override
    public void addItem(String name, int number) {
        //Если количество товара < 1, то товар не нужно добавлять в корзину
        if (number < 1)
            return;
        //Форматирование названия: только первая буква должна быть заглавной
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

        if (catalog.checkName(name)) {
            //Если данный товар уже есть в корзине, то можно суммировать их количество
            if (list.containsKey(name))
                number += list.get(name);

            list.put(name, number);
        } else {
            System.out.println("Некорректный ввод данных. Продукт \"" + name + "\" не найден.");
        }
    }

    @Override
    public void print() {
        float sum = 0f;
        System.out.println("Заказ №" + order_number + " " + full_name + " " + date);
        System.out.println("\nНазвание\tЦена\tКоличество\tСумма");
        for (Map.Entry<String, Integer> entry : list.entrySet()) {
            float price = catalog.getPrice(entry.getKey());
            int number = entry.getValue();
            float full_price = number * price;
            System.out.printf("%-10s\t%-5.2f\t%-11d\t%.2f\n", entry.getKey(), price, number, full_price);
            sum += full_price;
        }
        System.out.printf("\nИтого: %.2f\n", sum);
    }
}
