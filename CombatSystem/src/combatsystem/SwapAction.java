package combatsystem;

public class SwapAction extends Action {

    private Weapon oldWeapon, newWeapon;

    public SwapAction(Entity atkr, Entity victm, Weapon oldWp, Weapon newWp) {
        super(atkr, victm);
        oldWeapon = oldWp;
        newWeapon = newWp;
    }

    public Weapon getOldWeapon() {
        return oldWeapon;
    }

    public Weapon getNewWeapon() {
        return newWeapon;
    }

    @Override
    public String toString() {
        return super.getAttacker().toString() + " switching: " + oldWeapon.toString() + " with " + newWeapon.toString();
    }

}
