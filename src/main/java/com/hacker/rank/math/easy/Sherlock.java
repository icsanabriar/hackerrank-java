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
import java.util.List;
import java.util.stream.Stream;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
public class Sherlock {

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
    private static int gcd(int a, int b) {
        return (b == 0) ? Math.max(1, a) : gcd(b, a % b);
    }

    /**
     * Return YES if the given list contains elements that fulfill problem specification.
     *
     * @param a List of number to validate.
     * @return A string representing if the given list could be split in multiple subsets fulfilling the problem specification.
     */
    private static String solve(List<Integer> a) {

        int g = a.get(0);

        for (int i = 1; i < a.size(); i++) {
            g = gcd(g, a.get(i));
        }

        return g == 1 ? "YES" : "NO";
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

                    final int aCount = Integer.parseInt(bufferedReader.readLine().trim());

                    final List<Integer> a = Stream.of(
                            bufferedReader.readLine()
                                    .replaceAll(REGEX, REPLACEMENT)
                                    .split(SEPARATOR))
                            .map(Integer::parseInt).toList();

                    if (aCount == a.size()) {

                        final String result = solve(a);

                        bufferedWriter.write(result);
                        bufferedWriter.newLine();
                    }
                }
            }
        }
    }

}
