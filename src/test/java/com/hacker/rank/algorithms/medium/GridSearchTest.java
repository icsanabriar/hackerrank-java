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
package com.hacker.rank.algorithms.medium;

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
public class GridSearchTest {

    /**
     * Define line separator for test cases.
     */
    private static final String SEPARATOR = System.lineSeparator();

    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void given_test_case() throws IOException {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "2" + SEPARATOR +
                "10 10" + SEPARATOR +
                "7283455864" + SEPARATOR +
                "6731158619" + SEPARATOR +
                "8988242643" + SEPARATOR +
                "3830589324" + SEPARATOR +
                "2229505813" + SEPARATOR +
                "5633845374" + SEPARATOR +
                "6473530293" + SEPARATOR +
                "7053106601" + SEPARATOR +
                "0834282956" + SEPARATOR +
                "4607924137" + SEPARATOR +
                "3 4" + SEPARATOR +
                "9505" + SEPARATOR +
                "3845" + SEPARATOR +
                "3530" + SEPARATOR +
                "15 15" + SEPARATOR +
                "400453592126560" + SEPARATOR +
                "114213133098692" + SEPARATOR +
                "474386082879648" + SEPARATOR +
                "522356951189169" + SEPARATOR +
                "887109450487496" + SEPARATOR +
                "252802633388782" + SEPARATOR +
                "502771484966748" + SEPARATOR +
                "075975207693780" + SEPARATOR +
                "511799789562806" + SEPARATOR +
                "404007454272504" + SEPARATOR +
                "549043809916080" + SEPARATOR +
                "962410809534811" + SEPARATOR +
                "445893523733475" + SEPARATOR +
                "768705303214174" + SEPARATOR +
                "650629270887160" + SEPARATOR +
                "2 2" + SEPARATOR +
                "99" + SEPARATOR +
                "99";

        final String expectedOutput = "YES" + SEPARATOR +
                "NO";

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        final GridSearch instance = new GridSearch();
        instance.main(args);

        final String[] lines = expectedOutput.split("\\r?\\n");

        final File file = new File(System.getenv("OUTPUT_PATH"));
        final Scanner sc = new Scanner(file);

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

        final String input = "3" + SEPARATOR +
                "3 3" + SEPARATOR +
                "101" + SEPARATOR +
                "010" + SEPARATOR +
                "111" + SEPARATOR +
                "1 2" + SEPARATOR +
                "11" + SEPARATOR +
                "4 4" + SEPARATOR +
                "1234" + SEPARATOR +
                "5678" + SEPARATOR +
                "8765" + SEPARATOR +
                "4321" + SEPARATOR +
                "2 2" + SEPARATOR +
                "12" + SEPARATOR +
                "56" + SEPARATOR +
                "3 2" + SEPARATOR +
                "13" + SEPARATOR +
                "42" + SEPARATOR +
                "56" + SEPARATOR +
                "3 1" + SEPARATOR +
                "1" + SEPARATOR +
                "4" + SEPARATOR +
                "5";

        final String expectedOutput = "YES" + SEPARATOR +
                "YES" + SEPARATOR +
                "YES";

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        GridSearch.main(args);

        final String[] lines = expectedOutput.split("\\r?\\n");

        final File file = new File(System.getenv("OUTPUT_PATH"));
        final Scanner sc = new Scanner(file);

        int index = 0;

        while (sc.hasNextLine()) {
            assertEquals(lines[index], sc.nextLine());
            index++;
        }

        sc.close();

        System.setIn(sysInBackup);
    }


    @Test
    public void hidden_test_case() throws IOException {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "1" + SEPARATOR +
                "4 6" + SEPARATOR +
                "123412" + SEPARATOR +
                "561212" + SEPARATOR +
                "123634" + SEPARATOR +
                "781288" + SEPARATOR +
                "2 2" + SEPARATOR +
                "12" + SEPARATOR +
                "34";

        final String expectedOutput = "YES";

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        GridSearch.main(args);

        final String[] lines = expectedOutput.split("\\r?\\n");

        final File file = new File(System.getenv("OUTPUT_PATH"));
        final Scanner sc = new Scanner(file);

        int index = 0;

        while (sc.hasNextLine()) {
            assertEquals(lines[index], sc.nextLine());
            index++;
        }

        sc.close();

        System.setIn(sysInBackup);
    }

    @Test
    public void corner_test_case() throws IOException {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "1" + SEPARATOR +
                "2 6" + SEPARATOR +
                "999999" + SEPARATOR +
                "121211" + SEPARATOR +
                "2 2" + SEPARATOR +
                "99" + SEPARATOR +
                "11";

        final String expectedOutput = "YES";

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        GridSearch.main(args);

        final String[] lines = expectedOutput.split("\\r?\\n");

        final File file = new File(System.getenv("OUTPUT_PATH"));
        final Scanner sc = new Scanner(file);

        int index = 0;

        while (sc.hasNextLine()) {
            assertEquals(lines[index], sc.nextLine());
            index++;
        }

        sc.close();

        System.setIn(sysInBackup);
    }

}
