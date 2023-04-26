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
package com.hacker.rank.interview.easy;

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
 * @since  1.4.0
 */
public class MergeTest {

    /**
     * Define line separator for test cases.
     */
    private static final String SEPARATOR = System.lineSeparator();

    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void given_test_case() throws IOException {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "1" + SEPARATOR +
                "3" + SEPARATOR +
                "1" + SEPARATOR +
                "2" + SEPARATOR +
                "3" + SEPARATOR +
                "2" + SEPARATOR +
                "3" + SEPARATOR +
                "4" + SEPARATOR;

        final String expectedOutput = "1 2 3 3 4" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        final Merge instance = new Merge();
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
    public void second_test_case() throws IOException {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "1" + SEPARATOR +
                "3" + SEPARATOR +
                "4" + SEPARATOR +
                "5" + SEPARATOR +
                "6" + SEPARATOR +
                "3" + SEPARATOR +
                "1" + SEPARATOR +
                "2" + SEPARATOR +
                "3" + SEPARATOR;

        final String expectedOutput = "1 2 3 4 5 6" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Merge.main(args);

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
