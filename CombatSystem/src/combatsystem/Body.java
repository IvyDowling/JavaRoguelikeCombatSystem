package combatsystem;

public class Body {

    private double height;
    private int weight;
    BodyPart lArm, rArm, lLeg, rLeg, torso, head;

    public Body(double h, int w) {
        height = h;
        weight = w;
        int div = w / 2; // half for arms & legs
        lArm = new BodyPart(div, BodyComponent.LARM);
        rArm = new BodyPart(div, BodyComponent.RARM);
        lLeg = new BodyPart(div, BodyComponent.LLEG);
        rLeg = new BodyPart(div, BodyComponent.RLEG);
        //head & torso are critical so they have more health
        torso = new BodyPart(w, BodyComponent.TORSO);
        head = new BodyPart(w, BodyComponent.HEAD);
    }

    public boolean isImpaired() {
        int im = 0;
        if (lArm.isIsImpaired()) {
            im++;
        }
        if (rArm.isIsImpaired()) {
            im++;
        }
        if (lLeg.isIsImpaired()) {
            im++;
        }
        if (rLeg.isIsImpaired()) {
            im++;
        }
        if (head.isIsImpaired()) {
            im++;
        }
        if (torso.isIsImpaired()) {
            im++;
        }
        if (lArm.isIsImpaired()) {
            im++;
        }
        return im > 2;
    }

    public BodyPart getBodyPart(BodyPart b) {
        switch (b.getComponent()) {
            case RARM:
                return rArm;
            case LARM:
                return lArm;
            case LLEG:
                return lLeg;
            case RLEG:
                return rLeg;
            case TORSO:
                return torso;
            case HEAD:
                return head;
            default:
                return null;
        }
    }

    public BodyPart getBodyPart(BodyComponent c) {
        switch (c) {
            case RARM:
                return rArm;
            case LARM:
                return lArm;
            case LLEG:
                return lLeg;
            case RLEG:
                return rLeg;
            case TORSO:
                return torso;
            case HEAD:
                return head;
            default:
                return null;
        }
    }

    public double getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object obj) {
        Body temp;
        try {
            temp = (Body) obj;
        } catch (Exception ignore) {
            return false;
        }
        if (temp == this) {
            return true;
        }
        //check the height, weight, and compare every body part.
        if (temp.getHeight() == this.getHeight() && temp.getWeight() == this.getWeight()) {
            if (!temp.lArm.equals(this.lArm)) {
                return false;
            }
            if (!temp.rArm.equals(this.rArm)) {
                return false;
            }
            if (!temp.lLeg.equals(this.lLeg)) {
                return false;
            }
            if (!temp.rLeg.equals(this.rLeg)) {
                return false;
            }
            if (!temp.torso.equals(this.torso)) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return lArm.toString() + " " + rArm.toString() + " " + lLeg.toString() + " " + rLeg.toString() + " " + torso.toString() + " " + head.toString();
    }
}
