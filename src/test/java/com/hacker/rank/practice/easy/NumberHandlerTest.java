/*
 * Copyright (C) 2020 Iván Camilo Sanabria.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hacker.rank.practice.easy;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;

/**
 * Class to handle the test cases given on hacker rank website.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.0.0
 */
public class NumberHandlerTest {

    /**
     * Define line separator for test cases.
     */
    private static final String SEPARATOR = System.lineSeparator();

    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void given_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "10" + SEPARATOR +
                "3";

        final String expectedOutput = "3" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        final NumberHandler instance = new NumberHandler();
        instance.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

    @Test
    public void opposite_test_case() {

        final String input = "10" + SEPARATOR +
                "hello";

        final String expected = "java.util.InputMismatchException" + SEPARATOR;

        parameterized_test_case(input, expected);
    }


    @Test
    public void divide_zero_test_case() {

        final String input = "10" + SEPARATOR +
                "0";

        final String expected = "java.lang.ArithmeticException: / by zero" + SEPARATOR;

        parameterized_test_case(input, expected);
    }

    @Test
    public void invalid_input_test_case() {

        final String input = "23.323" + SEPARATOR +
                "0";

        final String expected = "java.util.InputMismatchException" + SEPARATOR;

        parameterized_test_case(input, expected);
    }

    /**
     * Abstraction of several test cases to avoid code duplication.
     *
     * @param input    Input given to the program.
     * @param expected Expected output of the program.
     */
    private void parameterized_test_case(String input, String expected) {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        NumberHandler.main(args);

        assertEquals(expected, controllerOut.toString());

        System.setIn(sysInBackup);
    }

}
