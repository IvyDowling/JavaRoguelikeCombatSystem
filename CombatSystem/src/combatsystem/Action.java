package combatsystem;

public class Action {

    private Entity attacker, target;
    private Weapon attackerWeapon;

    public Action(Entity atkr, Entity victm) {
        //Attacking
        attacker = atkr;
        target = victm;
    }

    public Entity getAttacker() {
        return attacker;
    }

    public Entity getTarget() {
        return target;
    }

    public Weapon getAttackerWeapon() {
        return attackerWeapon;
    }

}
