package combatsystem;

import java.util.LinkedList;
import java.util.List;

public class Entity {

    private int strength, dexterity;
    private Body body;
    private WeaponInventory weapons;
    private String name;

    public Entity(String nm, double h, int w, int str, int dex, List<Weapon> wepList) {
        this(h, w, str, dex, (Weapon[]) wepList.toArray());
        name = nm;
    }

    public Entity(String nm, double h, int w, int str, int dex, Weapon[] wep) {
        this(h, w, str, dex, wep);
        name = nm;
    }

    public Entity(String nm, double h, int w, int str, int dex, Weapon wep) {
        this(h, w, str, dex, wep);
        name = nm;
    }

    public Entity(double h, int w, int str, int dex, List<Weapon> wepList) {
        this(h, w, str, dex, (Weapon[]) wepList.toArray());
    }

    public Entity(double h, int w, int str, int dex, Weapon wep) {
        dexterity = dex;
        strength = str;
        //personally make the array for the lazy constructor
        Weapon[] temp = {wep};
        weapons = new WeaponInventory(strength, temp);
        body = new Body(h, w);
    }

    public Entity(double h, int w, int str, int dex, Weapon[] wep) {
        dexterity = dex;
        strength = str;
        weapons = new WeaponInventory(strength, wep);
        body = new Body(h, w);
    }

    public Entity(double h, int w, int str, int dex) {
        dexterity = dex;
        strength = str;
        weapons = new WeaponInventory(strength);
        body = new Body(h, w);
    }

    public Entity setName(String s) {
        name = s;
        return this;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        Weapon[] eqWp = weapons.getEquippedWeapons();
        int finalDamage = 0;
        int i = 0;
        while (i < 2) {
            int addDamage = 0;
            if (eqWp[i] == null) {
                addDamage = addDamage + strength;
            } else {
                if (eqWp[i].isIsSharp()) {
                    addDamage = addDamage + eqWp[i].getSharpnessBonus();
                }
                if (strength > eqWp[i].getWeight()) {
                    addDamage = addDamage + (getWeight() * strength);
                } else {
                    //not strong enough to use wp
                    //punch
                    addDamage = addDamage + strength;
                }
            }
            //IF YOUR ARMS ARE IMPAIRED YOU DO 1/4 LESS DAMAGE!
            if (body.lArm.isIsImpaired()) {
                addDamage = addDamage - (addDamage / 4);
            }
            if (body.rArm.isIsImpaired()) {
                addDamage = addDamage - (addDamage / 4);
            }
            if (addDamage < 0) {
                addDamage = 0;
            }
            finalDamage = finalDamage + addDamage;
            i++;
        }
        return finalDamage;
    }

    public double getHeight() {
        return body.getHeight();
    }

    public int getWeight() {
        return body.getWeight();
    }

    public int getStr() {
        return strength;
    }

    public int getDex() {
        //IF YOUR LEG IS IMPAIRED YOU ARE SLOWER!
        int tempDex = dexterity;
        if (body.lLeg.isIsImpaired()) {
            tempDex = tempDex - (tempDex / 4);
        }
        if (body.rLeg.isIsImpaired()) {
            tempDex = tempDex - (tempDex / 4);
        }
        if (tempDex < 0) {
            return 0;
        }
        return tempDex;
    }

    public Body getBody() {
        return body;
    }

    public WeaponInventory getWeaponInventory() {
        return weapons;
    }

    public BodyPart getBodyPart(BodyPart c) {
        return body.getBodyPart(c);
    }

    public BodyPart getBodyPart(BodyComponent c) {
        return body.getBodyPart(c);
    }

    public String simpleToString() {
        return name + "-- h: " + getHeight() + " w: " + getWeight() + " str: " + strength + " dex: " + dexterity;
    }

    @Override
    public String toString() {
        return name + "-- h: " + getHeight() + " w: " + getWeight() + " str: " + strength + " dex: " + dexterity + " body state: " + body.toString() + " " + weapons.toString() + "\n";
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
