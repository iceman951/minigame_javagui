public class Novice{
    String name;
    private int maxHp;
    private int hp;
    private int attackPower;
    private int exp;
    private int level;
    private int money;
    private int killCount;
    private String job;
    Bag bag;

    public Novice(String _name){
        name = _name;
        maxHp = 40;
        hp = maxHp;
        attackPower = 5;
        exp = 0;
        level = 1;
        money = 200;
        killCount = 0;
        bag = new Bag();
    }
    
    public void setJob(String _job, int _hp, int _maxHp, int _level, int _attackPower, int _killCount, Bag _bag) {
        job = _job;
        hp = _hp;
        maxHp = _maxHp;
        level = _level;
        attackPower = _attackPower;
        killCount = _killCount;
        bag = _bag;
    }

    public void setName(String _name){
        name = _name;
    }
    public int getKillCount() {
        return killCount;
    }
    public void stackKill() {
        killCount++;
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
    public int getLevel(){
        return level;
    }
    public int getMoney(){
        return money;
    }
    
    public void useMoney(int cost) {
        money -= cost;
    }
    public int useSkill() {
        int skillDamage=0;
        return skillDamage;
    }
    public String getJob(){
        return job;
    }
    public void buyItem(int cost) {
        if (money < cost){
            System.out.println("\nNot Enought Money!!!\n");
        }
        else    {
            money = money - cost;
            System.out.println("\nThaks For Purchased!!!\n");
        }
    }
    public void expGain(int expgain) {
        exp = exp + expgain;
    }
    public void takeMoney(int dropMoney) {
        money = money + dropMoney;
    }
    public void takeDamage(int damage) {
        hp = hp - damage;
    }
    public void reborn() {
        hp = maxHp;
        exp = 0;
        money = money/2;
    }
    public void healFullLife(int _money) {
        money = money - _money;
        hp = maxHp;
    }
    public void usePotion(int healPoint) {
        hp = hp + healPoint;
        if(hp>maxHp) hp = maxHp;
    }
    public void levelUp(int lvlupExp, int lvlupLevel) {
        if (lvlupExp >= lvlupLevel*50){
        level++;
        attackPower++;
        exp = 0;
        maxHp = maxHp+10;
        hp = maxHp;
        }
    }

}