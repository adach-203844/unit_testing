package pl.ttpsc.testing.assertj;

import org.assertj.core.groups.Tuple;
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
        assertThat(fellowship).extracting(Fellow::getName).contains("Frodo").doesNotContain("Sauron");
    }

    @Test
    public void aragornShouldBeBeforeBoromir() {
        assertThat(fellowship).containsSubsequence(aragorn(), boromir());
    }

    @Test
    public void shouldNotContainDuplicatedFellows() {
        assertThat(fellowship).doesNotHaveDuplicates();
    }

    @Test
    public void shouldContainOnlyFellowsWithExpectedNamesInProperOrder() {
        assertThat(fellowship).extracting(Fellow::getName)
                .containsSequence("Frodo", "Sam", "Merry", "Pippin", "Gandalf", "Legolas", "Gimli", "Aragorn", "Boromir");
    }

    @Test
    public void shouldContainNineFellowsButNoneGiant() {
        assertThat(fellowship).hasSize(9).filteredOn(f -> f.getRace().equals(Fellow.Race.GIANT)).hasSize(0);
    }

    @Test
    public void shouldContainTupleForBoromirSamAndLegolas() {
        // Extracting multiple values at once (using tuple to group them)
        // Create tuples with name and race name
        assertThat(fellowship).extracting(Fellow::getName, Fellow::getRace)
                .contains(
                        Tuple.tuple("Boromir", Fellow.Race.MAN),
                        Tuple.tuple("Sam", Fellow.Race.HOBBIT),
                        Tuple.tuple("Legolas", Fellow.Race.ELF));
    }


    @Test
    public void shouldContainsFourHobbits() {
        assertThat(fellowship).filteredOn(f -> f.getRace().equals(Fellow.Race.HOBBIT)).hasSize(4);
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
