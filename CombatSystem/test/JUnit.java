
import combatsystem.CombatSystem;
import combatsystem.Entity;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class JUnit {

    public JUnit() {
    }

    @BeforeClass
    public static void setUpClass() {
        Entity e1 = new Entity();
        Entity e2 = new Entity();
        CombatSystem cs = new CombatSystem(e1, e2);
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
    public void hello() {

    }
}
