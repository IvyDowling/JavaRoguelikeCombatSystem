
import combatsystem.*;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class JUnit {

    List<Weapon> wepList1 = new LinkedList<>();
    List<Weapon> wepList2 = new LinkedList<>();

    //l,w,bSharp,howSharp?
    Weapon zeros = new Weapon(0, 0);
    Weapon poleArm = new Weapon(5, 10);
    Weapon longsword = new Weapon(3, 2, true, 10);
    Weapon dagger = new Weapon(1, 1, true, 30);
    Weapon battleAxe = new Weapon(2, 10, true, 10);

    //h,w,str,dex
    Entity e1 = new Entity(6, 200, 50, 90, wepList1); // e1 is faster
    Entity e2 = new Entity(6, 180, 70, 70, wepList2); // e2 is stronger
    Entity zeroEntity = new Entity(0, 0, 0, 0, zeros); //has only the 0,0 weapon
    
    CombatSystem cs = new CombatSystem();

    Action act1 = new AttackAction(e1, e2);
    Action act2 = new DodgeAction(e2);

    @Test
    public void general() {

        wepList1.add(longsword);
        wepList1.add(dagger);
        wepList2.add(poleArm);
        wepList2.add(dagger);

        cs.addAction(act1);
        cs.addAction(act2);

        Action turn = cs.getNextAction();
        //aserts
        assertEquals(turn, act2);
        assertTrue(e1.getDex() > e2.getDex());
        assertTrue(e1.getDamage() < e2.getDamage());
    }

    @Test
    public void zeros() {
        assertEquals(zeroEntity.getDamage(), 2 * zeroEntity.getStr()); //two empty hands = punch * 2
    }
}
