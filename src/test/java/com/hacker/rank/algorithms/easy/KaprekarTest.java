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
package com.hacker.rank.algorithms.easy;

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
public class KaprekarTest {

    @Test
    public void given_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "1\n" +
                "99999\n";

        final String expectedOutput = "1 9 45 55 99 297 703 999 2223 2728 4950 5050 7272 7777 9999 17344 " +
                "22222 77778 82656 95121 99999\n";

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        Kaprekar.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void invalid_range_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "400\n" +
                "700\n";

        final String expectedOutput = "INVALID RANGE\n";

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        final Kaprekar instance = new Kaprekar();
        instance.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

}
