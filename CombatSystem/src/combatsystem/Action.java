package combatsystem;

public class Action {

    private Entity spark, target;
    private BodyPart bodyPart;

    public Action(Entity atkr, Entity victm, BodyPart bp) {
        spark = atkr;
        target = victm;
        bodyPart = bp;
    }

    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public Entity getSpark() {
        return spark;
    }

    public Entity getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return getSpark().simpleToString() + " at: " + getTarget().simpleToString() + "\n";
    }

}
