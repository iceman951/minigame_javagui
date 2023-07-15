public class Item {
    String name;
    int damage;
    int heal;
    public Item(String _name, int _damage, int _heal){
        name = _name;
        damage = _damage;
        heal = _heal;
    }
    public String getName() {
        return name;
    }
    public int getDamage() {
        return damage;
    }
    public int getHeal() {
        return heal;
    }
    
}