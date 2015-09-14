package combatsystem;

public class Action {

    private Entity attacker, target;
    private Weapon attackerWeapon;

    public Action(Entity atkr, Weapon atckWp, Entity victm) {
        attacker = atkr;
        attackerWeapon = atckWp;
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
