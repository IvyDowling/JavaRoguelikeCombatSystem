package combatsystem;

public class Action {

    private Entity attacker, target;
    private Weapon attackerWeapon;
    
    
    //Always check dex to get priotiry
    public Action(Entity atkr, Entity victm) {
        //Attacking
        attacker = atkr;
        target = victm;
    }
    
    public Action(Entity atkr, Weapon wp){
        //Swap
        
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
