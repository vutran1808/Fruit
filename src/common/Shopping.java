/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import model.Fruit;

/**
 *
 * @author ASUS
 */
public class Shopping {

    private List<Fruit> listFruit;

    public Shopping() {
        this.listFruit = new ArrayList<>();
    }

    public void showAll() {
        Formatter ft = new Formatter();
        for (Fruit fruit : listFruit) {
            ft.format("%6s %15s %16s %8s\n", fruit.getFruitId(), fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
        }
        System.out.println(ft);
    }

    public boolean addFruit(Fruit fruit) {
        return this.listFruit.add(fruit);
    }

    public Fruit searchFruit(int id) {
        return listFruit.stream().filter(fruit -> id == fruit.getFruitId()).findAny().orElse(null);
    }

    public void removeFruit(int id) {
        this.listFruit.forEach(fruit -> {
            if (fruit.getFruitId() == id) {
                listFruit.remove(fruit);
            } else {
                System.out.println("ID is not existed!");
            }
        });
    }

}
