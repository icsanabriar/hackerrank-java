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
public class AnnotationTest {

    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void given_test_case() throws Exception {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "4" + System.lineSeparator() +
                "SENIOR 75" + System.lineSeparator() +
                "JUNIOR 45" + System.lineSeparator() +
                "SENIOR 40" + System.lineSeparator() +
                "SENIOR 300" + System.lineSeparator();

        final String expectedOutput = "Senior Member" + System.lineSeparator() +
                "Spend: 75" + System.lineSeparator() +
                "Budget Left: 25" + System.lineSeparator() +
                "Junior Member" + System.lineSeparator() +
                "Spend: 45" + System.lineSeparator() +
                "Budget Left: 5" + System.lineSeparator() +
                "Senior Member" + System.lineSeparator() +
                "Spend: 40" + System.lineSeparator() +
                "Budget Left: 60" + System.lineSeparator() +
                "Budget Limit Over" + System.lineSeparator();

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        final Annotation instance = new Annotation();
        instance.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

}
