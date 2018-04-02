package com.sheamunion.CoinOptimizer;

import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MainTest {

    private ByteArrayOutputStream myOut;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(System.out);
    }

    @Test
    public void commasAndDollarSignsAreNotRequired() throws IllegalArgumentException {
        String[] args = { "3.50" };
        String expectedOutput = "Your dollar value has been optimized. \n" +
                " {silver-dollar=3, half-dollar=1, quarter=0, dime=0, nickel=0, penny=0}";

        Main.main(args);

        assertThat(myOut.toString(), CoreMatchers.containsString(expectedOutput));
    }

    @Test
    public void commasAndDollarSignsAreAcceptable() throws IllegalArgumentException {
        String[] args = { "$3,000.50" };
        String expectedOutput = "Your dollar value has been optimized. \n" +
                " {silver-dollar=3000, half-dollar=1, quarter=0, dime=0, nickel=0, penny=0}";

        Main.main(args);

        assertThat(myOut.toString(), CoreMatchers.containsString(expectedOutput));
    }

    @Test
    public void failsPolitelyWhenNoArgumentsAreProvided() throws IllegalArgumentException {
        String[] args = { };

        thrown.expect(IllegalArgumentException.class);

        Main.main(args);
    }

    @Test
    public void failsPolitelyWhenTooManyArgumentsAreProvided() throws IllegalArgumentException {
        String[] args = { "3", ".50" };

        thrown.expect(IllegalArgumentException.class);

        Main.main(args);
    }
}