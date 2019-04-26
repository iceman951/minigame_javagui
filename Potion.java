import java.io.*;
import java.util.*;

public class Potion extends Item {
    public Potion(String name, int damage, int heal){
        super("Potion", damage, heal);
    }
    public String getName() {
        return name;
    }
}