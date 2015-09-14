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
}
