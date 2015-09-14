package combatsystem;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class CombatSystem {

    private Entity user, bot;
    private Queue<Action> actionQueue;

    public CombatSystem(Entity user, Entity bot) {
        actionQueue = new PriorityQueue<>(0, new Comparator() {
            @Override
            public int compare(Object t, Object t1) {
                int e1Dex = ((Entity) t).getDex();
                int e2Dex = ((Entity) t1).getDex();
                if (e1Dex > e2Dex) {
                    return e1Dex;
                } else if (e1Dex == e2Dex) {
                    //tie goes to the attacker
                    return e1Dex;
                } else {
                    return e2Dex;
                }
            }
        });
        this.user = user;
        this.bot = bot;
    }

    public void addAction(Action a) {
        actionQueue.add(a);
    }

    public Action getNextAction() {
        return actionQueue.remove();
    }

}
