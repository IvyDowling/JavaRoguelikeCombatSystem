package combatsystem;

import java.util.LinkedList;
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
        body = new Body(h, w);
    }

    public Entity(int h, int w, int str, int dex, Weapon wep) {
        height = h;
        weight = w;
        dexterity = dex;
        strength = str;
        List<Weapon> temp = new LinkedList<>();
        temp.add(wep);
        weapons = new WeaponInventory(strength, temp);
        body = new Body(h, w);
    }

    public Entity(int h, int w, int str, int dex, List<Weapon> wepList) {
        height = h;
        weight = w;
        dexterity = dex;
        strength = str;
        weapons = new WeaponInventory(strength, wepList);
        body = new Body(h, w);
    }

    public int getDamage() {
        Weapon[] eqWp = weapons.getEquippedWeapons();
        int finalDamage = 0;
        int i = 0;
        while (i < 2) {
            if (eqWp[i] == null) {
                finalDamage = finalDamage + strength;
            } else {
                if (eqWp[i].isIsSharp()) {
                    finalDamage = finalDamage + eqWp[i].getSharpnessBonus();
                }
                if (strength > eqWp[i].getWeight()) {
                    finalDamage = finalDamage + (weight * strength);
                } else {
                    //not strong enough to use wp
                    //punch
                    finalDamage = finalDamage + strength;
                }
            }
            i++;
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
