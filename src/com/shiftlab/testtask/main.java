package com.shiftlab.testtask;

import com.shiftlab.testtask.basket.Basket;
import com.shiftlab.testtask.basket.ShoppingBasket;
import com.shiftlab.testtask.catalog.MiniShopCatalog;
import com.shiftlab.testtask.catalog.ShopCatalog;
import com.shiftlab.testtask.model.Model;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        ShopCatalog catalog = new MiniShopCatalog();
        Basket basket = new ShoppingBasket(catalog, 123, "Фамилия Имя Отчество");
        Scanner scanner = new Scanner(System.in);
        Model model = new Model(scanner, basket);

        model.run();
    }
}
