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
import java.text.NumberFormat;
import java.util.Locale;

import static org.testng.Assert.assertEquals;

/**
 * Class to handle the test cases given on hacker rank website.
 *
 * @author  Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since   1.0.0
 */
public class CurrencyTest {

    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void given_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final NumberFormat nf = NumberFormat.getCurrencyInstance();
        nf.setMaximumFractionDigits(2);

        final String nextLine = System.lineSeparator();
        final String input = "12324.134";
        final double castedInput = Double.parseDouble(input);

        final String expectedOutput = "US: " + nf.getCurrencyInstance(Locale.US).format(castedInput) + nextLine +
                "India: " + nf.getCurrencyInstance(new Locale("en", "IN")).format(castedInput) + nextLine +
                "China: " + nf.getCurrencyInstance(Locale.CHINA).format(castedInput) + nextLine +
                "France: " + nf.getCurrencyInstance(Locale.FRANCE).format(castedInput) + nextLine;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        final Currency instance = new Currency();
        instance.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

}
