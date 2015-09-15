package combatsystem;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Entity {

    private int height, weight;
    private int strength, dexterity;
    private Body body;
    private WeaponInventory weaponList;

    public Entity(int h, int w, int str, int dex) {
        height = h;
        weight = w;
        dexterity = dex;
        strength = str;
        weaponList = new WeaponInventory(strength);
    }
    public Entity(int h, int w, int str, int dex, List<Weapon> wepList) {
        height = h;
        weight = w;
        dexterity = dex;
        strength = str;
        weaponList = new WeaponInventory(strength, wepList);
    }

    public int getDamage(Weapon wp) {
        if(wp == null){
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
}
