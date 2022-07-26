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
public class EncryptionTest {

    /**
     * Define line separator for test cases.
     */
    private static final String SEPARATOR = System.lineSeparator();

    @Test
    public void given_test_case() throws IOException {

        final String input = "haveaniceday";
        final String expected = "hae and via ecy";

        parameterized_test_case(input, expected);
    }

    @Test
    public void second_test_case() throws IOException {

        final String input = "feedthedog";
        final String expected = "fto ehg ee dd";

        parameterized_test_case(input, expected);
    }

    @Test
    public void third_test_case() throws IOException {

        final String input = "chillout";
        final String expected = "clu hlt io";

        parameterized_test_case(input, expected);
    }

    @Test
    public void square_test_case() throws IOException {

        final String input = "peacelove";
        final String expected = "pco eev ale";

        parameterized_test_case(input, expected);
    }

    /**
     * Abstraction of several test cases to avoid code duplication.
     *
     * @param parameter Parameter given to the program.
     * @param expected  Expected output of the program.
     * @throws IOException Thrown when there is a problem processing the given input.
     */
    @SuppressWarnings("AccessStaticViaInstance")
    private void parameterized_test_case(String parameter, String expected) throws IOException {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = parameter + SEPARATOR;
        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        final Encryption instance = new Encryption();
        instance.main(args);

        final File file = new File(System.getenv("OUTPUT_PATH"));
        final Scanner sc = new Scanner(file);

        final String[] lines = expected.split("\\r?\\n");

        int index = 0;

        while (sc.hasNextLine()) {
            assertEquals(lines[index], sc.nextLine());
            index++;
        }

        sc.close();

        System.setIn(sysInBackup);
    }

}
