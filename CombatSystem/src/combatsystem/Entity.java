package combatsystem;

public class Entity {

    private int height, weight;
    private int strength, dexterity;
    private Body body;
    private Weapon wpLeft, wpRight;

    public int getStr() {
        return strength;
    }

    public int getDex() {
        return dexterity;
    }
}
