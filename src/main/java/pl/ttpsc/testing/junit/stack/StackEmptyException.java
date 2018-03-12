/**
 * This example is based on example from the book:
 * <p>
 * Pragmatic Unit Testing in Java with JUnit by:
 * Andy Hunt
 * Dave Thomas
 * <p>
 * All rights belong to the authors of the book.
 */
package pl.ttpsc.testing.junit.stack;

public class StackEmptyException extends Exception {

    public StackEmptyException(String s) {
        super(s);
    }
}
