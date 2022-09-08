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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
public class Pick {

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
     * Adjust the given value using specific module.
     *
     * @param x Number of current ways specific card could be pick it up.
     * @param y Current card number that could be pick up.
     * @return Number of ways the current card could be pick up adjusted to specify modulus.
     */
    private static int adjustValue(int x, int y) {
        return (int) ((long) x * y % 1000000007);
    }

    /**
     * Retrieves the number of ways the given card list could be pick it up.
     *
     * @param c List of cards.
     * @return Number representing the ways the given card list could be pick it up.
     */
    private static int solve(List<Integer> c) {

        final Map<Integer, Integer> cache = new HashMap<>();

        for (Integer value : c) {
            cache.put(value, cache.getOrDefault(value, 0) + 1);
        }

        int counter = 1;
        int card = 0;

        for (int i = 0; i < c.size(); i++) {
            card = card + cache.getOrDefault(i, 0);

            if (card == 0)
                return 0;

            counter = adjustValue(counter, card);

            card--;
        }

        return counter;
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

                    final int cCount = Integer.parseInt(bufferedReader.readLine().trim());

                    final List<Integer> c = Stream.of(
                            bufferedReader.readLine()
                                    .replaceAll(REGEX, REPLACEMENT)
                                    .split(SEPARATOR))
                            .map(Integer::parseInt)
                            .collect(toList());

                    if (cCount == c.size()) {

                        final String result = String.valueOf(solve(c));

                        bufferedWriter.write(result);
                        bufferedWriter.newLine();
                    }
                }
            }
        }
    }

}
