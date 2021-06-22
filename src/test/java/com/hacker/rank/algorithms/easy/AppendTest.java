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
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static org.testng.Assert.assertEquals;

/**
 * Class to handle the test cases given on hacker rank website.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.0.0
 */
public class AppendTest {

    /**
     * Define line separator for test cases.
     */
    private static final String SEPARATOR = System.lineSeparator();

    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void given_test_case() throws IOException {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "hackerhappy" + SEPARATOR +
                "hackerrank" + SEPARATOR +
                "9" + SEPARATOR;

        final String expectedOutput = "Yes" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        final Append instance = new Append();
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
    public void optimal_test_case() throws IOException {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "abcdefgh" + SEPARATOR +
                "xyz" + SEPARATOR +
                "12" + SEPARATOR;

        final String expectedOutput = "Yes" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Append.main(args);

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
    public void negative_test_case() throws IOException {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "ashley" + SEPARATOR +
                "ash" + SEPARATOR +
                "2" + SEPARATOR;

        final String expectedOutput = "No" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Append.main(args);

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
    public void edge_test_case() throws IOException {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "abcd" + SEPARATOR +
                "abcdert" + SEPARATOR +
                "10" + SEPARATOR;

        final String expectedOutput = "No" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Append.main(args);

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
    public void pair_test_case() throws IOException {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "abcd" + SEPARATOR +
                "abcd" + SEPARATOR +
                "1" + SEPARATOR;

        final String expectedOutput = "No" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Append.main(args);

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
    public void empty_no_test_case() throws IOException {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = SEPARATOR +
                "abcd" + SEPARATOR +
                "1" + SEPARATOR;

        final String expectedOutput = "No" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Append.main(args);

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
