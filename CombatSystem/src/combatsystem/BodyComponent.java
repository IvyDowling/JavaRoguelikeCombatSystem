package combatsystem;

public enum BodyComponent {

    LARM, RARM, LLEG, RLEG, TORSO, HEAD;

    @Override
    public String toString() {
        switch (this) {
            case LARM:
                return "Left Arm";
            case RARM:
                return "Right Arm";
            case LLEG:
                return "Left Leg";
            case RLEG:
                return "Right Leg";
            case TORSO:
                return "Torso";
            case HEAD:
                return "Head";
        }
        return "";
    }
}
