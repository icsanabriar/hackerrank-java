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
public class AppendTest {

    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void given_test_case() throws IOException {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "hackerhappy" + System.lineSeparator() +
                "hackerrank" + System.lineSeparator() +
                "9" + System.lineSeparator();

        final String expectedOutput = "Yes" + System.lineSeparator();

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

        final String input = "abcdefgh" + System.lineSeparator() +
                "xyz" + System.lineSeparator() +
                "12" + System.lineSeparator();

        final String expectedOutput = "Yes" + System.lineSeparator();

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

        final String input = "ashley" + System.lineSeparator() +
                "ash" + System.lineSeparator() +
                "2" + System.lineSeparator();

        final String expectedOutput = "No" + System.lineSeparator();

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

        final String input = "abcd" + System.lineSeparator() +
                "abcdert" + System.lineSeparator() +
                "10" + System.lineSeparator();

        final String expectedOutput = "No" + System.lineSeparator();

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

        final String input = "abcd" + System.lineSeparator() +
                "abcd" + System.lineSeparator() +
                "1" + System.lineSeparator();

        final String expectedOutput = "No" + System.lineSeparator();

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

        final String input = System.lineSeparator() +
                "abcd" + System.lineSeparator() +
                "1" + System.lineSeparator();

        final String expectedOutput = "No" + System.lineSeparator();

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
