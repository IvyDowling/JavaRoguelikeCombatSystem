package combatsystem;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

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
                
                //higher dex goes first
                if (e1Dex > e2Dex) {
                    return 1;
                } else if (e1Dex == e2Dex) {
                    //tie goes to the instigator
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }
    

    public void addAction(Action a) {
        if (a != null) {
            if (a.getSpark() != null) {
                actionQueue.add(a);
            }
        }
    }

    public Action getNextAction() {
        return actionQueue.remove();
    }

}
