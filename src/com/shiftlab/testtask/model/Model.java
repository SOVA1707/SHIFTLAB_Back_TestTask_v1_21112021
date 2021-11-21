package com.shiftlab.testtask.model;

import com.shiftlab.testtask.basket.Basket;

import java.util.Scanner;

public class Model {

    private Scanner scanner;
    private Basket basket;

    public Model(Scanner scanner, Basket basket) {
        this.scanner = scanner;
        this.basket = basket;
    }

    public void add() {
        System.out.print("Введите название продукта и количество: ");
        String name = scanner.next();
        int number = scanner.nextInt();
        basket.addItem(name, number);
    }

    public void run() {
        boolean bool = true;
        while (bool) {
            System.out.println("Ожидание ввода.");
            System.out.println("1 - добавить товар в корзину.");
            System.out.println("2 - посмотреть корзину.");
            System.out.println("Введите любые символы чтобы выйти.");
            String n = scanner.next();
            switch (n) {
                case "1": {
                    add();
                    break;
                }
                case "2": {
                    basket.print();
                    break;
                }
                default:
                    bool = false;
            }
        }
    }
}
