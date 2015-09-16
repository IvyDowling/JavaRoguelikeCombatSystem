package combatsystem;

public abstract class BodyPart {

    int health;
    boolean isImpaired;
    boolean isArmored;
    BodyComponent component;

    @Override
    public String toString() {
        return component + " " + health;
    }
}
