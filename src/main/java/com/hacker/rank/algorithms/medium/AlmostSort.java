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
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.0.0
 */
public class AlmostSort {

    /**
     * Reverse sublist of the given array using the start and last indexes.
     *
     * @param arr        Array to reverse the sublist.
     * @param startIndex Start index of the sublist to reverse.
     * @param lastIndex  Last index of the sublist to reverse.
     */
    private static void reverseSublist(final List<Integer> arr, final int startIndex, final int lastIndex) {

        for (int i = startIndex, j = lastIndex; i < j; i++, j--) {
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
        }
    }

    /**
     * Compare the given array with sorted version to get the index that differ.
     *
     * @param array  Array given as input of the problem.
     * @param sorted Sorted array.
     * @return List of indexes that differ between the given arrays.
     */
    private static List<Integer> compare(final List<Integer> array, final List<Integer> sorted) {

        return IntStream.range(0, array.size())
                .filter(i -> !array.get(i).equals(sorted.get(i)))
                .boxed()
                .collect(toList());
    }

    /**
     * Find out if the given array is almost sorted or not.
     *
     * @param arr Array to check if it is sorted or not.
     */
    private static String almostSorted(final List<Integer> arr) {

        final List<Integer> sorted = new ArrayList<>(arr);
        Collections.sort(sorted);

        final List<Integer> difference = compare(arr, sorted);

        if (difference.isEmpty())
            return "yes";
        else if (difference.size() == 2)
            return String.format("%s%n%s %d %d", "yes", "swap", difference.get(0) + 1, difference.get(1) + 1);

        reverseSublist(arr,
                difference.get(0),
                difference.get(difference.size() - 1));

        final List<Integer> reverse = compare(arr, sorted);

        if (reverse.isEmpty())
            return String.format("%s%n%s %d %d", "yes", "reverse", difference.get(0) + 1, difference.get(difference.size() - 1) + 1);
        else
            return "no";
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read or write data in the OUTPUT_PATH.
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) throws IOException {

        final BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        final int n = Integer.parseInt(bufferedReader.readLine().trim());

        final List<Integer> arr = Stream.of(
                bufferedReader.readLine()
                        .replaceAll("\\s+$", "")
                        .split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        System.out.println(almostSorted(arr));

        bufferedReader.close();
    }

}
