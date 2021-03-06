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
package com.hacker.rank.practice.medium;

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
public class PriorityTest {

    /**
     * Define line separator for test cases.
     */
    private static final String SEPARATOR = System.lineSeparator();

    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void given_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "12" + SEPARATOR +
                "ENTER John 3.75 50" + SEPARATOR +
                "ENTER Mark 3.8 24" + SEPARATOR +
                "ENTER Shafaet 3.7 35" + SEPARATOR +
                "SERVED" + SEPARATOR +
                "SERVED" + SEPARATOR +
                "ENTER Samiha 3.85 36" + SEPARATOR +
                "SERVED" + SEPARATOR +
                "ENTER Ashley 3.9 42" + SEPARATOR +
                "ENTER Maria 3.6 46" + SEPARATOR +
                "ENTER Anik 3.95 49" + SEPARATOR +
                "ENTER Dan 3.95 50" + SEPARATOR +
                "SERVED" + SEPARATOR;

        final String expectedOutput = "Dan" + SEPARATOR +
                "Ashley" + SEPARATOR +
                "Shafaet" + SEPARATOR +
                "Maria" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        final Priority instance = new Priority();
        instance.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

    @Test
    public void edge_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "6" + SEPARATOR +
                "ENTER Mario 3.8 50" + SEPARATOR +
                "ENTER Pedro 3.8 24" + SEPARATOR +
                "ENTER Mario 3.8 25" + SEPARATOR +
                "ENTER Mario 3.7 35" + SEPARATOR +
                "SERVED" + SEPARATOR +
                "SERVED" + SEPARATOR;

        final String expectedOutput = "Pedro" + SEPARATOR +
                "Mario" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        Priority.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

    @Test
    public void empty_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "2" + SEPARATOR +
                "ENTER Mario 3.8 50" + SEPARATOR +
                "SERVED" + SEPARATOR;

        final String expectedOutput = "EMPTY" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        Priority.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

}
