package combatsystem;

public abstract class Action {

    private Entity attacker, target;

    //Always check dex to get priotiry
    public Action(Entity atkr, Entity victm) {
        attacker = atkr;
        target = victm;
    }

    public Entity getAttacker() {
        return attacker;
    }

    public Entity getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return getAttacker().toString() + " with " + getTarget().toString();

    }

}
