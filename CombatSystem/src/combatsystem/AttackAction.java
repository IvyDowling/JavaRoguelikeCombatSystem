package combatsystem;

public class AttackAction extends Action {

    public AttackAction(Entity atkr, Entity victm) {
        super(atkr, victm);
    }

    @Override
    public String toString() {
        return super.getSpark().toString() + " attacking " + super.getTarget().toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        Action a;
        try {
            a = (Action) obj;
        } catch (Exception ignore) {
            return false;
        }
        if (a == this) {
            return true;
        }
        return a.getSpark().equals(this.getSpark()) && a.getTarget().equals(this.getTarget());
    }

}
