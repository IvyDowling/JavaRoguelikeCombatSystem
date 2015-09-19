package combatsystem;

public class BodyPart {

    private int health;
    private boolean isImpaired;
    private boolean isArmored;
    private BodyComponent component;

    public BodyPart(int h) {
        health = h;
    }

    public BodyPart(BodyComponent bc) {
        component = bc;
    }

    public BodyPart(int h, BodyComponent bc) {
        health = h;
        component = bc;
    }

    public int getHealth() {
        return health;
    }       

    public boolean isIsImpaired() {
        return isImpaired;
    }

    public boolean isIsArmored() {
        return isArmored;
    }

    public BodyComponent getComponent() {
        return component;
    }
    
    
    
    

    @Override
    public String toString() {
        return component + " " + health;
    }
}
