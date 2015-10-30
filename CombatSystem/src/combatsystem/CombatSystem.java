package combatsystem;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class CombatSystem {

    private Queue<Action> actionQueue;

    public CombatSystem() {
        //2 initially in queue
        actionQueue = new PriorityQueue<>(2, new Comparator() {
            @Override
            public int compare(Object t, Object t1) {
                Action a1 = (Action) t;
                Action a2 = (Action) t1;
                if (a1.getSpark() == null) {
                    return 0;
                }
                if (a2.getSpark() == null) {
                    return 1;
                }
                //Here, we check the dexterity of the entities
                //that instigated the action in the queue
                int e1Dex = ((Entity) a1.getSpark()).getDex();
                int e2Dex = ((Entity) a2.getSpark()).getDex();

                //now, we'll random the dex value from 0-dex
                //higher goes first
                int e1Chance = new Random().nextInt(e1Dex);
                int e2Chance = new Random().nextInt(e2Dex);
                if (e1Chance > e2Chance) {
                    return 1;
                } else if (e1Chance == e2Chance) {
                    //tie goes to the instigator
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    public int popAction() { //int as current health
        if (!actionQueue.isEmpty()) {
            Action a = actionQueue.poll();
            if (a != null) {
                return a.getTarget().getBodyPart(a.getBodyPart()).dealDamage(a.getSpark().getDamage());
            }
        }
        return -1; //err
    }

    public boolean addAction(Action a) {
        //if it's not null, the instigator is not null
        //and if it's not already in the queue: add
        if (a != null && a.getSpark() != null && !actionQueue.contains(a)) {
            return actionQueue.add(a);
        }
        return false;
    }

    public Action getNextAction() {
        if(actionQueue.isEmpty()){
            return null;
        }
        return actionQueue.peek();
    }

    public boolean isEmpty() {
        return actionQueue.isEmpty();
    }

    public void clear() {
        actionQueue.clear();
    }

    @Override
    public String toString() {
        String out = "";
        for (Action a : actionQueue) {
            out += a.toString() + "\n";
        }
        return out;
    }

}
