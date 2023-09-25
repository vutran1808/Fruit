/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.Fruit;

/**
 *
 * @author ASUS
 */
public class Order {

    List<Customer> customerlist;

    public Order() {
        this.customerlist = new ArrayList<>();
    }

    public List<Customer> showAll() {
        return customerlist;
    }

    public void addCustomer(Customer customer) {
        this.customerlist.add(customer);
    }


}
