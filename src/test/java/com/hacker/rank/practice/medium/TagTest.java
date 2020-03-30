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
public class TagTest {

    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void given_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "5" + System.lineSeparator() +
                "<h1>Nayeem loves counseling</h1>" + System.lineSeparator() +
                "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>" + System.lineSeparator() +
                "<Amee>safat codes like a ninja</amee>" + System.lineSeparator() +
                "<SA premium>Imtiaz has a secret crush</SA premium>" + System.lineSeparator() +
                "<empty></empty>";

        final String expectedOutput = "Nayeem loves counseling" + System.lineSeparator() +
                "Sanjay has no watch" + System.lineSeparator() +
                "So wait for a while" + System.lineSeparator() +
                "None" + System.lineSeparator() +
                "Imtiaz has a secret crush" + System.lineSeparator() +
                "None" + System.lineSeparator();

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        final Tag instance = new Tag();
        instance.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

}
