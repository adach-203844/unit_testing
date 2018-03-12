package pl.ttpsc.testing.junit.calculator;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class SimpleCalculatorTest {

    public static long startTime;

    SimpleCalculator sut;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @BeforeClass
    public static void beforeClass() {
        startTime = System.currentTimeMillis();
    }

    @Before
    public void setUp() {
        sut = new SimpleCalculator();
    }

    @Test
    public void shouldAddTwoNumbers() {

        //given
        double a = 1.0d;
        double b = 2.0d;
        //when
        double actual = sut.add(a, b);
        //then
        assertEquals(3.0d, actual, 0.0001d);
    }

    @Test
    public void shouldSubtractTwoNumbers() {

        //given
        double a = 3.0;
        double b = 1.0;
        //when
        double actual = sut.subtract(a, b);
        //then
        assertEquals("message when subtract fail", 2.0, actual, 0.0001);
    }

    @Test
    @Parameters({"3", "5", "7", "11", "13", "17"})
    public void shouldDetermineWhenNumberIsPrime(int number) {

        //given
        //when
        boolean prime = sut.isPrime(number);
        //then
        assertTrue(prime);
    }

    @Test
    @Parameters(method = "primeNumbers")
    public void shouldDetermineWhenNumberIsPrime(int number, boolean primeFrag) {

        //given
        //when
        boolean prime = sut.isPrime(number);
        //then
        assertEquals(primeFrag, prime);
    }

    static Object[] primeNumbers() {
        return $(
                $(12, false),
                $(7, true),
                $(17, true),
                $(24, false)
        );
    }

    @Test(expected = CannotDivideByZeroException.class)
    public void shouldNotDivideByZero() throws CannotDivideByZeroException {

        //given
        double a = 1.0d;
        double b = 0.0d;
        //when
        sut.divide(a, b);
    }

    @Test
    public void shouldNotDivideByZeroWithExpected() throws CannotDivideByZeroException {

        //given
        double a = 1.0d;
        double b = 0.0d;
        //expect
        expectedException.expect(CannotDivideByZeroException.class);
        expectedException.expectMessage("Can't by zero!");
        //when
        sut.divide(a, b);
    }

    @Test
    public void shouldNotDivideByZeroWithAssertJ() {

        //given
        double a = 1.0d;
        double b = 0.0d;
        //expect
        assertThatExceptionOfType(CannotDivideByZeroException.class)
                .isThrownBy(() -> sut.divide(a, b))
                .withMessage("Can't by zero!");
        //when

        assertThatThrownBy(() -> sut.divide(a, b))
                .isInstanceOf(CannotDivideByZeroException.class)
                .withFailMessage("Can't by zero!");
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