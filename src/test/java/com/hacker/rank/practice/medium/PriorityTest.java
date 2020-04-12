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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Class to handle the test cases given on hacker rank website.
 *
 * @author  Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since   1.0.0
 */
public class PriorityTest {

    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void given_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "12" + System.lineSeparator() +
                "ENTER John 3.75 50" + System.lineSeparator() +
                "ENTER Mark 3.8 24" + System.lineSeparator() +
                "ENTER Shafaet 3.7 35" + System.lineSeparator() +
                "SERVED" + System.lineSeparator() +
                "SERVED" + System.lineSeparator() +
                "ENTER Samiha 3.85 36" + System.lineSeparator() +
                "SERVED" + System.lineSeparator() +
                "ENTER Ashley 3.9 42" + System.lineSeparator() +
                "ENTER Maria 3.6 46" + System.lineSeparator() +
                "ENTER Anik 3.95 49" + System.lineSeparator() +
                "ENTER Dan 3.95 50" + System.lineSeparator() +
                "SERVED" + System.lineSeparator();

        final String expectedOutput = "Dan" + System.lineSeparator() +
                "Ashley" + System.lineSeparator() +
                "Shafaet" + System.lineSeparator() +
                "Maria" + System.lineSeparator();

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

        final String input = "6" + System.lineSeparator() +
                "ENTER Mario 3.8 50" + System.lineSeparator() +
                "ENTER Pedro 3.8 24" + System.lineSeparator() +
                "ENTER Mario 3.8 25" + System.lineSeparator() +
                "ENTER Mario 3.7 35" + System.lineSeparator() +
                "SERVED" + System.lineSeparator() +
                "SERVED" + System.lineSeparator();

        final String expectedOutput = "Pedro" + System.lineSeparator() +
                "Mario" + System.lineSeparator();

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

        final String input = "2" + System.lineSeparator() +
                "ENTER Mario 3.8 50" + System.lineSeparator() +
                "SERVED" + System.lineSeparator();

        final String expectedOutput = "EMPTY" + System.lineSeparator();

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        Priority.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

}
