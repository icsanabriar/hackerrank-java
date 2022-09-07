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
package com.hacker.rank.math.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.4.0
 */
public class Counter {

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
     * Return the square of the given number.
     *
     * @param x Number to calculate the square.
     * @return Number representing the square of the given x.
     */
    private static long square(long x) {
        return x * x;
    }

    /**
     * Validates that the given parameters of the square of formula are in range.
     *
     * @param a A parameter of square formula.
     * @param b B parameter of square formula.
     * @param d Discriminant of the square formula.
     * @param x Number to validate.
     * @return A boolean representing if the given value is in range.
     */
    private static boolean outRange(long a, long b, long d, int x) {
        return square((long) x * 2 * a + b) >= d;
    }

    /**
     * Return the number queries that satisfy Watson's formula.
     *
     * @param n Number given as input to validate number of queries.
     * @param k Number given as input to validate number of queries.
     * @return Number of queries that satisfy Watson's formula.
     */
    private static int solve(int n, int k) {

        long a = 1;
        long b = -n;
        long c = (long) n * k;

        long d = b * b - 4 * a * c;

        if (d <= 0) {
            return n - 1;
        }

        int lower = (int) Math.floor((-b - Math.sqrt(d)) / (2 * a));
        while (outRange(a, b, d, lower)) {
            lower++;
        }

        int upper = (int) Math.ceil((-b + Math.sqrt(d)) / (2 * a));
        while (outRange(a, b, d, upper)) {
            upper--;
        }

        return (n - 1) - (upper - lower + 1);
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

                final int q = Integer.parseInt(bufferedReader.readLine().trim());

                for (int i = 0; i < q; i++) {

                    final String[] firstMultipleInput = bufferedReader.readLine()
                            .replaceAll(REGEX, REPLACEMENT)
                            .split(SEPARATOR);

                    final int n = Integer.parseInt(firstMultipleInput[0]);
                    final int k = Integer.parseInt(firstMultipleInput[1]);

                    final String result = String.valueOf(solve(n, k));

                    bufferedWriter.write(result);
                    bufferedWriter.newLine();
                }
            }
        }
    }

}
