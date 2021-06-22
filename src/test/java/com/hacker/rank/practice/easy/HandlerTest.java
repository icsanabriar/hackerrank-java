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
public class HandlerTest {

    /**
     * Define line separator for test cases.
     */
    private static final String SEPARATOR = System.lineSeparator();

    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void given_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "3 5" + SEPARATOR +
                "2 4" + SEPARATOR +
                "0 0" + SEPARATOR +
                "2 0" + SEPARATOR +
                "0 2" + SEPARATOR +
                "-1 -2" + SEPARATOR +
                "-1 3" + SEPARATOR +
                "1 -3" + SEPARATOR;

        final String expectedOutput = "243" + SEPARATOR +
                "16" + SEPARATOR +
                "java.lang.Exception: n and p should not be zero." + SEPARATOR +
                "1" + SEPARATOR +
                "0" + SEPARATOR +
                "java.lang.Exception: n or p should not be negative." + SEPARATOR +
                "java.lang.Exception: n or p should not be negative." + SEPARATOR +
                "java.lang.Exception: n or p should not be negative." + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        final Handler instance = new Handler();
        instance.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

}
