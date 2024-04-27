/*
 * Copyright (C) 2020 Iván Camilo Sanabria.
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
package com.hacker.rank.algorithms.medium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.0.0
 */
public class LilyHomework {

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
     * Find the number of swaps required to sort the given array.
     *
     * @param arr    Array to sort and find number of swaps required.
     * @param sorted Sorted array to have as reference to find the number of swaps required.
     * @return Number of swaps required to sort the given array.
     */
    private static int findNumberSwaps(final List<Integer> arr, final List<Integer> sorted) {

        final List<Integer> copy = new ArrayList<>(arr);

        final Map<Integer, Integer> indexing = IntStream.range(0, copy.size())
                .boxed()
                .collect(Collectors.toMap(
                        copy::get,
                        Function.identity()));

        int swaps = 0;

        for (int i = 0; i < copy.size(); i++) {

            final Integer currentAtIndex = copy.get(i);
            final Integer sortedAtIndex = sorted.get(i);

            if (!currentAtIndex.equals(sortedAtIndex)) {

                final int targetIndex = indexing.get(sortedAtIndex);

                indexing.put(sortedAtIndex, i);
                indexing.put(currentAtIndex, targetIndex);

                final Integer temp = copy.get(i);
                final Integer desireValue = copy.get(targetIndex);

                copy.set(i, desireValue);
                copy.set(targetIndex, temp);

                swaps++;
            }
        }

        return swaps;
    }

    /**
     * Array to find minimum number of swaps to make it beautiful.
     *
     * @param arr Array to make it beautiful.
     * @return Minimum number of swaps required to make the given array beautiful.
     */
    private static int lilyHomework(final List<Integer> arr) {

        final List<Integer> ascending = new ArrayList<>(arr);
        Collections.sort(ascending);

        final int ascendingSwap = findNumberSwaps(arr, ascending);

        Collections.reverse(ascending);
        final int descendingSwap = findNumberSwaps(arr, ascending);

        return Math.min(ascendingSwap, descendingSwap);
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read or write data in the OUTPUT_PATH.
     */
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {

        final List<Integer> arr = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            final int n = Integer.parseInt(
                    bufferedReader.readLine()
                            .trim());

            final String[] arrTemp = bufferedReader.readLine()
                    .replaceAll(REGEX, REPLACEMENT)
                    .split(SEPARATOR);

            for (int i = 0; i < n; i++) {
                final int arrItem = Integer.parseInt(arrTemp[i]);
                arr.add(arrItem);
            }
        }

        final int result = lilyHomework(arr);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            bufferedWriter.write(
                    String.valueOf(result));

            bufferedWriter.newLine();
        }
    }

}
