package pl.ttpsc.testing.assertj;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.ttpsc.testing.assertj.FellowTestFixture.*;

public class FellowshipAssertionTest {

    private Fellowship fellowship = formTheFellowshipOfTheRing();

    @Test
    public void frodoShouldBeIn() {
        assertThat(fellowship).contains(frodo());
    }

    @Test
    public void sauronShouldNotBeIn() {
        assertThat(fellowship).doesNotContain(sauron());
    }

    @Test
    public void shouldFrodoNameBeCorrectAndNotBeASauronAndBeInFellowship() {
    }

    @Test
    public void aragornShouldBeBeforeBoromir() {
    }

    @Test
    public void shouldNotContainDuplicatedFellows() {
    }

    @Test
    public void shouldContainOnlyFellowsWithExpectedNamesInProperOrder() {
    }

    @Test
    public void shouldContainNineFellowsButNoneGiant() {
        assertThat(fellowship).hasSize(9);
    }

    @Test
    public void shouldContainTupleForBoromirSamAndLegolas() {
        // Extracting multiple values at once (using tuple to group them)
        // Create tuples with name and race name
    }


    @Test
    public void shouldContainsFourHobbits() {
    }


    private Fellowship formTheFellowshipOfTheRing() {
        return new Fellowship(
                frodo(),
                sam(),
                merry(),
                pippin(),
                gandalf(),
                legolas(),
                gimli(),
                aragorn(),
                boromir());
    }
}
