/*
 * Copyright (C) 2022 Iván Camilo Sanabria.
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
package com.hacker.rank.structures.easy;

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
 * @since  1.3.0
 */
public class LCATest {

    /**
     * Define line separator for test cases.
     */
    private static final String SEPARATOR = System.lineSeparator();

    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void given_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "6" + SEPARATOR +
                "4 2 3 1 7 6" + SEPARATOR +
                "1 7" + SEPARATOR;

        final String expectedOutput = "4" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        final LCA instance = new LCA();
        instance.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

    @Test
    public void right_path_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "15" + SEPARATOR +
                "9 7 8 5 6 4 3 1 10 15 17 18 12 2 14" + SEPARATOR +
                "18 12" + SEPARATOR;

        final String expectedOutput = "15" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        LCA.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

    @Test
    public void left_path_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "15" + SEPARATOR +
                "9 7 8 5 6 4 3 1 10 15 17 18 12 2 14" + SEPARATOR +
                "3 8" + SEPARATOR;

        final String expectedOutput = "7" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        LCA.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

}
