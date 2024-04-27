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
package com.hacker.rank.sort.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
public class Count {

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
     * Array to sort using counting sort.
     *
     * @param arr Array to sort.
     * @param n   Size of the given array
     * @return Sorted array after counting sort.
     */
    private static List<Integer> countingSort(final List<Integer> arr, final int n) {

        final int[] counters = new int[100];

        for (Integer value : arr) {
            counters[value]++;
        }

        final List<Integer> results = new ArrayList<>(n);

        for (int i = 0; i < counters.length; i++) {
            for (int j = 0; j < counters[i]; j++) {
                results.add(i);
            }
        }

        return results;
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read or write data in the OUTPUT_PATH.
     */
    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            final int n = Integer.parseInt(bufferedReader.readLine().trim());

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

                final List<Integer> arr = Stream.of(bufferedReader.readLine()
                        .replaceAll(REGEX, REPLACEMENT)
                        .split(SEPARATOR))
                        .map(Integer::parseInt)
                        .toList();

                final List<Integer> result = countingSort(arr, n);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n");
            }
        }
    }
}
