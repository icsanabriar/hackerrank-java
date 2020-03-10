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
 * @author  Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since   1.0.0
 */
public class GameTest {

    @Test
    public void given_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "4\n" +
                "5 3\n" +
                "0 0 0 0 0\n" +
                "6 5\n" +
                "0 0 0 1 1 1\n" +
                "6 3\n" +
                "0 0 1 1 1 0\n" +
                "3 1\n" +
                "0 1 0\n";


        final String expectedOutput = "YES\n" +
                "YES\n" +
                "NO\n" +
                "NO\n";

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        Game.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void edge_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "3\n" +
                "11 5\n" +
                "0 1 1 1 0 0 0 0 0 0 1\n" +
                "11 5\n" +
                "0 1 1 1 0 0 1 1 1 0 1\n" +
                "11 5\n" +
                "0 1 1 1 1 0 1 1 1 0 1\n";


        final String expectedOutput = "YES\n" +
                "YES\n" +
                "NO\n";

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        final Game instance = new Game();
        instance.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

}
