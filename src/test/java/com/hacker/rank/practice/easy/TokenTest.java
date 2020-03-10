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
 * @author  Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since   1.0.0
 */
public class TokenTest {

    @Test
    public void given_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "He is a very very good boy, isn't he?";

        final String expectedOutput = "10\n" +
                "He\n" +
                "is\n" +
                "a\n" +
                "very\n" +
                "very\n" +
                "good\n" +
                "boy\n" +
                "isn\n" +
                "t\n" +
                "he\n";

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        Token.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void edge_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "          YES      leading spaces        are valid,    problemsetters are     evillllll?";

        final String expectedOutput = "8\n" +
                "YES\n" +
                "leading\n" +
                "spaces\n" +
                "are\n" +
                "valid\n" +
                "problemsetters\n" +
                "are\n" +
                "evillllll\n";

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        final Token instance = new Token();
        instance.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void empty_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = " ";

        final String expectedOutput = "0\n";

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        final Token instance = new Token();
        instance.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

}
