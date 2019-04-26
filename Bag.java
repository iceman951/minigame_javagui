import java.io.*;
import java.util.*;

public class Bag {
    ArrayList<Item> items;
    int capacity;

    public Bag(){
        capacity = 5;
        items = new ArrayList<Item>();
    }

    public void putPotionInBag(){
        items.add(new Potion("Potion", 0, 20));
    }
    public void putMaxPotionInBag(){
        items.add(new MaxPotion("MaxPotion", 0, 9999));
    }
    public void putKunaiInBag(){
        items.add(new Kunai("Kunai", 50, 0));
    }
    public void useItem(int index) {
        items.remove(index-1);
    }
    public int checkFullBag() {
        return items.size();
    }
    public int getBagCapacity() {
        return capacity;
    }
}