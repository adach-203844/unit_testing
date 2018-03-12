package pl.ttpsc.testing.junit.stack;


import org.junit.*;

import static org.junit.Assert.*;

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

    @Test
    public void shouldStackBeEmpty() {
        //given
        //when
        //then
        assertTrue(sut.isEmpty());
    }

    @Test
    public void shouldStackNotBeEmpty() {
        //given
        //when
        sut.push("first");
        //then
        assertFalse(sut.isEmpty());
    }

    @Test
    public void shouldGetTop() throws StackEmptyException {
        //given
        //when
        sut.push("first");
        //then
        assertEquals("first", sut.top());
    }

    @Test(expected = StackEmptyException.class)
    public void shouldThrowExceptionWhenTryToGetTop() throws StackEmptyException {
        //given
        //when
        //then
        sut.top();
    }

    @Test(expected = StackEmptyException.class)
    public void shouldThrowExceptionWhenTryToPop() throws StackEmptyException {
        //given
        //when
        //then
        sut.top();
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
