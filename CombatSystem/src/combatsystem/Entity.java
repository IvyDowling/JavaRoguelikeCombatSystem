package combatsystem;

public class Entity {

    private int height, weight;
    private int strength, dexterity;
    private Body body;
    private Weapon[] weapons;

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getStr() {
        return strength;
    }

    public int getDex() {
        return dexterity;
    }

    public Body getBody() {
        return body;
    }

    public BodyPart getBodyPart(BodyComponent c) {
        return body.getBodyPart(c);
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    public int getDamage(Weapon wp) {
        int finalDamage = 0;
        if (wp.isIsSharp()) {
            finalDamage = finalDamage + wp.getSharpnessBonus();
        }
        if (strength > wp.getWeight()) {
            finalDamage = finalDamage + (weight * strength);
        } else {
            finalDamage = 0;
        }
        return finalDamage;
    }
}
