
import combatsystem.*;
import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class JUnit {

    public JUnit() {
        List<Weapon> wepList = new LinkedList<>();
        wepList.add(new Weapon(0, 0));
        Entity e1 = new Entity(0, 0, 0, 0);
        Entity e2 = new Entity(0, 0, 0, 0, wepList);
        CombatSystem cs = new CombatSystem(e1, e2);
        
        Action act = new AttackAction(e1, e2);
        add(act);
        exe();
    }

    private static final Queue<Action> actionQueue = new PriorityQueue<Action>(0, new Comparator() {
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

    @BeforeClass
    public static void setUpClass() {
        
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public static void add(Action a) {
        actionQueue.add(a);
    }

    @Test
    public static void exe() {
        Action turn = actionQueue.remove();
        System.out.println(turn.toString());
    }
}
