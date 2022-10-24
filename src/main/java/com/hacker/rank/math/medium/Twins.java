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
import java.util.Arrays;
import java.util.List;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
public class Twins {

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
     * Retrieves the primes using given upper boundary.
     *
     * @param high Upper boundary to generate primes.
     */
    private static List<Integer> retrievePrimes(int high) {

        final boolean[] cache = new boolean[high + 1];
        Arrays.fill(cache, true);

        final List<Integer> primes = new ArrayList<>();

        for (int i = 2; i < cache.length; i++) {
            if (cache[i]) {
                primes.add(i);
                final long start = (long) i * (long) i;
                for (long j = start; j < cache.length; j += i) {
                    int index = (int) j;
                    cache[index] = false;
                }
            }
        }

        return primes;
    }

    /**
     * Find the pair number of primes which difference equals 2 that are inside the given interval [n,m].
     *
     * @param n Lower boundary of the interval to search.
     * @param m Higher boundary of the interval to search.
     * @return Number of pairs found inside the interval.
     */
    private static int solve(int n, int m) {

        final int range = m - n + 1;
        final List<Integer> primes = retrievePrimes(range);

        final boolean[] cache = new boolean[range];
        Arrays.fill(cache, true);

        for (int prime : primes) {
            for (int i = n / prime * prime; i <= m; i = i + prime) {
                if (i >= n && i > prime)
                    cache[i - n] = false;
            }
        }

        int pairs = 0;

        for (int i = 0; i + 2 < cache.length; i++) {
            if (n + i >= 2 && cache[i] && cache[i + 2])
                pairs++;
        }

        return pairs;
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

                final String[] firstMultipleInput = bufferedReader.readLine()
                        .replaceAll(REGEX, REPLACEMENT)
                        .split(SEPARATOR);

                final int n = Integer.parseInt(firstMultipleInput[0]);
                final int m = Integer.parseInt(firstMultipleInput[1]);

                final int result = solve(n, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            }
        }
    }

}
