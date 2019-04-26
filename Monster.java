import java.io.*;
import java.util.*;

public class Monster{
    private String name;
    private int maxHp;
    private int hp;
    private int attackPower;
    private int exp;

    public Monster(String _name){
        name = _name;
    }
    public void setStat(int _maxHp, int _hp, int _attackPower, int _exp) {
        maxHp = _maxHp;
        hp = _hp;
        attackPower = _attackPower;
        exp = _exp;
    }
    
    public String getName(){
        return name;
    }
    public int getMaxHp(){
        return maxHp;
    }
    public int getHp(){
        return hp;
    }
    public int getAttackPower(){
        return attackPower;
    }
    public int getExp(){
        return exp;
    }
    public int setHp(){
        return hp;
    }
    public int setAttackPower(){
        return attackPower;
    }
    public void takeDamage(int damage) {
        hp = hp - damage;
    }

}