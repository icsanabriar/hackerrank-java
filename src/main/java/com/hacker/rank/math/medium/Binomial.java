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
public class Binomial {

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
     * Estimates the number of binomial coefficients of n that become to 0 after modulo by P.
     *
     * @param n Number of ways to choose.
     * @param p Modulo to calculate binomial coefficients.
     * @return Number of binomial coefficients of n become to 0 after modulo by P.
     */
    private static BigInteger solve(String n, int p) {

        final BigInteger bn = new BigInteger(n);
        final BigInteger bp = BigInteger.valueOf(p);

        BigInteger noZero = BigInteger.ONE;

        for (BigInteger i = bn; !i.equals(BigInteger.ZERO); i = i.divide(bp)) {

            final BigInteger delta = i.mod(bp)
                    .add(BigInteger.ONE);

            noZero = noZero.multiply(delta);
        }

        return bn.add(BigInteger.ONE)
                .subtract(noZero);
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read or write data in the OUTPUT_PATH.
     */
    @SuppressWarnings("Duplicates")
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

                    final String n = firstMultipleInput[0];
                    final int p = Integer.parseInt(firstMultipleInput[1]);

                    final String result = String.valueOf(solve(n, p));

                    bufferedWriter.write(result);
                    bufferedWriter.newLine();
                }
            }
        }
    }

}
