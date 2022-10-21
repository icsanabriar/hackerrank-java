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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since 1.3.0
 */
public class Sticks {

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
     * Build prime factor to break the given bar.
     *
     * @param bar Bar to break into prime factors.
     * @return Number of factors the bar could be break.
     */
    private static List<Long> buildFactors(Long bar) {

        final long factor = 2;

        List<Long> factors = new ArrayList<>();

        while (bar % factor == 0) {
            factors.add(factor);
            bar = bar / factor;
        }

        for (long i = factor + 1L; i <= Math.sqrt(bar); i += factor) {
            while (bar % i == 0) {
                factors.add(factor);
                bar = bar / i;
            }
        }

        if (bar > 1)
            factors.add(bar);

        return factors;
    }

    /**
     * Find the longest break for the given list of chocolate bars.
     *
     * @param a List of chocolate bars.
     * @return Maximum number of pieces that could be split the given chocolate bars.
     */
    private static long longestSequence(List<Long> a) {

        long moves = 0;

        for (Long bar : a) {

            long prod = 1;
            List<Long> factors = buildFactors(bar);

            for (int i = factors.size() - 1; i >= 0; i--) {
                prod *= factors.get(i);
                moves += prod;
            }

            moves++;
        }

        return moves;
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

                final int n = Integer.parseInt(
                        bufferedReader.readLine()
                                .trim());

                final List<Long> a = Stream.of(bufferedReader.readLine()
                        .replaceAll(REGEX, REPLACEMENT)
                        .split(SEPARATOR))
                        .map(Long::parseLong)
                        .collect(toList());

                assert a.size() == n;

                long result = longestSequence(a);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            }
        }
    }

}
