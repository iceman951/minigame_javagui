import java.io.*;
import java.util.*;

public class MaxPotion extends Item {
    public MaxPotion(String name, int damage, int heal){
        super(name, damage, heal);
    }
    public String getName() {
        return name;
    }
}