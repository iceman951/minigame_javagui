import java.io.*;
import java.util.*;

public class Merchant extends Novice {
    public Merchant(Novice novice){
       super(novice.getName());
       setJob("Merchant", novice.getHp(), novice.getMaxHp(), novice.getLevel(), novice.getAttackPower(), novice.getKillCount(), novice.bag);
    }
    public String getJob(){
        return "Merchant";
    }
    public int useSkill() {
        if(getMoney()>=20 ) {

            useMoney(20);
            return getAttackPower()+20;
        }else {
            return 0;
        }
    }
}