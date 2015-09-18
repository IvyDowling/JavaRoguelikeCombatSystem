package combatsystem;

import java.util.List;

public class Entity {

    private int height, weight;
    private int strength, dexterity;
    private Body body;
    private WeaponInventory weapons;

    public Entity(int h, int w, int str, int dex) {
        height = h;
        weight = w;
        dexterity = dex;
        strength = str;
        weapons = new WeaponInventory(strength);
    }

    public Entity(int h, int w, int str, int dex, List<Weapon> wepList) {
        height = h;
        weight = w;
        dexterity = dex;
        strength = str;
        weapons = new WeaponInventory(strength, wepList);
    }

    public int getDamage(Weapon wp) {
        if (wp == null) {
            return 0;
        }
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

    @Override
    public String toString() {
        return "h: " + height + " w: " + weight + " str: " + strength + " dex: " + dexterity + " body state: " + body.toString() + " wpList: " + weapons.toString();
    }

    @Override
    public boolean equals(Object obj) {
        Entity e;
        try {
            e = (Entity) obj;
        } catch (Exception ignore) {
            return false;
        }
        if (e == this) {
            return true;
        }
        return e.hashCode() == this.hashCode();
    }
}
