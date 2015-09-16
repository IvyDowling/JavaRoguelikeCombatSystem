package combatsystem;

public class AttackAction extends Action {

    public AttackAction(Entity atkr, Entity victm) {
        super(atkr, victm);
    }

    @Override
    public String toString() {
        return super.getAttacker().toString() + " attacking " + super.getTarget().toString();
    }

}
