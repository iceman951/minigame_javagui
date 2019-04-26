import java.io.*;
import java.util.*;

public class Kunai extends Item {
    public Kunai(String name, int damage, int heal){
        super(name, damage, heal);
    }
    public String getName() {
        return name;
    }
}