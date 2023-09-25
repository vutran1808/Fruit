/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import common.Order;
import common.Shopping;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import model.Customer;
import model.Fruit;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class ShopManager extends Menu {

    ScannerFactory sc = new ScannerFactory();
    Shopping sp = new Shopping();
    Order od = new Order();
    Fruit fr1 = new Fruit(1, "Coconut", 2, "VietNam", 99);
    Fruit fr2 = new Fruit(2, "Orange", 3, "US", 20);
    Fruit fr3 = new Fruit(3, "Apple", 4, "Thailand", 10);
    Fruit fr4 = new Fruit(4, "Grape", 6, "France", 23);

    public ShopManager() {
        super("FRUIT SHOP SYSTEM", new String[]{"Create Fruit", "View Order", "Shopping(Buyer)", "Exit"});
        sp.addFruit(fr1);
        sp.addFruit(fr2);
        sp.addFruit(fr3);
        sp.addFruit(fr4);
    }

    public void AllFruit() {
        System.out.println("List of Fruit:");
        System.out.println("| ++Item++ " + "| ++Fruit Name++ " + "| ++Origin++ " + "| ++Price++ |");
        sp.showAll();
    }

    public void AllCustomer() {
        System.out.println("-------Customer-------");
        od.showAll().forEach(customer -> {
            System.out.println(customer.getName());
            showOrder(customer.getOrder());
            System.out.println("-----------------------");
        });
    }

    public Map<Fruit, Integer> fruitOrder() {
        Map<Fruit, Integer> fruits = new HashMap<>();
        while (true) {
            System.out.println("Choose item");
            int input = sc.getInt();
            Fruit fruit = sp.searchFruit(input);
            System.out.println("You selected: " + fruit.getFruitName() + "| Available: " + fruit.getQuantity());
            System.out.println("Please enter quantity");
            int quantity = sc.getInt();
            int quantityLeft = (fruit.getQuantity() - quantity);
            if (quantityLeft >= 0) {
                fruit.setQuantity(quantityLeft);
                fruits.put(fruit, quantity);
                System.out.println("Do you want to order now (Y/N)");
                String select = sc.getYN();
                if (select.equalsIgnoreCase("Y")) {
                    showOrder(fruits);
                    break;
                }
            } else {
                System.out.println("Not enough for you");
                System.out.println("Just " + fruit.getQuantity() + "Avalable");
            }
        }
        return fruits;
    }

    public void showOrder(Map<Fruit, Integer> map) {
        Formatter ft = new Formatter();
        int amount = 0;
        System.out.println("Product " + "| Quantity " + "| Price " + "| Amount");
        for (Fruit fruit : map.keySet()) {
            amount += map.get(fruit) * fruit.getPrice();
            ft.format("%1s %6s %9s %9s\n", fruit.getFruitName(), map.get(fruit), fruit.getPrice() + "$", map.get(fruit) * fruit.getPrice() + "$");
        }
        System.out.println(ft);
        System.out.println("Total :" + amount + "$");
    }

    public void CreateCustomer() {
        Map<Fruit, Integer> map = fruitOrder();
        System.out.println("Enter Your Name");
        String name = sc.getScanner().nextLine();
        od.addCustomer(new Customer(name, map));
    }

    public void CreateFruit() {
        System.out.println("----------Create Fruit--------");
        System.out.println("Enter fruit id");
        int id = sc.getInt();
        System.out.println("Enter fruit name");
        String name = sc.getScanner().nextLine();
        System.out.println("Enter fruit origin");
        String origin = sc.getScanner().nextLine();
        System.out.println("Enter fruit price ($)");
        int price = sc.getInt();
        System.out.println("Enter the quantity");
        int quantity = sc.getInt();
        sp.addFruit(new Fruit(id, name, price, origin, quantity));
    }

    public void addFruit() {
        CreateFruit();
        System.out.println("Do you want to continute(Y/N)");
        String input = sc.getScanner().nextLine();
        while (true) {
            if (input.equals("Y")) {
                CreateFruit();
            } else {
                AllFruit();
                break;
            }
        }
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> {
                CreateFruit();
                AllFruit();
            }
            case 2 ->
                AllCustomer();
            case 3 -> {
                AllFruit();
                CreateCustomer();
            }
            default -> {
            }
        }
    }

}
