package combatsystem;

public class Action {

    private Entity attacker, victim;
    private Weapon attackerWeapon;

    public Action(Entity atkr, Weapon atckWp, Entity victm) {
        attacker = atkr;
        attackerWeapon = atckWp;
        victim = victm;
    }
}
