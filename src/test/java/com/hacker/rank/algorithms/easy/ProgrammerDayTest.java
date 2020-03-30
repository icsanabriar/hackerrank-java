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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Class to handle the test cases given on hacker rank website.
 *
 * @author  Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since   1.0.0
 */
public class ProgrammerDayTest {

    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void given_test_case() throws IOException {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "2017" + System.lineSeparator();
        final String expectedOutput = "13.09.2017" + System.lineSeparator();

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        final ProgrammerDay instance = new ProgrammerDay();
        instance.main(args);

        final File file = new File(System.getenv("OUTPUT_PATH"));
        final Scanner sc = new Scanner(file);

        final String[] lines = expectedOutput.split("\\r?\\n");

        int index = 0;

        while (sc.hasNextLine()) {
            assertEquals(lines[index], sc.nextLine());
            index++;
        }

        sc.close();

        System.setIn(sysInBackup);
    }

    @Test
    public void leap_test_case() throws IOException {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "2016" + System.lineSeparator();
        final String expectedOutput = "12.09.2016" + System.lineSeparator();

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ProgrammerDay.main(args);

        final File file = new File(System.getenv("OUTPUT_PATH"));
        final Scanner sc = new Scanner(file);

        final String[] lines = expectedOutput.split("\\r?\\n");

        int index = 0;

        while (sc.hasNextLine()) {
            assertEquals(lines[index], sc.nextLine());
            index++;
        }

        sc.close();

        System.setIn(sysInBackup);
    }

    @Test
    public void past_adjust_test_case() throws IOException {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "1800" + System.lineSeparator();
        final String expectedOutput = "12.09.1800" + System.lineSeparator();

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ProgrammerDay.main(args);

        final File file = new File(System.getenv("OUTPUT_PATH"));
        final Scanner sc = new Scanner(file);

        final String[] lines = expectedOutput.split("\\r?\\n");

        int index = 0;

        while (sc.hasNextLine()) {
            assertEquals(lines[index], sc.nextLine());
            index++;
        }

        sc.close();

        System.setIn(sysInBackup);
    }

    @Test
    public void past_leap_test_case() throws IOException {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "1884" + System.lineSeparator();
        final String expectedOutput = "12.09.1884" + System.lineSeparator();

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ProgrammerDay.main(args);

        final File file = new File(System.getenv("OUTPUT_PATH"));
        final Scanner sc = new Scanner(file);

        final String[] lines = expectedOutput.split("\\r?\\n");

        int index = 0;

        while (sc.hasNextLine()) {
            assertEquals(lines[index], sc.nextLine());
            index++;
        }

        sc.close();

        System.setIn(sysInBackup);
    }

    @Test
    public void change_test_case() throws IOException {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "1918" + System.lineSeparator();
        final String expectedOutput = "26.09.1918" + System.lineSeparator();

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ProgrammerDay.main(args);

        final File file = new File(System.getenv("OUTPUT_PATH"));
        final Scanner sc = new Scanner(file);

        final String[] lines = expectedOutput.split("\\r?\\n");

        int index = 0;

        while (sc.hasNextLine()) {
            assertEquals(lines[index], sc.nextLine());
            index++;
        }

        sc.close();

        System.setIn(sysInBackup);
    }

}
