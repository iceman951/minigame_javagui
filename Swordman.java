import java.io.*;
import java.util.*;

public class Swordman extends Novice {
    public Swordman(Novice novice){
       super(novice.getName());
       setJob("Swordman", novice.getHp(), novice.getMaxHp(), novice.getLevel(), novice.getAttackPower(),novice.getKillCount(), novice.bag);
    }

    public String getJob(){
        return "Swordman";
    }
    public int useSkill() {
        if(getHp()>6 ) {
            takeDamage(5);
            return getAttackPower()+10;
        }else {

            return 0;
        }
    }

}