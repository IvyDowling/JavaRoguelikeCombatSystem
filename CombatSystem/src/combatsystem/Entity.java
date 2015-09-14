package combatsystem;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Entity {

    private int height, weight;
    private int strength, dexterity;
    private Body body;
    private List<Weapon> weapons;

    public Entity(int h, int w, int str, int dex, List<Weapon> weaponsList) {
        weapons = new LinkedList<>();
        height = h;
        weight = w;
        dexterity = dex;
        strength = str;
        int carryingCap = str;
        if (weaponsList != null) {
            while (!weaponsList.isEmpty()) {
                int wpWeight = weaponsList.get(0).getWeight();
                if (carryingCap > wpWeight) {
                    weapons.add(weaponsList.remove(0));
                    carryingCap = carryingCap - wpWeight;
                    System.out.println("added " + weapons.get(weapons.size() - 1));
                } else {
                    System.out.println(weaponsList.toString());
                    weaponsList.clear();
                }
            }
        }
    }

    public boolean addWeapon(Weapon wp) {
        if ((wp.getWeight() + getCurrentWeaponWeight()) > strength) {
            return false;
        } else {
            weapons.add(wp);
            return true;
        }
    }

    public boolean addWeapon(Collection<Weapon> wps) {
        int currentWeight = getCurrentWeaponWeight();
        Iterator it = wps.iterator();
        while (it.hasNext()) {
            Weapon temp = (Weapon) it.next();
            if (currentWeight + temp.getWeight() > strength) {
                //too heavy, dont add + return false
                return false;
            } else {
                weapons.add(temp);
                currentWeight += temp.getWeight();
            }
        }
        return true;
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

    private int getCurrentWeaponWeight() {
        int i = 0;
        int wepWeight = 0;
        while (i < weapons.size()) {
            wepWeight = wepWeight + weapons.get(i).getWeight();
            i++;
        }
        return wepWeight;
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

    public List<Weapon> getWeapons() {
        return weapons;
    }
}
