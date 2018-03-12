package pl.ttpsc.testing.junit.stack;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.Assert.*;

public class StackExerciseTest {

    public static long startTime;

    StackExercise sut;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

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

    @Test
    public void shouldNotGetTopEmptyStackWithExpected() throws StackEmptyException {

        //given
        //expect
        expectedException.expect(StackEmptyException.class);
        expectedException.expectMessage("Don't top empty stack!");
        //when
        sut.top();
    }

    @Test
    public void shouldNotGetTopEmptyStackWithAssertJ() throws StackEmptyException {

        //given
        //expect
        assertThatExceptionOfType(StackEmptyException.class)
                .isThrownBy(() -> sut.top())
                .withMessage("Don't top empty stack!");
        //when

        assertThatThrownBy(() -> sut.top())
                .isInstanceOf(StackEmptyException.class)
                .withFailMessage("Don't top empty stack!");
    }

    @Test(expected = StackEmptyException.class)
    public void shouldThrowExceptionWhenTryToPop() throws StackEmptyException {
        //given
        //when
        //then
        sut.pop();
    }

    @Test
    public void shouldNotPopEmptyStackWithExpected() throws StackEmptyException {

        //given
        //expect
        expectedException.expect(StackEmptyException.class);
        expectedException.expectMessage("Don't pop empty stack!");
        //when
        sut.pop();
    }

    @Test
    public void shouldNotPopEmptyStackWithAssertJ() throws StackEmptyException {

        //given
        //expect
        assertThatExceptionOfType(StackEmptyException.class)
                .isThrownBy(() -> sut.pop())
                .withMessage("Don't pop empty stack!");
        //when

        assertThatThrownBy(() -> sut.pop())
                .isInstanceOf(StackEmptyException.class)
                .withFailMessage("Don't pop empty stack!");
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
