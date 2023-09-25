/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author ASUS
 */
public class Customer {
    private String name;
    private Map<Fruit, Integer> order;

    public Customer(){
        order = new TreeMap<>();
    }
    
    public Customer(String name, Map<Fruit, Integer> order) {
        this.name = name;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addFruit(Fruit fruit, int quantity) {
        this.order.put(fruit, quantity);
    }

    public Map<Fruit, Integer> getOrder() {
        return order;
    }

    public void setOrder(Map<Fruit, Integer> order) {
        this.order = order;
    }
    

}
