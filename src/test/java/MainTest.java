package com.sheamunion.CoinOptimizer;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.security.Permission;

import static org.junit.Assert.*;

public class MainTest {

    private View view;
    private ByteArrayOutputStream myOut;
    private String usageMessage;


    public static final class ExitSecurityException extends SecurityException {}

    public class ExitDeniedSecurityManager extends SecurityManager {
        @Override
        public void checkExit(final int status) {
            throw new ExitSecurityException();
        }

        @Override
        public void checkPermission(final Permission perm) {}
    }

    @Before
    public void setUp() throws Exception {
        view = new View();
        myOut = new ByteArrayOutputStream();
        usageMessage = "Usage: java com.sheamunion.CoinOptimizer.Main <dollarValue>\n - <dollarValue> formats: 3000.50 or \\$3,000.50 or '$3'\n";
        System.setOut(new PrintStream(myOut));
        System.setSecurityManager(new ExitDeniedSecurityManager());
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(System.out);
    }

    @Test
    public void commasAndDollarSignsAreNotRequired() throws Exception {
        String[] args = { "3.50" };
        String expectedOutput = "Your dollar value has been optimized. \n" +
                " {silver-dollar=3, half-dollar=1, quarter=0, dime=0, nickel=0, penny=0}";

        Main.main(args);

        assertThat(myOut.toString(), CoreMatchers.containsString(expectedOutput));
    }

    @Test
    public void commasAndDollarSignsAreAcceptable() throws Exception {
        String[] args = { "$3,000.50" };
        String expectedOutput = "Your dollar value has been optimized. \n" +
                " {silver-dollar=3000, half-dollar=1, quarter=0, dime=0, nickel=0, penny=0}";

        Main.main(args);

        assertThat(myOut.toString(), CoreMatchers.containsString(expectedOutput));
    }

    @Test
    public void failsPolitelyWhenNoArgumentsAreProvided() throws Exception {
        String[] args = { "" };

        try {
            Main.main(args);
        } catch (ExitSecurityException e) {
            assertThat(myOut.toString(), CoreMatchers.containsString(usageMessage));
        }
    }

    @Test
    public void failsPolitelyWhenTooManyArgumentsAreProvided() throws Exception {
        String[] args = { "3", ".50" };

        try {
            Main.main(args);
        } catch (ExitSecurityException e) {
            assertThat(myOut.toString(), CoreMatchers.containsString(usageMessage));
        }
    }
}