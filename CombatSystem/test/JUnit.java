
import combatsystem.*;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class JUnit {

    @Test
    public void test() {
        Queue<Action> actionQueue = new PriorityQueue<>(2, new Comparator() {
            @Override
            public int compare(Object t, Object t1) {
                Action a1 = (Action) t;
                Action a2 = (Action) t1;
                if (a1.getAttacker().getDex() > a2.getTarget().getDex()) {
                    //t is faster than t1
                    return 1;
                } else {
                    //t is slower than t1
                    return 0;
                }
            }
        });

//        System.out.println("Testing now");
        List<Weapon> wepList = new LinkedList<>();
        wepList.add(new Weapon(0, 0));
        Entity e1 = new Entity(0, 0, 0, 0);
        Entity e2 = new Entity(0, 0, 0, 0, wepList);
        CombatSystem cs = new CombatSystem(e1, e2);

        Action act = new AttackAction(e1, e2);

        actionQueue.add(act);

        Action turn = actionQueue.remove();
//        System.out.println(turn.toString());

        //aserts
        assertEquals(turn, act);
        assertEquals(e1.getHeight(), 0);
    }
}
