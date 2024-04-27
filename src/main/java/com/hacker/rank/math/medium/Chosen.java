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
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
public class Chosen {

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
     * Build the array of great common divisor of the given array from left to right.
     *
     * @param a    Array to look the common divisor.
     * @param size Size of the given array.
     * @return List of GCDs.
     */
    private static List<Long> buildLeftGcd(List<Long> a, int size) {

        final List<Long> leftGcd = new ArrayList<>();
        leftGcd.add(a.get(0));

        for (int i = 1; i < size; i++) {
            leftGcd.add(gcd(leftGcd.get(i - 1), a.get(i)));
        }

        return leftGcd;
    }

    /**
     * Build the array of great common divisor of the given array from right to left.
     *
     * @param a    Array to look the common divisor.
     * @param size Size of the given array.
     * @return List of GCDs.
     */
    private static List<Long> buildRightGcd(List<Long> a, int size) {

        final List<Long> rightGcd = new ArrayList<>();
        rightGcd.add(a.get(size - 1));

        for (int i = 1; i < size; i++) {
            rightGcd.add(gcd(rightGcd.get(i - 1), a.get(size - i - 1)));
        }

        Collections.reverse(rightGcd);

        return rightGcd;
    }

    /**
     * Find the common divisor minus 1 element of the given array.
     *
     * @param a    Array to look the common divisor.
     * @param size Size of the array.
     * @return Number representing the common divisor.
     */
    private static Long chose(List<Long> a, int size) {

        if (size == 1)
            return a.get(0) + 1;

        final List<Long> leftGcd = buildLeftGcd(a, size);
        final List<Long> rightGcd = buildRightGcd(a, size);

        for (int i = 0; ; i++) {

            if (i == 0) {

                if (a.get(i) % rightGcd.get(i + 1) != 0)
                    return rightGcd.get(i + 1);

            } else {

                if (a.get(i) % leftGcd.get(i - 1) != 0 && i == size - 1)
                    return leftGcd.get(i - 1);

                final Long otherGcd = gcd(leftGcd.get(i - 1), rightGcd.get(i + 1));

                if (a.get(i) % otherGcd != 0)
                    return otherGcd;
            }
        }
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read data from console.
     */
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            final int n = Integer.parseInt(bufferedReader.readLine().trim());

            final List<Long> a = Stream.of(
                    bufferedReader.readLine()
                            .replaceAll(REGEX, REPLACEMENT)
                            .split(SEPARATOR))
                    .map(Long::parseLong)
                    .toList();

            final Long result = chose(a, n);
            System.out.println(result);
        }
    }

}
