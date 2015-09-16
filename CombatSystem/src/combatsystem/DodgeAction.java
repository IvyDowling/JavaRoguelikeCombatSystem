package combatsystem;

public class DodgeAction extends Action{

    public DodgeAction(Entity atkr, Entity victm) {
        super(atkr, victm);
    }
    
    @Override
    public String toString() {
        return super.getAttacker().toString() + " dodging";
    }
}
