package combatsystem;

public class Body {

    BodyPart lArm, rArm, lLeg, rLeg, torso;

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
    
    @Override
    public String toString(){
        return lArm.toString() + " " + rArm.toString() + " " + lLeg.toString() + " " + rLeg.toString() + " " + torso.toString();
    }
}
