/*
 * Copyright (C) 2022 Iván Camilo Sanabria.
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
package com.hacker.rank.math.medium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
public class Power {

    /**
     * Regex used to process input of the program.
     */
    private static final String REGEX = "\\s+$";

    /**
     * Separator of values in same line.
     */
    private static final String SEPARATOR = " ";

    /**
     * Replacement of value inline.
     */
    private static final String REPLACEMENT = "";

    /**
     * Calculates the power using the given a and b parameters.
     *
     * @param a Base to calculate the power.
     * @param b Power to execute the pow operation.
     * @return Power result base on the definition of the problem.
     */
    public static int solve(String a, String b) {

        final BigInteger ba = new BigInteger(a);
        final BigInteger bb = new BigInteger(b);
        final BigInteger m = BigInteger.valueOf(1000000007);

        return ba.modPow(bb, m).intValue();
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read or write data in the OUTPUT_PATH.
     */
    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

                final int t = Integer.parseInt(
                        bufferedReader.readLine()
                                .trim());

                for (int i = 0; i < t; i++) {

                    final String[] firstMultipleInput = bufferedReader.readLine()
                            .replaceAll(REGEX, REPLACEMENT)
                            .split(SEPARATOR);

                    final String a = firstMultipleInput[0];
                    final String b = firstMultipleInput[1];

                    final int result = solve(a, b);

                    bufferedWriter.write(String.valueOf(result));
                    bufferedWriter.newLine();
                }
            }
        }
    }

}
