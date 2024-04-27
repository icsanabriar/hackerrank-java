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
 * @since  1.3.0
 */
public class Path {

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
     * Greatest Common Divisor for the given numbers a, b.
     *
     * @param a Number to calculate gcd.
     * @param b Number to calculate gcd.
     * @return Greatest common divisor of the given a,b.
     */
    private static long gcd(long a, long b) {
        return (b == 0) ? Math.max(1, a) : gcd(b, a % b);
    }

    /**
     * Return YES if point with coordinates (x,y) is reachable starting from (a,b) adding a or b units. Otherwise, NO is
     * given on the return statement.
     *
     * @param a X coordinate of starting point.
     * @param b Y coordinate of starting point.
     * @param x X coordinate ending point.
     * @param y Y coordinate ending point.
     * @return A string representing if ending point is reachable or not.
     */
    private static String solve(long a, long b, long x, long y) {
        return gcd(a, b) == gcd(x, y) ? "YES" : "NO";
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

                final int t = Integer.parseInt(bufferedReader.readLine().trim());

                for (int i = 0; i < t; i++) {

                    final String[] firstMultipleInput = bufferedReader.readLine()
                            .replaceAll(REGEX, REPLACEMENT)
                            .split(SEPARATOR);

                    final long a = Long.parseLong(firstMultipleInput[0]);
                    final long b = Long.parseLong(firstMultipleInput[1]);
                    final long x = Long.parseLong(firstMultipleInput[2]);
                    final long y = Long.parseLong(firstMultipleInput[3]);

                    final String result = solve(a, b, x, y);

                    bufferedWriter.write(result);
                    bufferedWriter.newLine();
                }
            }
        }
    }

}
