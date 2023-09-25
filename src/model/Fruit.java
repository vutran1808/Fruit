package model;

import java.util.Formatter;

public class Fruit {

    private int fruitId;
    private String fruitName;
    private int price;
    private String origin;
    private int quantity;

    public Fruit(int fruitId, String fruitName, int price, String origin, int quanyity) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.origin = origin;
        this.quantity = quanyity;
    }

    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    

}
