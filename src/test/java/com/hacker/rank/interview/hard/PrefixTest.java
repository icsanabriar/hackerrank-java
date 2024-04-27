/*
 * Copyright (C) 2023 Iván Camilo Sanabria.
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
package com.hacker.rank.interview.hard;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;

/**
 * Class to handle the test cases given on hacker rank website.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.4.0
 */
public class PrefixTest {

    /**
     * Define line separator for test cases.
     */
    private static final String SEPARATOR = System.lineSeparator();

    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void given_test_case() throws IOException {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "7" + SEPARATOR +
                "aab" + SEPARATOR +
                "defgab" + SEPARATOR +
                "abcde" + SEPARATOR +
                "aabcde" + SEPARATOR +
                "cedaaa" + SEPARATOR +
                "bbbbbbbbbb" + SEPARATOR +
                "jabjjjad" + SEPARATOR;

        final String expectedOutput = "BAD SET" + SEPARATOR +
                "aabcde" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        final Prefix instance = new Prefix();
        instance.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

    @Test
    public void second_test_case() throws IOException {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "3" + SEPARATOR +
                "ab" + SEPARATOR +
                "bc" + SEPARATOR +
                "cd" + SEPARATOR;

        final String expectedOutput = "GOOD SET" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        Prefix.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

    @Test
    public void third_test_case() throws IOException {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "15" + SEPARATOR +
                "hgiiccfchbeadgebc" + SEPARATOR +
                "biiga" + SEPARATOR +
                "edchgb" + SEPARATOR +
                "ccfdbeajaeid" + SEPARATOR +
                "ijgbeecjbj" + SEPARATOR +
                "bcfbbacfbfcfbhcbfjafibfhffac" + SEPARATOR +
                "ebechbfhfcijcjbcehbgbdgbh" + SEPARATOR +
                "ijbfifdbfifaidje" + SEPARATOR +
                "acgffegiihcddcdfjhhgadfjb" + SEPARATOR +
                "ggbdfdhaffhghbdh" + SEPARATOR +
                "dcjaichjejgheiaie" + SEPARATOR +
                "d" + SEPARATOR +
                "jeedfch" + SEPARATOR +
                "ahabicdffbedcbdeceed" + SEPARATOR +
                "eeahhcggaaidifdigcfjbficcfhjj" + SEPARATOR;

        final String expectedOutput = "BAD SET" + SEPARATOR +
                "d" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        Prefix.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

}
