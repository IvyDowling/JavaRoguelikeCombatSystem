package combatsystem;

public class Body {

    int totalHealth;
    BodyPart lArm, rArm, lLeg, rLeg, torso;

    public Body(int h, int w) {
//        totalHealth = h * w;
        lArm = new BodyPart(BodyComponent.LARM);
        rArm = new BodyPart(BodyComponent.RARM);
        lLeg = new BodyPart(BodyComponent.LLEG);
        rLeg = new BodyPart(BodyComponent.RLEG);
        torso = new BodyPart(BodyComponent.TORSO);
    }

    public BodyPart getBodyPart(BodyComponent c) {
        switch (c) {
            case RARM:
                return rArm;
            case LARM:
                return lArm;
            case LLEG:
                return lLeg;
            case RLEG:
                return rLeg;
            case TORSO:
                return torso;
            default:
                return null;
        }
    }
    
    public int getTotalHealth(){
        return totalHealth;
    }

    @Override
    public String toString() {
        return lArm.toString() + " " + rArm.toString() + " " + lLeg.toString() + " " + rLeg.toString() + " " + torso.toString();
    }
}
