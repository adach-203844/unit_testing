package pl.ttpsc.testing.junit.stack;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class StackExerciseTest {

    public static long startTime;

    StackExercise sut;

    @BeforeClass
    public static void beforeClass() {
        startTime = System.currentTimeMillis();
    }

    @Before
    public void setUp() {
        sut = new StackExercise();
    }

    

    @After
    public void tearDown() {
        sut = null;
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Total time " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}
