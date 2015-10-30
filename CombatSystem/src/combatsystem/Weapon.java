package combatsystem;

public class Weapon {

    private String name = "";
    private boolean isSharp;
    private int length;
    private int weight;
    private int sharpnessBonus;

    public Weapon(String n, int l, int w, int sharpBonus) {
        name = n;
        setLength(l);
        setWeight(w);
        setSharp(sharpBonus);
    }

    public Weapon(int l, int w, int sharpBonus) {
        setLength(l);
        setWeight(w);
        setSharp(sharpBonus);
    }

    public Weapon(String n, int l, int w) {
        name = n;
        setLength(l);
        setWeight(w);
        setSharp(0);
    }

    public Weapon(int l, int w) {
        setLength(l);
        setWeight(w);
        setSharp(0);
    }

    private void setLength(int l) {
        if (l >= 0) {
            length = l;
        }
    }

    private void setWeight(int w) {
        if (w >= 0) {
            weight = w;
        }
    }

    private void setSharp(int bonus) {
        if (bonus > 0) {
            sharpnessBonus = bonus;
            isSharp = true;
        } else {
            sharpnessBonus = 0;
            isSharp = false;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isIsSharp() {
        return isSharp;
    }

    public int getLength() {
        return length;
    }

    public int getWeight() {
        return weight;
    }

    public int getSharpnessBonus() {
        if (isSharp) {
            return sharpnessBonus;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "\n" + name + ", length: " + getLength() + ", weight: " + getWeight() + ", sharpness bonus: " + getSharpnessBonus();
    }
}
